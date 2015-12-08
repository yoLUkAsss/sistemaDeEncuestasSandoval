package appModel

import domain.Materia
import domain.Turno
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.utils.Observable
import static org.uqbar.commons.model.ObservableUtils.*
import domain.Carrera
import domain.Inscripcion
import util.ValidadorDeMail
import domain.Encuesta

/**
 * App Model que utilizado para la vista de la creacion de encuestas, del sistema "Creador de Encuestas"
 * 
 * @author Sandoval Lucas
 */
@Observable
@Accessors
class CreadorDeEncuestaAppModel {
	
	Integer anioIngreso 						//Año de ingreso
	Integer finalesAprobados					//Cantidad de finales aprobados (puede quedar nulo)
	Integer finalesDesaprobados					//Cantidad de finales desaprobados (puede quedar nulo)
	Integer cursadasAprobadas					//Cantidad de cursadas aprobadas (puede quedar nulo)
	Turno turnoSeleccionado						//Turno seleccionado, para la creacion de una inscripcion
	String mailIngresado						//Mail ingresado (informacion obligatoria)
	List<Inscripcion> inscripcionesAlMomento	//Lista de inscripcion (por carrera)
	List<Carrera> carrerasAElegir				//Lista de carreras totales del sistema
	Carrera carreraActual						//Carrera seleccionada como actual (o elegida)
	List<Materia> materiasAElegir				//Lista de materias totales de una carrera especifica
	Materia materiaSeleccionada					//Materia seleccionada como actual (o elegida)
	
	/**
	 * Constructor 
	 * 
	 * @param carrerasPrincipales Carreras totales del sistema
	 */
	new(List<Carrera> carrerasPrincipales){
		carrerasAElegir = carrerasPrincipales
		inscripcionesAlMomento = newArrayList
	}
	
	/**
	 * Se encarga de validar e ingresar una nueva inscripcion al sistema, junto a la materia y 
	 * al turno elegidos.
	 */
	def agregarInscripcion() {
		this.validarYAgregar()
	} 
	
	/**
	 * Retorna todas las carreras del sistema.
	 */
	def List<String> getCarrerasPosibles(){
		carrerasAElegir.map[it.nombreDeCarrera]
	}

	/**
	 * Retorna todas las materias posibles de la carrera actual elegida
	 */
	def List<String> getMateriasPosibles() {
		materiasAElegir = obtenerMateriasDeCarrera(carreraActual)
		return materiasAElegir.map[it.descripcion]
	}
	
	/**
	 * Retorna todos los turnos posibles
	 */
	def List<Turno> getTurnosPosibles() { Turno.values.toList }
	
	/**
	 * Al recibir una nueva carrera para definir como actual (o elegida), actualiza cuales son las 
	 * nuevas materias a elegir.
	 * 
	 * @param otraCarrera Carrera nueva elegida
	 * 
	 * @note Al utilizarse, se limpian las inscripciones hasta el momento
	 */
	@Observable
	def setCarreraActual(Carrera otraCarrera){
		carreraActual = otraCarrera
		materiasAElegir = carreraActual.materiasObligatorias
		inscripcionesAlMomento = newArrayList
		firePropertyChanged(this,"carreraActual",carreraActual)
		firePropertyChanged(this,"materiasAElegir",materiasAElegir)
		firePropertyChanged(this,"inscripcionesAlMomento",inscripcionesAlMomento)
	}
	
	/**
	 * Se encarga de validar toda la informacion necesiar para crear una nueva inscripcion.
	 * Luego la crea y actualiza informacion
	 * 
	 * @param nuevaMateriaAAgregar Materia elegida
	 * @param turnoElegido Turno para la inscripcion
	 */
	def validarYAgregar() {
		if (! camposDeNuevaInscripcionCorrectos) { throw new Exception("Aun quedan elementos sin completar") }
		var nuevaInscripcion = new Inscripcion(materiaSeleccionada,turnoSeleccionado)
		if (inscripcionYaExiste(nuevaInscripcion)) { throw new Exception("No es posible inscribirse a una misma materia 2 veces") }
		this.inscripcionesAlMomento.add(nuevaInscripcion)
		firePropertyChanged(this,"inscripcionesAlMomento",inscripcionesAlMomento)
	}
	
	/**
	 * Se encarga de validar que la informacion para una nueva inscripcion sea correcta
	 */
	def camposDeNuevaInscripcionCorrectos() {
		return (turnoSeleccionado != null && materiaSeleccionada != null)
	}
	
	/**
	 * Se encarga de validar si la informacion obligatoria para crear una encuesta, esta correcta
	 */
	def camposDeNuevaEncuestaCorrectos(){
		return (anioIngreso != null && carreraActual != null && mailEsValido)
	}
	
	/**
	 * Se encarga de validar si una inscripcion ya se encuentra anotada en el sistema
	 * 
	 * @param inscripcionAVerificar Inscripcion a validar
	 */
	def inscripcionYaExiste(Inscripcion inscripcionAVerificar) {
		return this.inscripcionesAlMomento.contains(inscripcionAVerificar)
	}
	
	/**
	 * Se encarga de validar toda la informacion necesaria para crear una encuesta correctamente
	 */
	def validarEncuesta() {
		if (! mailEsValido) throw new Exception("El mail ingresado es invalido")
		if (! añoIngresoValido) throw new Exception("El año ingresado es incorrecto")
		if (! cursadasAprobadasValido) throw new Exception("No es posible tener mas finales que cursadas aprobadas")
		if (! materiasCumple) throw new Exception("Debe ingresar al menos una materia")
		if (! camposDeNuevaEncuestaCorrectos) throw new Exception("Aun quedan elementos sin completar")
	}
	
	/**
	 * Se encarga de validar que haya suficientes inscripciones a materias de una carrera especifica
	 */
	def materiasCumple() {
		return inscripcionesAlMomento.size >= 1
	}
	
	/**
	 * Se encarga de validar informacion sobre el año de ingreso ingresado al sistema
	 */
	def añoIngresoValido() {
		return (anioIngreso != null && anioIngreso <= 2015 && anioIngreso > 1900)
				||
			   (anioIngreso == null)
	}

	/**
	 * Se encarga de validar informacion sobre los finales y cursadas aprobadas
	 */
	def cursadasAprobadasValido() {
		return (cursadasAprobadas != null && finalesAprobados != null && cursadasAprobadas > finalesAprobados)
				||
			   (cursadasAprobadas == null || finalesAprobados == null) 
	}
	
	/**
	 * Se encarga de validar los datos y obtener una encuesta en base a ellos.
	 */
	def enviarEncuesta(){ 
		this.validarEncuesta()
		return crearEncuestaFinal()
	}
	
	/**
	 * Se encarga de obtener la List«Materia» de una carrera especifica
	 * 
	 * @param carreraEnLaCualBuscar Carrera especifica sobre la cual buscar
	 */
	def obtenerMateriasDeCarrera(Carrera carreraEnLaCualBuscar) {
		var buscada = this.carrerasAElegir.findFirst[carrera | carrera.equals(carreraEnLaCualBuscar)]
		buscada.materiasObligatorias
	}
	
	/**
	 * @return True en caso de que el mail ingresado sea valido, False caso contrario
	 */
	def mailEsValido() {
		return (new ValidadorDeMail).validar(mailIngresado)
	}
	
	/**
	 * Se encarga de recolecar los datos necesarios y crear un objeto Encuesta
	 * 
	 * @see Encuesta
	 */
	def crearEncuestaFinal(){
		return new Encuesta(inscripcionesAlMomento,carreraActual,mailIngresado,anioIngreso)
	}
	
}