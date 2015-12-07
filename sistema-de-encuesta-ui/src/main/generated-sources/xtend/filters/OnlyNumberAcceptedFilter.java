package filters;

import javax.annotation.Generated;
import org.uqbar.arena.widgets.TextFilter;
import org.uqbar.arena.widgets.TextInputEvent;

/**
 * Filtro que permite numericos
 * 
 * @author Sandoval Lucas
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class OnlyNumberAcceptedFilter implements TextFilter {
  public boolean accept(final TextInputEvent event) {
    String _potentialTextResult = event.getPotentialTextResult();
    return _potentialTextResult.matches("[0-9]*");
  }
}
