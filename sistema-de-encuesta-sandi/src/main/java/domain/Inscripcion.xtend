package domain

import org.uqbar.commons.utils.Observable
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Objeto que representa al concepto de inscripcion de una materia, junto a un turno
 * 
 * @author Sandoval Lucas
 */
@Observable
@Accessors
class Inscripcion {
	
	Materia materiaElegida
	Turno turnoElegido
	
	/**
	 * Constructor 
	 * 
	 * @param nuevaMateria Materia a la cual inscribirse
	 * @param nuevoTurno Turno elegido para la inscripcion
	 * 
	 * @see Turno
	 */
	new (Materia nuevaMateria , Turno nuevoTurno){
		this.materiaElegida = nuevaMateria
		this.turnoElegido = nuevoTurno
	}
	
	/**
	 * Reescritura del metodo equals para la colaboracion con las colecciones.
	 */
	override equals(Object elemento) {
		if (elemento != null && elemento instanceof Inscripcion) {
			var otraInscripcion = elemento as Inscripcion
			return this.materiaElegida.equals(otraInscripcion.materiaElegida)
		}
		return false
	}
	
	/**
	 * Reescritura del metodo toString para definir un formato nuevo al mostrar una Inscripcion
	 */
	override toString() {
		return '''Materia elegida: «materiaElegida.descripcion», Turno elegido: «turnoElegido.name»'''
	}
	
}