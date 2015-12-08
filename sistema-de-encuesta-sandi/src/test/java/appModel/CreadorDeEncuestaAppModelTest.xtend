package appModel

import org.junit.Before
import org.junit.Test
import static org.junit.Assert.*
import java.util.List
import domain.Turno
import domain.Inscripcion
import domain.Carrera
import domain.Materia

class CreadorDeEncuestaAppModelTest {
	
	CreadorDeEncuestaAppModel SUT
	List<Carrera> carrerasAElegir
	Carrera carrera1 ; Carrera carrera2 ; Carrera carrera3
	Materia materia11;Materia materia12;Materia materia21;Materia materia22;
	Materia materia23;Materia materia31;Materia materia32;Materia materia33;
	
	
	@Before
	def void init(){
		carrera1 = new Carrera("Ingenieria en Computacion")
		carrera2 = new Carrera("Licenciatura en Informatica")
		carrera3 = new Carrera("Experto en cosas")
		
		materia11 = new Materia("Programacion 1")
		materia12 = new Materia("Matematica A")
		carrera1.agregarNuevaMateria(materia11)
		carrera1.agregarNuevaMateria(materia12)
		
		materia21 = new Materia("Introduccion a la Programacion")
		materia22 = new Materia("Organizacion de Computadoras")
		materia23 = new Materia("Matematica 1")
		carrera2.agregarNuevaMateria(materia21)
		carrera2.agregarNuevaMateria(materia22)
		carrera2.agregarNuevaMateria(materia23)
		
		materia31 = new Materia("Cosas 1")
		materia32 = new Materia("Cosas 2")
		materia33 = new Materia("Cosas avanzadas")
		carrera3.agregarNuevaMateria(materia31)
		carrera3.agregarNuevaMateria(materia32)
		carrera3.agregarNuevaMateria(materia33)
		
		carrerasAElegir = newArrayList(carrera1,carrera2,carrera3)
		
		SUT = new CreadorDeEncuestaAppModel(carrerasAElegir)
	}
	
	@Test(expected = Exception)
	def void test_sin_elementos_validos_la_creacion_de_inscripcion_falla() {
		SUT.agregarInscripcion
	}
	
	@Test
	def void test_con_elementos_completos_inscripcion_valida() {
		SUT.materiaSeleccionada = materia23
		SUT.turnoSeleccionado = Turno.Tarde
		var expected = new Inscripcion(materia23,Turno.Tarde)
		SUT.agregarInscripcion
		
		assertTrue(SUT.inscripcionesAlMomento.contains(expected))
	}
	
	@Test(expected = Exception)
	def void test_si_la_inscripcion_se_hizo_no_es_posible_inscribirse_nuevamente() {
		SUT.materiaSeleccionada = materia23
		SUT.turnoSeleccionado = Turno.Tarde
		SUT.agregarInscripcion
		SUT.agregarInscripcion
	}
	
	@Test
	def void test_obtener_materias_de_cierta_carrera_funciona_correctamente() {
		var expected = carrera1.materiasObligatorias
		
		assertEquals(SUT.obtenerMateriasDeCarrera(carrera1) , expected) 
	}
	
	@Test
	def void test_validar_el_año_da_false_si_es_mayor_de_2015() {
		SUT.anioIngreso = 2016
		
		assertFalse(SUT.añoIngresoValido)
	}
	
	@Test
	def void test_validar_el_año_da_false_si_es_menor_de_1900() {
		SUT.anioIngreso = 1899
		
		assertFalse(SUT.añoIngresoValido)
	}
	
	@Test(expected = Exception)
	def void test_con_valores_incoherentes_sobre_cursadas_devuelve_exception() {
		SUT.mailIngresado = "esteMailVale@hotmail.com"
		SUT.anioIngreso = 2015
		SUT.carreraActual = carrera3
		SUT.cursadasAprobadas = 15
		SUT.finalesAprobados = 20
		
		SUT.validarEncuesta
	}
	
	@Test
	def void test_con_todos_los_campos_completados_se_crea_una_encuesta_con_año_ingreso() {
		SUT.mailIngresado = "esteMailVale@hotmail.com"
		SUT.anioIngreso = 2001
		SUT.carreraActual = carrera3
		SUT.materiaSeleccionada = materia33
		SUT.turnoSeleccionado = Turno.Mañana
		SUT.agregarInscripcion
			
		var resultado = SUT.enviarEncuesta
		
		assertEquals(resultado.anioIngreso , 2001)
	}
	
	@Test
	def void test_con_todos_los_campos_completados_se_crea_una_encuesta_de_carrera() {
		SUT.mailIngresado = "esteMailVale@hotmail.com"
		SUT.anioIngreso = 2015
		SUT.carreraActual = carrera3
		SUT.cursadasAprobadas = 25
		SUT.finalesAprobados = 20
		SUT.materiaSeleccionada = materia33
		SUT.turnoSeleccionado = Turno.Mañana
		SUT.agregarInscripcion
			
		var resultado = SUT.enviarEncuesta
		
		assertEquals(resultado.carreraEnCurso , carrera3)
	}
	
	@Test
	def void test_con_todos_los_campos_completados_se_crea_una_encuesta_con_inscripciones() {
		SUT.mailIngresado = "esteMailVale@hotmail.com"
		SUT.anioIngreso = 2001
		SUT.carreraActual = carrera2
		SUT.cursadasAprobadas = 25
		SUT.finalesAprobados = 20
		SUT.materiaSeleccionada = materia23
		SUT.turnoSeleccionado = Turno.Mañana
		SUT.agregarInscripcion
		SUT.materiaSeleccionada = materia21
		SUT.turnoSeleccionado = Turno.Noche
		SUT.agregarInscripcion
		
		var expected = newArrayList(new Inscripcion(materia23,Turno.Mañana),new Inscripcion(materia21,Turno.Noche))
			
		var resultado = SUT.enviarEncuesta
		
		assertEquals(resultado.posiblesInscripciones , expected)
	}
	
	@Test
	def void test_con_todos_los_campos_completados_se_crea_una_encuesta_con_mail_registrado() {
		SUT.mailIngresado = "esteMailVale@hotmail.com"
		SUT.anioIngreso = 2015
		SUT.carreraActual = carrera3
		SUT.cursadasAprobadas = 25
		SUT.finalesAprobados = 20
		SUT.materiaSeleccionada = materia33
		SUT.turnoSeleccionado = Turno.Mañana
		SUT.agregarInscripcion
			
		var resultado = SUT.enviarEncuesta
		
		assertEquals(resultado.email , "esteMailVale@hotmail.com")
	}
	
}