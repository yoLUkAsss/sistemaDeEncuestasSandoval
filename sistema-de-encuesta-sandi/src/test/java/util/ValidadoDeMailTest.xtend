package util

import org.junit.Before
import org.junit.Test
import static org.junit.Assert.*

class ValidadoDeMailTest {
	
	ValidadorDeMail SUT
	String mailCorrecto
	String mailIncorrecto
	String mailPotencialmenteCorrecto
	
	@Before
	def void init(){
		SUT = new ValidadorDeMail
		mailCorrecto = "algo@gmail.com"
		mailIncorrecto = "nosoycorrecto"
		mailPotencialmenteCorrecto = "podriaSerloPeroNo@noSirvo.edu.ar"
	}
	
	@Test
	def void test_funciona_con_dominios_existentes() {
		assertTrue(SUT.validar(mailCorrecto))
	}
	
	@Test
	def void test_sin_arroba_no_es_valido() {
		assertFalse(SUT.validar(mailIncorrecto))
	}
	
	@Test
	def void test_no_funciona_con_dominios_inexistentes_o_no_cargados() {
		assertFalse(SUT.validar(mailPotencialmenteCorrecto))
	}
	
	@Test
	def void test_agrego_nuevo_dominio_y_funciona_correctamente() {
		SUT.agregarNuevoDominio("noSirvo.edu.ar")
		
		assertTrue(SUT.validar(mailPotencialmenteCorrecto))
	}
	
}