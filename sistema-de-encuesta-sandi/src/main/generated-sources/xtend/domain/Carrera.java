package domain;

import com.google.common.base.Objects;
import domain.Materia;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

/**
 * Objeto para la representacion de una Carrera universitaria
 */
@Observable
@Accessors
@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class Carrera {
  private String nombreDeCarrera;
  
  private List<Materia> materiasObligatorias;
  
  /**
   * Constructor
   * 
   * @param nuevoNombreDeCarrera El nombre que recibira la carrera
   */
  public Carrera(final String nuevoNombreDeCarrera) {
    ArrayList<Materia> _newArrayList = CollectionLiterals.<Materia>newArrayList();
    this.materiasObligatorias = _newArrayList;
    this.nombreDeCarrera = nuevoNombreDeCarrera;
  }
  
  /**
   * Agregar una materia
   * 
   * @param nuevaMateria Materia a ser agregada a la carrera
   */
  public boolean agregarNuevaMateria(final Materia nuevaMateria) {
    return this.materiasObligatorias.add(nuevaMateria);
  }
  
  /**
   * Eliminar una materia
   * 
   * @param materiaAEliminar Materia a ser eliminada a la carrera
   */
  public boolean eliminarMateria(final Materia materiaAEliminar) {
    return this.materiasObligatorias.remove(materiaAEliminar);
  }
  
  /**
   * Reescritura del metodo equals para colaborar junto a las colecciones
   */
  public boolean equals(final Object elemento) {
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(elemento, null));
    if (!_notEquals) {
      _and = false;
    } else {
      _and = (elemento instanceof Carrera);
    }
    if (_and) {
      Carrera otraCarrera = ((Carrera) elemento);
      return this.nombreDeCarrera.equals(otraCarrera.nombreDeCarrera);
    }
    return false;
  }
  
  @Pure
  public String getNombreDeCarrera() {
    return this.nombreDeCarrera;
  }
  
  public void setNombreDeCarrera(final String nombreDeCarrera) {
    this.nombreDeCarrera = nombreDeCarrera;
  }
  
  @Pure
  public List<Materia> getMateriasObligatorias() {
    return this.materiasObligatorias;
  }
  
  public void setMateriasObligatorias(final List<Materia> materiasObligatorias) {
    this.materiasObligatorias = materiasObligatorias;
  }
}
