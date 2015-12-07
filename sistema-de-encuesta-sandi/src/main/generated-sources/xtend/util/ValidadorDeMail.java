package util;

import com.google.common.base.Objects;
import java.util.Collections;
import java.util.List;
import javax.annotation.Generated;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import util.Validador;

/**
 * Objeto encargado de validar correos electronicos
 * 
 * @author Sandoval Lucas
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class ValidadorDeMail implements Validador {
  /**
   * Dominios para correo precargados
   */
  private List<String> dominiosAceptados = IterableExtensions.<String>toList(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("hotmail.com.ar", "hotmail.com", "live.ar", "gmail.com")));
  
  /**
   * Se encarga de validar que un objeto sea (de carácter general) un correo electronico valido
   * 
   * @param o Objeto a evaluar
   * 
   * @return True si el objeto cumple la condicion de ser un correo valido, False en caso contrario
   */
  public boolean validar(final Object o) {
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(o, null));
    if (!_notEquals) {
      _and = false;
    } else {
      _and = (o instanceof String);
    }
    if (_and) {
      String input = ((String) o);
      boolean _and_1 = false;
      boolean _isEmpty = input.isEmpty();
      boolean _not = (!_isEmpty);
      if (!_not) {
        _and_1 = false;
      } else {
        boolean _contains = input.contains("@");
        _and_1 = _contains;
      }
      if (_and_1) {
        int index = input.indexOf("@");
        if ((index > 0)) {
          String aValidar = input.substring((index + 1));
          return this.dominiosAceptados.contains(aValidar);
        }
      }
    }
    return false;
  }
}
