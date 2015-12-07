package filters

import org.uqbar.arena.widgets.TextFilter
import org.uqbar.arena.widgets.TextInputEvent

/**
 * Filtro que permite caracteres alfanumericos, y los signos «-» «.» «_»
 * 
 * @author Sandoval Lucas
 */
class OnlyEmailAcceptedFilter implements TextFilter {	
	
	override accept(TextInputEvent event) {
		event.potentialTextResult.matches("[0-9-@.a-z_A-Z]*")
	}
	
}