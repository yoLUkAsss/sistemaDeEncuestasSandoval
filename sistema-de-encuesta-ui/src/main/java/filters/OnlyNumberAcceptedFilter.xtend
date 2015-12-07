package filters

import org.uqbar.arena.widgets.TextFilter
import org.uqbar.arena.widgets.TextInputEvent

/**
 * Filtro que permite numericos
 * 
 * @author Sandoval Lucas
 */
class OnlyNumberAcceptedFilter implements TextFilter {
				
	override accept(TextInputEvent event) {
		event.potentialTextResult.matches("[0-9]*")
	}

}