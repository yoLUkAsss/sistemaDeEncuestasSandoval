package windows;

import appModel.CreadorDeEncuestaAppModel;
import components.LabelSelector;
import components.LabelTextBoxForEmail;
import components.LabelTextBoxNumerico;
import domain.Carrera;
import domain.Encuesta;
import domain.Materia;
import javax.annotation.Generated;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.UserException;
import org.uqbar.lacar.ui.model.Action;
import windows.EncuestaCreadaWindow;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class EncuestaWindow extends SimpleWindow<CreadorDeEncuestaAppModel> {
  public EncuestaWindow(final WindowOwner parent, final CreadorDeEncuestaAppModel model) {
    super(parent, model);
    this.setTitle("Sistema de Encuesta");
  }
  
  protected void createFormPanel(final Panel panelPrincipal) {
    Label _label = new Label(panelPrincipal);
    final Procedure1<Label> _function = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText("Intencion de cursada");
        it.setFontSize(24);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
    this.crearInformacionParaPeso(panelPrincipal);
    this.crearInformacionParaCursadas(panelPrincipal);
  }
  
  public LabelTextBoxNumerico crearInformacionParaPeso(final Panel panelPrincipal) {
    LabelTextBoxNumerico _xblockexpression = null;
    {
      PropertyAdapter _propertyAdapter = new PropertyAdapter(Carrera.class, "nombreDeCarrera");
      new LabelSelector(panelPrincipal, "Elegi la carrera que estudias *", "carrerasAElegir", "carreraActual", _propertyAdapter);
      new LabelTextBoxForEmail(panelPrincipal, "Ingrese su E-Mail *", "mailIngresado");
      new LabelTextBoxNumerico(panelPrincipal, "Año de ingreso a la institucion: *", "anioIngreso");
      new LabelTextBoxNumerico(panelPrincipal, "¿Finales aprobados?", "finalesAprobados");
      new LabelTextBoxNumerico(panelPrincipal, "¿Finales desaprobados?", "finalesDesaprobados");
      _xblockexpression = new LabelTextBoxNumerico(panelPrincipal, "¿Cursadas aprobadas?", "cursadasAprobadas");
    }
    return _xblockexpression;
  }
  
  public List<Object> crearInformacionParaCursadas(final Panel panelPrincipal) {
    List<Object> _xblockexpression = null;
    {
      final Panel columnPanel = new Panel(panelPrincipal);
      ColumnLayout _columnLayout = new ColumnLayout(2);
      columnPanel.setLayout(_columnLayout);
      final Panel nuevaMateria = new Panel(columnPanel);
      VerticalLayout _verticalLayout = new VerticalLayout();
      nuevaMateria.setLayout(_verticalLayout);
      PropertyAdapter _propertyAdapter = new PropertyAdapter(Materia.class, "descripcion");
      new LabelSelector(nuevaMateria, "Materia que estas pensando cursar", "materiasAElegir", "materiaSeleccionada", _propertyAdapter);
      new LabelSelector(nuevaMateria, "Turno", "turnosPosibles", "turnoSeleccionado");
      Button _button = new Button(nuevaMateria);
      final Procedure1<Button> _function = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Agregar");
        }
      };
      final Button button = ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
      final Action _function_1 = new Action() {
        public void execute() {
          try {
            CreadorDeEncuestaAppModel _modelObject = EncuestaWindow.this.getModelObject();
            _modelObject.agregarInscripcion();
          } catch (final Throwable _t) {
            if (_t instanceof Exception) {
              final Exception e = (Exception)_t;
              String _message = e.getMessage();
              throw new UserException(_message);
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        }
      };
      button.onClick(_function_1);
      final Panel materiasAgregadas = new Panel(columnPanel);
      VerticalLayout _verticalLayout_1 = new VerticalLayout();
      materiasAgregadas.setLayout(_verticalLayout_1);
      List<Object> _list = new List<Object>(materiasAgregadas);
      final Procedure1<List<Object>> _function_2 = new Procedure1<List<Object>>() {
        public void apply(final List<Object> it) {
          it.bindItemsToProperty("inscripcionesAlMomento");
          it.setHeight(100);
          it.setWidth(300);
        }
      };
      _xblockexpression = ObjectExtensions.<List<Object>>operator_doubleArrow(_list, _function_2);
    }
    return _xblockexpression;
  }
  
  protected void addActions(final Panel panelPrincipal) {
    Button _button = new Button(panelPrincipal);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Enviar Encuesta");
      }
    };
    Button button = ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
    final Action _function_1 = new Action() {
      public void execute() {
        try {
          CreadorDeEncuestaAppModel _modelObject = EncuestaWindow.this.getModelObject();
          Encuesta _enviarEncuesta = _modelObject.enviarEncuesta();
          EncuestaCreadaWindow _encuestaCreadaWindow = new EncuestaCreadaWindow(EncuestaWindow.this, _enviarEncuesta);
          _encuestaCreadaWindow.open();
          EncuestaWindow.this.close();
        } catch (final Throwable _t) {
          if (_t instanceof Exception) {
            final Exception e = (Exception)_t;
            String _message = e.getMessage();
            throw new UserException(_message);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
    };
    button.onClick(_function_1);
  }
}
