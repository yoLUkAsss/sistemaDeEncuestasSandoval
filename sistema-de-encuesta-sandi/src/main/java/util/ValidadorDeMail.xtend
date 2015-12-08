package util

import java.util.List

/**
 * Objeto encargado de validar correos electronicos
 * 
 * @author Sandoval Lucas
 */
class ValidadorDeMail implements Validador{
	 
	
	/**
	 * Dominios para correo precargados
	 */
	private List<String> dominiosAceptados
	
	new() {
		dominiosAceptados = newArrayList("hotmail.com.ar","hotmail.com","live.ar","gmail.com")
	}
	
	/**
	 * Se encarga de validar que un objeto sea (de carácter general) un correo electronico valido
	 * 
	 * @param o Objeto a evaluar
	 * 
	 * @return True si el objeto cumple la condicion de ser un correo valido, False en caso contrario
	 */
	override validar(Object o) {
		if (o != null && o instanceof String ) { 			//Si me dan a validar un String
			var input = o as String
			if (! input.empty && input.contains("@")) { 	//Si ese String no es vacio y posee un «@»
				var index = input.indexOf("@")	
				if (index > 0) {							//Si ademas no comienza con «@»			
					var aValidar = input.substring(index+1)
					return dominiosAceptados.contains(aValidar)
				}
			}
		}
		return false
	}
	
	/**
	 * Permite agregar nuevos dominios aceptados al validador.
	 * 
	 * @param nuevoDominio Dominio aceptado
	 */
	def agregarNuevoDominio(String nuevoDominio) {
		dominiosAceptados.add(nuevoDominio)
	}
	
	
}