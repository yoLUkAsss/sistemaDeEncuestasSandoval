package components

import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextFilter


/**
 * Representan la union de un Label junto a un TextBox
 * 
 * @see org.uqbar.arena.widgets.Label
 * @see org.uqbar.arena.widgets.TextBox
 * 
 * @author Sandoval Lucas
 */
class LabelTextBox {
	
	
	new (Panel panelPrincipal , String textForLabel , String valueToBind , TextFilter filtro) {
		new Label(panelPrincipal).text = textForLabel
		new TextBox(panelPrincipal) => [
			bindValueToProperty(valueToBind)
			withFilter(filtro)
		]
	}
}