package windows

import org.uqbar.arena.Application
import domain.Carrera
import domain.Materia
import appModel.CreadorDeEncuestaAppModel

class EncuestaApplication extends Application {
	
	override protected createMainWindow() {
		
		var carrera1 = new Carrera("Ingenieria en Computacion")
		var carrera2 = new Carrera("Licenciatura en Informatica")
		var carrera3 = new Carrera("Experto en cosas")
		
		var materia11 = new Materia("Programacion 1")
		var materia12 = new Materia("Matematica A")
		carrera1.agregarNuevaMateria(materia11)
		carrera1.agregarNuevaMateria(materia12)
		
		var materia21 = new Materia("Introduccion a la Programacion")
		var materia22 = new Materia("Organizacion de Computadoras")
		var materia23 = new Materia("Matematica 1")
		carrera2.agregarNuevaMateria(materia21)
		carrera2.agregarNuevaMateria(materia22)
		carrera2.agregarNuevaMateria(materia23)
		
		var materia31 = new Materia("Cosas 1")
		var materia32 = new Materia("Cosas 2")
		var materia33 = new Materia("Cosas avanzadas")
		var materia34 = new Materia("Otras cosas mas")
		carrera3.agregarNuevaMateria(materia31)
		carrera3.agregarNuevaMateria(materia32)
		carrera3.agregarNuevaMateria(materia33)
		carrera3.agregarNuevaMateria(materia34)
		
		var listadoInicial = newArrayList
		listadoInicial.add(carrera1)
		listadoInicial.add(carrera2)
		listadoInicial.add(carrera3)
		
		new EncuestaWindow(this, new CreadorDeEncuestaAppModel(listadoInicial))
	}
	
	def static void main(String[] args) {		
		new EncuestaApplication().start()
	}
	
}