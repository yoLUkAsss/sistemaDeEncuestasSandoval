package windows;

import appModel.CreadorDeEncuestaAppModel;
import domain.Carrera;
import domain.Materia;
import java.util.ArrayList;
import javax.annotation.Generated;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import windows.EncuestaWindow;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class EncuestaApplication extends Application {
  protected Window<?> createMainWindow() {
    EncuestaWindow _xblockexpression = null;
    {
      Carrera carrera1 = new Carrera("Ingenieria en Computacion");
      Carrera carrera2 = new Carrera("Licenciatura en Informatica");
      Carrera carrera3 = new Carrera("Experto en cosas");
      Materia materia11 = new Materia("Programacion 1");
      Materia materia12 = new Materia("Matematica A");
      carrera1.agregarNuevaMateria(materia11);
      carrera1.agregarNuevaMateria(materia12);
      Materia materia21 = new Materia("Introduccion a la Programacion");
      Materia materia22 = new Materia("Organizacion de Computadoras");
      Materia materia23 = new Materia("Matematica 1");
      carrera2.agregarNuevaMateria(materia21);
      carrera2.agregarNuevaMateria(materia22);
      carrera2.agregarNuevaMateria(materia23);
      Materia materia31 = new Materia("Cosas 1");
      Materia materia32 = new Materia("Cosas 2");
      Materia materia33 = new Materia("Cosas avanzadas");
      Materia materia34 = new Materia("Otras cosas mas");
      carrera3.agregarNuevaMateria(materia31);
      carrera3.agregarNuevaMateria(materia32);
      carrera3.agregarNuevaMateria(materia33);
      carrera3.agregarNuevaMateria(materia34);
      ArrayList<Carrera> listadoInicial = CollectionLiterals.<Carrera>newArrayList();
      listadoInicial.add(carrera1);
      listadoInicial.add(carrera2);
      listadoInicial.add(carrera3);
      CreadorDeEncuestaAppModel _creadorDeEncuestaAppModel = new CreadorDeEncuestaAppModel(listadoInicial);
      _xblockexpression = new EncuestaWindow(this, _creadorDeEncuestaAppModel);
    }
    return _xblockexpression;
  }
  
  public static void main(final String[] args) {
    EncuestaApplication _encuestaApplication = new EncuestaApplication();
    _encuestaApplication.start();
  }
}
