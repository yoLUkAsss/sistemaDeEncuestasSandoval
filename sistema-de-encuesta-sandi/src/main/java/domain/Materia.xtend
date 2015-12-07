package domain

import org.uqbar.commons.utils.Observable
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Objeto que representa a una materia (valga la redundancia =D)
 * 
 * @author Sandoval Lucas
 */
@Observable
@Accessors
class Materia {
	
	String descripcion
	
	/**
	 * Constructor
	 * 
	 * @param nuevaDescripcion Funciona como nombre de materia hasta este momento
	 */
	new (String nuevaDescripcion) {
		this.descripcion = nuevaDescripcion
	}
	
	/**
	 * Reescritura del metodo equals para colaborar junto a las colecciones
	 */
	override equals(Object elemento) {
		if (elemento != null && elemento instanceof Materia){
			var otraMateria = elemento as Materia
			return this.descripcion.equals(otraMateria.descripcion)
		}
		return false
	}
	
}