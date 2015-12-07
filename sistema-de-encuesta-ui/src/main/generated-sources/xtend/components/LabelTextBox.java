package components;

import javax.annotation.Generated;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.TextFilter;
import org.uqbar.lacar.ui.model.ControlBuilder;

/**
 * Representan la union de un Label junto a un TextBox
 * 
 * @see org.uqbar.arena.widgets.Label
 * @see org.uqbar.arena.widgets.TextBox
 * 
 * @author Sandoval Lucas
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class LabelTextBox {
  public LabelTextBox(final Panel panelPrincipal, final String textForLabel, final String valueToBind, final TextFilter filtro) {
    Label _label = new Label(panelPrincipal);
    _label.setText(textForLabel);
    TextBox _textBox = new TextBox(panelPrincipal);
    final Procedure1<TextBox> _function = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        it.<Object, ControlBuilder>bindValueToProperty(valueToBind);
        it.withFilter(filtro);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function);
  }
}
