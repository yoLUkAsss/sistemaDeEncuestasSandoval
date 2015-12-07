package domain

import java.util.List
import org.uqbar.commons.utils.Observable
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Objeto para la representacion de una Carrera universitaria
 */
@Observable
@Accessors
class Carrera {
	
	String nombreDeCarrera
	List<Materia> materiasObligatorias
	
	/**
	 * Constructor 
	 * 
	 * @param nuevoNombreDeCarrera El nombre que recibira la carrera
	 */
	new(String nuevoNombreDeCarrera) {
		this.materiasObligatorias = newArrayList
		this.nombreDeCarrera = nuevoNombreDeCarrera
	}
	
	/**
	 * Agregar una materia
	 * 
	 * @param nuevaMateria Materia a ser agregada a la carrera
	 */
	def agregarNuevaMateria(Materia nuevaMateria){
		this.materiasObligatorias.add(nuevaMateria)
	}
	
	/**
	 * Eliminar una materia
	 * 
	 * @param materiaAEliminar Materia a ser eliminada a la carrera
	 */
	def eliminarMateria(Materia materiaAEliminar) {
		this.materiasObligatorias.remove(materiaAEliminar)
	}
	
	/**
	 * Reescritura del metodo equals para colaborar junto a las colecciones
	 */
	override equals(Object elemento) {
		if (elemento != null && elemento instanceof Carrera){
			var otraCarrera = elemento as Carrera
			return this.nombreDeCarrera.equals(otraCarrera.nombreDeCarrera)
		}
		return false
	}
}