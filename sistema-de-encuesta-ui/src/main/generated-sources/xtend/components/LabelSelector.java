package components;

import javax.annotation.Generated;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

/**
 * Representan la union de un Label junto a un Selector
 * 
 * @see org.uqbar.arena.widgets.Label
 * @see org.uqbar.arena.widgets.Selector
 * 
 * @author Sandoval Lucas
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class LabelSelector {
  public LabelSelector(final Panel panelPrincipal, final String labelText, final String itemToProperty, final String valueToProperty) {
    Label _label = new Label(panelPrincipal);
    _label.setText(labelText);
    Selector<Object> _selector = new Selector<Object>(panelPrincipal);
    final Procedure1<Selector<Object>> _function = new Procedure1<Selector<Object>>() {
      public void apply(final Selector<Object> it) {
        it.allowNull(true);
        it.bindItemsToProperty(itemToProperty);
        it.<Object, ControlBuilder>bindValueToProperty(valueToProperty);
      }
    };
    ObjectExtensions.<Selector<Object>>operator_doubleArrow(_selector, _function);
  }
  
  public LabelSelector(final Panel panelPrincipal, final String labelText, final String itemToProperty, final String valueToProperty, final PropertyAdapter adapterAUtilizar) {
    Label _label = new Label(panelPrincipal);
    _label.setText(labelText);
    Selector<Object> _selector = new Selector<Object>(panelPrincipal);
    final Procedure1<Selector<Object>> _function = new Procedure1<Selector<Object>>() {
      public void apply(final Selector<Object> it) {
        it.allowNull(true);
        Binding<?, Selector<Object>, ListBuilder<Object>> _bindItemsToProperty = it.bindItemsToProperty(itemToProperty);
        _bindItemsToProperty.setAdapter(adapterAUtilizar);
        it.<Object, ControlBuilder>bindValueToProperty(valueToProperty);
      }
    };
    ObjectExtensions.<Selector<Object>>operator_doubleArrow(_selector, _function);
  }
}
