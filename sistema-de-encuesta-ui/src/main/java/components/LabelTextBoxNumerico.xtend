package components

import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import filters.OnlyNumberAcceptedFilter

class LabelTextBoxNumerico extends LabelTextBox{
	
	
	new (Panel panelPrincipal , String textForLabel , String valueToBind) {
		super(panelPrincipal,textForLabel , valueToBind , new OnlyNumberAcceptedFilter)
	}
}