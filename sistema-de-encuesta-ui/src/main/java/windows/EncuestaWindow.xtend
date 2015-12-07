package windows

import org.uqbar.arena.windows.SimpleWindow
import appModel.CreadorDeEncuestaAppModel
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.List
import domain.Carrera
import org.uqbar.arena.bindings.PropertyAdapter
import domain.Materia
import org.uqbar.commons.model.UserException
import components.LabelSelector
import components.LabelTextBoxForEmail
import components.LabelTextBoxNumerico

class EncuestaWindow extends SimpleWindow<CreadorDeEncuestaAppModel> {
	
	new (WindowOwner parent , CreadorDeEncuestaAppModel model) {
		super(parent, model)
		this.title = "Sistema de Encuesta"
	}
	
	override protected createFormPanel(Panel panelPrincipal) {
		new Label(panelPrincipal) => [
			text = "Intencion de cursada"
			fontSize = 24	
		]
		this.crearInformacionParaPeso(panelPrincipal)
		this.crearInformacionParaCursadas(panelPrincipal)
	}
	
	def crearInformacionParaPeso(Panel panelPrincipal) {
		
		new LabelSelector(panelPrincipal,"Elegi la carrera que estudias *","carrerasAElegir","carreraActual",new PropertyAdapter(Carrera, "nombreDeCarrera"))
		new LabelTextBoxForEmail(panelPrincipal,"Ingrese su E-Mail *","mailIngresado")
		new LabelTextBoxNumerico(panelPrincipal,"Año de ingreso a la institucion: *","anioIngreso")
		new LabelTextBoxNumerico(panelPrincipal,"¿Finales aprobados?","finalesAprobados")
		new LabelTextBoxNumerico(panelPrincipal,"¿Finales desaprobados?","finalesDesaprobados")
		new LabelTextBoxNumerico(panelPrincipal,"¿Cursadas aprobadas?","cursadasAprobadas")
	}
	
	def crearInformacionParaCursadas(Panel panelPrincipal) {
		val columnPanel = new Panel(panelPrincipal)
		columnPanel.layout = new ColumnLayout(2)
		
		val nuevaMateria = new Panel(columnPanel)
		nuevaMateria.layout = new VerticalLayout
		
		new LabelSelector(nuevaMateria,"Materia que estas pensando cursar","materiasAElegir","materiaSeleccionada",new PropertyAdapter(Materia, "descripcion"))
		new LabelSelector(nuevaMateria,"Turno","turnosPosibles","turnoSeleccionado")
		
		val button = new Button(nuevaMateria) => [
			caption = "Agregar"
		]
		
		button.onClick([|
			try {
				modelObject.agregarInscripcion
			} catch (Exception e){
				throw new UserException(e.message)
			}
		])
		
		val materiasAgregadas = new Panel(columnPanel)
		materiasAgregadas.layout = new VerticalLayout
		
		new List(materiasAgregadas) => [
			bindItemsToProperty("inscripcionesAlMomento")
			height = 100
			width = 300
		]
	}
	
	override protected addActions(Panel panelPrincipal) {
		var button = new Button(panelPrincipal) => [
			caption = "Enviar Encuesta"
		]
		button.onClick([| 
			try {
				new EncuestaCreadaWindow(this,modelObject.enviarEncuesta).open
				this.close
			} catch (Exception e){
				throw new UserException(e.message)
			}
		])
	}
	
}