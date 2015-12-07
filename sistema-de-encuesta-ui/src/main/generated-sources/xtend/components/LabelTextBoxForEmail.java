package components;

import components.LabelTextBox;
import filters.OnlyEmailAcceptedFilter;
import javax.annotation.Generated;
import org.uqbar.arena.widgets.Panel;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class LabelTextBoxForEmail extends LabelTextBox {
  public LabelTextBoxForEmail(final Panel panelPrincipal, final String textForLabel, final String valueToBind) {
    super(panelPrincipal, textForLabel, valueToBind, new OnlyEmailAcceptedFilter());
  }
}
