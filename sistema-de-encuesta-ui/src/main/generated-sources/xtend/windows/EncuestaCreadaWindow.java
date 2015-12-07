package windows;

import domain.Encuesta;
import java.awt.Color;
import javax.annotation.Generated;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class EncuestaCreadaWindow extends SimpleWindow<Encuesta> {
  public EncuestaCreadaWindow(final WindowOwner parent, final Encuesta model) {
    super(parent, model);
    this.setTitle("Encuesta finalizada");
  }
  
  protected void addActions(final Panel actionsPanel) {
  }
  
  protected void createFormPanel(final Panel mainPanel) {
  }
  
  public void createMainTemplate(final Panel mainPanel) {
    this.crearBienvenida(mainPanel);
    this.crearInformacionPrincipal(mainPanel);
    this.crearListaDeInscripciones(mainPanel);
    this.crearBotonDeSalida(mainPanel);
  }
  
  public Button crearBotonDeSalida(final Panel mainPanel) {
    Button _xblockexpression = null;
    {
      Button _button = new Button(mainPanel);
      final Procedure1<Button> _function = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Finalizar");
        }
      };
      Button button = ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
      final Action _function_1 = new Action() {
        public void execute() {
          EncuestaCreadaWindow.this.close();
        }
      };
      _xblockexpression = button.onClick(_function_1);
    }
    return _xblockexpression;
  }
  
  public List<Object> crearListaDeInscripciones(final Panel mainPanel) {
    List<Object> _xblockexpression = null;
    {
      Label _label = new Label(mainPanel);
      _label.setText("Inscripciones elegidas: ");
      List<Object> _list = new List<Object>(mainPanel);
      final Procedure1<List<Object>> _function = new Procedure1<List<Object>>() {
        public void apply(final List<Object> it) {
          it.bindItemsToProperty("posiblesInscripciones");
          it.setHeight(100);
          it.setWidth(300);
        }
      };
      _xblockexpression = ObjectExtensions.<List<Object>>operator_doubleArrow(_list, _function);
    }
    return _xblockexpression;
  }
  
  public Label crearBienvenida(final Panel mainPanel) {
    Label _label = new Label(mainPanel);
    final Procedure1<Label> _function = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText("Gracias por su colaboración");
        it.setFontSize(24);
        it.setForeground(Color.GREEN);
      }
    };
    return ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
  }
  
  public Binding<Object, Control, ControlBuilder> crearInformacionPrincipal(final Panel mainPanel) {
    Binding<Object, Control, ControlBuilder> _xblockexpression = null;
    {
      Panel informacion = new Panel(mainPanel);
      ColumnLayout _columnLayout = new ColumnLayout(2);
      informacion.setLayout(_columnLayout);
      Label _label = new Label(informacion);
      _label.setText("Carrera seleccionada");
      Label _label_1 = new Label(informacion);
      _label_1.<Object, ControlBuilder>bindValueToProperty("carreraEnCurso.nombreDeCarrera");
      Label _label_2 = new Label(informacion);
      _label_2.setText("Mail ingresado");
      Label _label_3 = new Label(informacion);
      _label_3.<Object, ControlBuilder>bindValueToProperty("email");
      Label _label_4 = new Label(informacion);
      _label_4.setText("Año ingresado");
      Label _label_5 = new Label(informacion);
      _xblockexpression = _label_5.<Object, ControlBuilder>bindValueToProperty("anioIngreso");
    }
    return _xblockexpression;
  }
}
