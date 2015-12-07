package domain

import org.uqbar.commons.utils.Observable
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List

/**
 * Representacion de una encuesta. 
 * 	Una encuesta indica, una carrera universitaria
 * 	Inscripciones a materias de dicha carrera
 * 	Un email registrado para posibles comunicaciones
 * 	Año de ingreso
 * 
 * @author Sandoval Lucas
 */
@Observable
@Accessors
class Encuesta {
	
	
	List<Inscripcion> posiblesInscripciones
	Carrera carreraEnCurso
	String email
	Integer anioIngreso
	
	/**
	 * Constructor
	 */
	new(List<Inscripcion> nuevasInscripciones , Carrera nuevaCarrera , String emailIngresado, Integer anioIngreso){
		this.posiblesInscripciones = nuevasInscripciones
		this.carreraEnCurso = nuevaCarrera
		this.email = emailIngresado
		this.anioIngreso = anioIngreso
	}
}