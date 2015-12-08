package appModel;

import appModel.CreadorDeEncuestaAppModel;
import domain.Carrera;
import domain.Encuesta;
import domain.Inscripcion;
import domain.Materia;
import domain.Turno;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class CreadorDeEncuestaAppModelTest {
  private CreadorDeEncuestaAppModel SUT;
  
  private List<Carrera> carrerasAElegir;
  
  private Carrera carrera1;
  
  private Carrera carrera2;
  
  private Carrera carrera3;
  
  private Materia materia11;
  
  private Materia materia12;
  
  private Materia materia21;
  
  private Materia materia22;
  
  private Materia materia23;
  
  private Materia materia31;
  
  private Materia materia32;
  
  private Materia materia33;
  
  @Before
  public void init() {
    Carrera _carrera = new Carrera("Ingenieria en Computacion");
    this.carrera1 = _carrera;
    Carrera _carrera_1 = new Carrera("Licenciatura en Informatica");
    this.carrera2 = _carrera_1;
    Carrera _carrera_2 = new Carrera("Experto en cosas");
    this.carrera3 = _carrera_2;
    Materia _materia = new Materia("Programacion 1");
    this.materia11 = _materia;
    Materia _materia_1 = new Materia("Matematica A");
    this.materia12 = _materia_1;
    this.carrera1.agregarNuevaMateria(this.materia11);
    this.carrera1.agregarNuevaMateria(this.materia12);
    Materia _materia_2 = new Materia("Introduccion a la Programacion");
    this.materia21 = _materia_2;
    Materia _materia_3 = new Materia("Organizacion de Computadoras");
    this.materia22 = _materia_3;
    Materia _materia_4 = new Materia("Matematica 1");
    this.materia23 = _materia_4;
    this.carrera2.agregarNuevaMateria(this.materia21);
    this.carrera2.agregarNuevaMateria(this.materia22);
    this.carrera2.agregarNuevaMateria(this.materia23);
    Materia _materia_5 = new Materia("Cosas 1");
    this.materia31 = _materia_5;
    Materia _materia_6 = new Materia("Cosas 2");
    this.materia32 = _materia_6;
    Materia _materia_7 = new Materia("Cosas avanzadas");
    this.materia33 = _materia_7;
    this.carrera3.agregarNuevaMateria(this.materia31);
    this.carrera3.agregarNuevaMateria(this.materia32);
    this.carrera3.agregarNuevaMateria(this.materia33);
    ArrayList<Carrera> _newArrayList = CollectionLiterals.<Carrera>newArrayList(this.carrera1, this.carrera2, this.carrera3);
    this.carrerasAElegir = _newArrayList;
    CreadorDeEncuestaAppModel _creadorDeEncuestaAppModel = new CreadorDeEncuestaAppModel(this.carrerasAElegir);
    this.SUT = _creadorDeEncuestaAppModel;
  }
  
  @Test(expected = Exception.class)
  public void test_sin_elementos_validos_la_creacion_de_inscripcion_falla() {
    this.SUT.agregarInscripcion();
  }
  
  @Test
  public void test_con_elementos_completos_inscripcion_valida() {
    this.SUT.setMateriaSeleccionada(this.materia23);
    this.SUT.setTurnoSeleccionado(Turno.Tarde);
    Inscripcion expected = new Inscripcion(this.materia23, Turno.Tarde);
    this.SUT.agregarInscripcion();
    List<Inscripcion> _inscripcionesAlMomento = this.SUT.getInscripcionesAlMomento();
    boolean _contains = _inscripcionesAlMomento.contains(expected);
    Assert.assertTrue(_contains);
  }
  
  @Test(expected = Exception.class)
  public void test_si_la_inscripcion_se_hizo_no_es_posible_inscribirse_nuevamente() {
    this.SUT.setMateriaSeleccionada(this.materia23);
    this.SUT.setTurnoSeleccionado(Turno.Tarde);
    this.SUT.agregarInscripcion();
    this.SUT.agregarInscripcion();
  }
  
  @Test
  public void test_obtener_materias_de_cierta_carrera_funciona_correctamente() {
    List<Materia> expected = this.carrera1.getMateriasObligatorias();
    List<Materia> _obtenerMateriasDeCarrera = this.SUT.obtenerMateriasDeCarrera(this.carrera1);
    Assert.assertEquals(_obtenerMateriasDeCarrera, expected);
  }
  
  @Test
  public void test_validar_el_año_da_false_si_es_mayor_de_2015() {
    this.SUT.setAnioIngreso(Integer.valueOf(2016));
    boolean _añoIngresoValido = this.SUT.añoIngresoValido();
    Assert.assertFalse(_añoIngresoValido);
  }
  
  @Test
  public void test_validar_el_año_da_false_si_es_menor_de_1900() {
    this.SUT.setAnioIngreso(Integer.valueOf(1899));
    boolean _añoIngresoValido = this.SUT.añoIngresoValido();
    Assert.assertFalse(_añoIngresoValido);
  }
  
  @Test(expected = Exception.class)
  public void test_con_valores_incoherentes_sobre_cursadas_devuelve_exception() {
    this.SUT.setMailIngresado("esteMailVale@hotmail.com");
    this.SUT.setAnioIngreso(Integer.valueOf(2015));
    this.SUT.setCarreraActual(this.carrera3);
    this.SUT.setCursadasAprobadas(Integer.valueOf(15));
    this.SUT.setFinalesAprobados(Integer.valueOf(20));
    this.SUT.validarEncuesta();
  }
  
  @Test
  public void test_con_todos_los_campos_completados_se_crea_una_encuesta_con_año_ingreso() {
    this.SUT.setMailIngresado("esteMailVale@hotmail.com");
    this.SUT.setAnioIngreso(Integer.valueOf(2001));
    this.SUT.setCarreraActual(this.carrera3);
    this.SUT.setMateriaSeleccionada(this.materia33);
    this.SUT.setTurnoSeleccionado(Turno.Mañana);
    this.SUT.agregarInscripcion();
    Encuesta resultado = this.SUT.enviarEncuesta();
    Integer _anioIngreso = resultado.getAnioIngreso();
    Assert.assertEquals((_anioIngreso).intValue(), 2001);
  }
  
  @Test
  public void test_con_todos_los_campos_completados_se_crea_una_encuesta_de_carrera() {
    this.SUT.setMailIngresado("esteMailVale@hotmail.com");
    this.SUT.setAnioIngreso(Integer.valueOf(2015));
    this.SUT.setCarreraActual(this.carrera3);
    this.SUT.setCursadasAprobadas(Integer.valueOf(25));
    this.SUT.setFinalesAprobados(Integer.valueOf(20));
    this.SUT.setMateriaSeleccionada(this.materia33);
    this.SUT.setTurnoSeleccionado(Turno.Mañana);
    this.SUT.agregarInscripcion();
    Encuesta resultado = this.SUT.enviarEncuesta();
    Carrera _carreraEnCurso = resultado.getCarreraEnCurso();
    Assert.assertEquals(_carreraEnCurso, this.carrera3);
  }
  
  @Test
  public void test_con_todos_los_campos_completados_se_crea_una_encuesta_con_inscripciones() {
    this.SUT.setMailIngresado("esteMailVale@hotmail.com");
    this.SUT.setAnioIngreso(Integer.valueOf(2001));
    this.SUT.setCarreraActual(this.carrera2);
    this.SUT.setCursadasAprobadas(Integer.valueOf(25));
    this.SUT.setFinalesAprobados(Integer.valueOf(20));
    this.SUT.setMateriaSeleccionada(this.materia23);
    this.SUT.setTurnoSeleccionado(Turno.Mañana);
    this.SUT.agregarInscripcion();
    this.SUT.setMateriaSeleccionada(this.materia21);
    this.SUT.setTurnoSeleccionado(Turno.Noche);
    this.SUT.agregarInscripcion();
    Inscripcion _inscripcion = new Inscripcion(this.materia23, Turno.Mañana);
    Inscripcion _inscripcion_1 = new Inscripcion(this.materia21, Turno.Noche);
    ArrayList<Inscripcion> expected = CollectionLiterals.<Inscripcion>newArrayList(_inscripcion, _inscripcion_1);
    Encuesta resultado = this.SUT.enviarEncuesta();
    List<Inscripcion> _posiblesInscripciones = resultado.getPosiblesInscripciones();
    Assert.assertEquals(_posiblesInscripciones, expected);
  }
  
  @Test
  public void test_con_todos_los_campos_completados_se_crea_una_encuesta_con_mail_registrado() {
    this.SUT.setMailIngresado("esteMailVale@hotmail.com");
    this.SUT.setAnioIngreso(Integer.valueOf(2015));
    this.SUT.setCarreraActual(this.carrera3);
    this.SUT.setCursadasAprobadas(Integer.valueOf(25));
    this.SUT.setFinalesAprobados(Integer.valueOf(20));
    this.SUT.setMateriaSeleccionada(this.materia33);
    this.SUT.setTurnoSeleccionado(Turno.Mañana);
    this.SUT.agregarInscripcion();
    Encuesta resultado = this.SUT.enviarEncuesta();
    String _email = resultado.getEmail();
    Assert.assertEquals(_email, "esteMailVale@hotmail.com");
  }
}
