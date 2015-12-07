package domain;

import com.google.common.base.Objects;
import domain.Materia;
import domain.Turno;
import javax.annotation.Generated;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

/**
 * Objeto que representa al concepto de inscripcion de una materia, junto a un turno
 * 
 * @author Sandoval Lucas
 */
@Observable
@Accessors
@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class Inscripcion {
  private Materia materiaElegida;
  
  private Turno turnoElegido;
  
  /**
   * Constructor
   * 
   * @param nuevaMateria Materia a la cual inscribirse
   * @param nuevoTurno Turno elegido para la inscripcion
   * 
   * @see Turno
   */
  public Inscripcion(final Materia nuevaMateria, final Turno nuevoTurno) {
    this.materiaElegida = nuevaMateria;
    this.turnoElegido = nuevoTurno;
  }
  
  /**
   * Reescritura del metodo equals para la colaboracion con las colecciones.
   */
  public boolean equals(final Object elemento) {
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(elemento, null));
    if (!_notEquals) {
      _and = false;
    } else {
      _and = (elemento instanceof Inscripcion);
    }
    if (_and) {
      Inscripcion otraInscripcion = ((Inscripcion) elemento);
      return this.materiaElegida.equals(otraInscripcion.materiaElegida);
    }
    return false;
  }
  
  /**
   * Reescritura del metodo toString para definir un formato nuevo al mostrar una Inscripcion
   */
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Materia elegida: ");
    String _descripcion = this.materiaElegida.getDescripcion();
    _builder.append(_descripcion, "");
    _builder.append(", Turno elegido: ");
    String _name = this.turnoElegido.name();
    _builder.append(_name, "");
    return _builder.toString();
  }
  
  @Pure
  public Materia getMateriaElegida() {
    return this.materiaElegida;
  }
  
  public void setMateriaElegida(final Materia materiaElegida) {
    this.materiaElegida = materiaElegida;
  }
  
  @Pure
  public Turno getTurnoElegido() {
    return this.turnoElegido;
  }
  
  public void setTurnoElegido(final Turno turnoElegido) {
    this.turnoElegido = turnoElegido;
  }
}
