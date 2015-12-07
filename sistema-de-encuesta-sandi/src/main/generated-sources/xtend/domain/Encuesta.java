package domain;

import domain.Carrera;
import domain.Inscripcion;
import java.util.List;
import javax.annotation.Generated;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

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
@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class Encuesta {
  private List<Inscripcion> posiblesInscripciones;
  
  private Carrera carreraEnCurso;
  
  private String email;
  
  private Integer anioIngreso;
  
  /**
   * Constructor
   */
  public Encuesta(final List<Inscripcion> nuevasInscripciones, final Carrera nuevaCarrera, final String emailIngresado, final Integer anioIngreso) {
    this.posiblesInscripciones = nuevasInscripciones;
    this.carreraEnCurso = nuevaCarrera;
    this.email = emailIngresado;
    this.anioIngreso = anioIngreso;
  }
  
  @Pure
  public List<Inscripcion> getPosiblesInscripciones() {
    return this.posiblesInscripciones;
  }
  
  public void setPosiblesInscripciones(final List<Inscripcion> posiblesInscripciones) {
    this.posiblesInscripciones = posiblesInscripciones;
  }
  
  @Pure
  public Carrera getCarreraEnCurso() {
    return this.carreraEnCurso;
  }
  
  public void setCarreraEnCurso(final Carrera carreraEnCurso) {
    this.carreraEnCurso = carreraEnCurso;
  }
  
  @Pure
  public String getEmail() {
    return this.email;
  }
  
  public void setEmail(final String email) {
    this.email = email;
  }
  
  @Pure
  public Integer getAnioIngreso() {
    return this.anioIngreso;
  }
  
  public void setAnioIngreso(final Integer anioIngreso) {
    this.anioIngreso = anioIngreso;
  }
}
