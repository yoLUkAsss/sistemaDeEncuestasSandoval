package domain;

import com.google.common.base.Objects;
import javax.annotation.Generated;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

/**
 * Objeto que representa a una materia (valga la redundancia =D)
 * 
 * @author Sandoval Lucas
 */
@Observable
@Accessors
@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class Materia {
  private String descripcion;
  
  /**
   * Constructor
   * 
   * @param nuevaDescripcion Funciona como nombre de materia hasta este momento
   */
  public Materia(final String nuevaDescripcion) {
    this.descripcion = nuevaDescripcion;
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
      _and = (elemento instanceof Materia);
    }
    if (_and) {
      Materia otraMateria = ((Materia) elemento);
      return this.descripcion.equals(otraMateria.descripcion);
    }
    return false;
  }
  
  @Pure
  public String getDescripcion() {
    return this.descripcion;
  }
  
  public void setDescripcion(final String descripcion) {
    this.descripcion = descripcion;
  }
}
