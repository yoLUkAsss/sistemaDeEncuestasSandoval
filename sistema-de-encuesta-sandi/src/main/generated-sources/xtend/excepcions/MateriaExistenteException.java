package excepcions;

import excepcions.ExcepcionPropia;
import javax.annotation.Generated;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class MateriaExistenteException extends ExcepcionPropia {
  public MateriaExistenteException() {
    super("No es posible inscribirse a una misma materia 2 veces");
  }
}
