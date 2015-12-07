package components;

import components.LabelTextBox;
import filters.OnlyNumberAcceptedFilter;
import javax.annotation.Generated;
import org.uqbar.arena.widgets.Panel;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class LabelTextBoxNumerico extends LabelTextBox {
  public LabelTextBoxNumerico(final Panel panelPrincipal, final String textForLabel, final String valueToBind) {
    super(panelPrincipal, textForLabel, valueToBind, new OnlyNumberAcceptedFilter());
  }
}
