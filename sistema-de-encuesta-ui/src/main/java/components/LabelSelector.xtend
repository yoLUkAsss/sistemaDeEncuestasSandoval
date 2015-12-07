package components

import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.bindings.PropertyAdapter


/**
 * Representan la union de un Label junto a un Selector
 * 
 * @see org.uqbar.arena.widgets.Label
 * @see org.uqbar.arena.widgets.Selector
 * 
 * @author Sandoval Lucas
 */
class LabelSelector {
	
	
	new(Panel panelPrincipal , String labelText , String itemToProperty , String valueToProperty) {
		new Label(panelPrincipal).text = labelText
		new Selector(panelPrincipal) => [
			allowNull(true)
			bindItemsToProperty(itemToProperty)
			bindValueToProperty(valueToProperty)
		]
	}
	
	new(Panel panelPrincipal , 
		String labelText , 
		String itemToProperty , 
		String valueToProperty , 
		PropertyAdapter adapterAUtilizar) {
			new Label(panelPrincipal).text = labelText
			new Selector(panelPrincipal) => [
				allowNull(true)
				bindItemsToProperty(itemToProperty).adapter = adapterAUtilizar
				bindValueToProperty(valueToProperty)
			]
	}
}