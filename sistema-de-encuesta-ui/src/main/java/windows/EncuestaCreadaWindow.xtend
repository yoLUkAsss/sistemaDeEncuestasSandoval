package windows

import domain.Encuesta
import java.awt.Color
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner

class EncuestaCreadaWindow extends SimpleWindow<Encuesta>{
	
	new(WindowOwner parent, Encuesta model) {
		super(parent, model)
		title = "Encuesta finalizada"
	}
	
	override protected addActions(Panel actionsPanel) {
		//No lo utilizo
	}
	
	override protected createFormPanel(Panel mainPanel) {
		//No lo utilizo
	}
	
	override createMainTemplate(Panel mainPanel) {
		crearBienvenida(mainPanel)
		crearInformacionPrincipal(mainPanel)
		crearListaDeInscripciones(mainPanel)
		crearBotonDeSalida(mainPanel)
	}
	
	def crearBotonDeSalida(Panel mainPanel) {
		var button = new Button(mainPanel) => [
			caption = "Finalizar"
		]
		button.onClick([| this.close])
	}
	
	def crearListaDeInscripciones(Panel mainPanel) {
		new Label(mainPanel).text = "Inscripciones elegidas: "
		new List(mainPanel) => [
			bindItemsToProperty("posiblesInscripciones")
			height = 100
			width = 300
		]
	}
	
	def crearBienvenida(Panel mainPanel) {
		new Label(mainPanel) => [
			text = "Gracias por su colaboración"
			fontSize = 24
			foreground = Color.GREEN
		]
	}
	
	def crearInformacionPrincipal(Panel mainPanel) {
		var informacion = new Panel(mainPanel)
		informacion.layout = new ColumnLayout(2)
		
		new Label(informacion).text = "Carrera seleccionada"
		new Label(informacion).bindValueToProperty("carreraEnCurso.nombreDeCarrera")
		new Label(informacion).text = "Mail ingresado"
		new Label(informacion).bindValueToProperty("email")
		new Label(informacion).text = "Año ingresado"
		new Label(informacion).bindValueToProperty("anioIngreso")
	}
	
}