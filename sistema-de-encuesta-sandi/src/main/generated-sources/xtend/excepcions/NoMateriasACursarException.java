package excepcions;

import excepcions.ExcepcionPropia;
import javax.annotation.Generated;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class NoMateriasACursarException extends ExcepcionPropia {
  public NoMateriasACursarException() {
    super("Debe ingresar al menos una materia");
  }
}
