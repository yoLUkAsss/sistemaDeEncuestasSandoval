package appModel;

import com.google.common.base.Objects;
import domain.Carrera;
import domain.Encuesta;
import domain.Inscripcion;
import domain.Materia;
import domain.Turno;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;
import util.ValidadorDeMail;

/**
 * App Model que utilizado para la vista de la creacion de encuestas, del sistema "Creador de Encuestas"
 * 
 * @author Sandoval Lucas
 */
@Observable
@Accessors
@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class CreadorDeEncuestaAppModel {
  private Integer anioIngreso;
  
  private Integer finalesAprobados;
  
  private Integer finalesDesaprobados;
  
  private Integer cursadasAprobadas;
  
  private Turno turnoSeleccionado;
  
  private String mailIngresado;
  
  private List<Inscripcion> inscripcionesAlMomento;
  
  private List<Carrera> carrerasAElegir;
  
  private Carrera carreraActual;
  
  private List<Materia> materiasAElegir;
  
  private Materia materiaSeleccionada;
  
  /**
   * Constructor
   * 
   * @param carrerasPrincipales Carreras totales del sistema
   */
  public CreadorDeEncuestaAppModel(final List<Carrera> carrerasPrincipales) {
    this.carrerasAElegir = carrerasPrincipales;
    ArrayList<Inscripcion> _newArrayList = CollectionLiterals.<Inscripcion>newArrayList();
    this.inscripcionesAlMomento = _newArrayList;
  }
  
  /**
   * Se encarga de validar e ingresar una nueva inscripcion al sistema, junto a la materia y
   * al turno elegidos.
   */
  public void agregarInscripcion() {
    this.validarYAgregar(this.materiaSeleccionada, this.turnoSeleccionado);
  }
  
  /**
   * Retorna todas las carreras del sistema.
   */
  public List<String> getCarrerasPosibles() {
    final Function1<Carrera, String> _function = new Function1<Carrera, String>() {
      public String apply(final Carrera it) {
        return it.getNombreDeCarrera();
      }
    };
    return ListExtensions.<Carrera, String>map(this.carrerasAElegir, _function);
  }
  
  /**
   * Retorna todas las materias posibles de la carrera actual elegida
   */
  public List<String> getMateriasPosibles() {
    List<Materia> _obtenerMateriasDeCarrera = this.obtenerMateriasDeCarrera(this.carreraActual);
    this.materiasAElegir = _obtenerMateriasDeCarrera;
    final Function1<Materia, String> _function = new Function1<Materia, String>() {
      public String apply(final Materia it) {
        return it.getDescripcion();
      }
    };
    return ListExtensions.<Materia, String>map(this.materiasAElegir, _function);
  }
  
  /**
   * Retorna todos los turnos posibles
   */
  public List<Turno> getTurnosPosibles() {
    Turno[] _values = Turno.values();
    return IterableExtensions.<Turno>toList(((Iterable<Turno>)Conversions.doWrapArray(_values)));
  }
  
  /**
   * Al recibir una nueva carrera para definir como actual (o elegida), actualiza cuales son las
   * nuevas materias a elegir.
   * 
   * @param otraCarrera Carrera nueva elegida
   * 
   * @note Al utilizarse, se limpian las inscripciones hasta el momento
   */
  @Observable
  public void setCarreraActual(final Carrera otraCarrera) {
    this.carreraActual = otraCarrera;
    List<Materia> _materiasObligatorias = this.carreraActual.getMateriasObligatorias();
    this.materiasAElegir = _materiasObligatorias;
    ArrayList<Inscripcion> _newArrayList = CollectionLiterals.<Inscripcion>newArrayList();
    this.inscripcionesAlMomento = _newArrayList;
    ObservableUtils.firePropertyChanged(this, "carreraActual", this.carreraActual);
    ObservableUtils.firePropertyChanged(this, "materiasAElegir", this.materiasAElegir);
    ObservableUtils.firePropertyChanged(this, "inscripcionesAlMomento", this.inscripcionesAlMomento);
  }
  
  /**
   * Se encarga de validar toda la informacion necesiar para crear una nueva inscripcion.
   * Luego la crea y actualiza informacion
   * 
   * @param nuevaMateriaAAgregar Materia elegida
   * @param turnoElegido Turno para la inscripcion
   */
  public void validarYAgregar(final Materia nuevaMateriaAAgregar, final Turno turnoElegido) {
    try {
      boolean _camposDeNuevaInscripcionCorrectos = this.camposDeNuevaInscripcionCorrectos();
      boolean _not = (!_camposDeNuevaInscripcionCorrectos);
      if (_not) {
        throw new Exception("Aun quedan elementos sin completar");
      }
      Inscripcion nuevaInscripcion = new Inscripcion(nuevaMateriaAAgregar, turnoElegido);
      boolean _inscripcionYaExiste = this.inscripcionYaExiste(nuevaInscripcion);
      if (_inscripcionYaExiste) {
        throw new Exception("No es posible inscribirse a una misma materia 2 veces");
      }
      this.inscripcionesAlMomento.add(nuevaInscripcion);
      ObservableUtils.firePropertyChanged(this, "inscripcionesAlMomento", this.inscripcionesAlMomento);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Se encarga de validar que la informacion para una nueva inscripcion sea correcta
   */
  public boolean camposDeNuevaInscripcionCorrectos() {
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(this.turnoSeleccionado, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _notEquals_1 = (!Objects.equal(this.materiaSeleccionada, null));
      _and = _notEquals_1;
    }
    return _and;
  }
  
  /**
   * Se encarga de validar si la informacion obligatoria para crear una encuesta, esta correcta
   */
  public boolean camposDeNuevaEncuestaCorrectos() {
    boolean _and = false;
    boolean _and_1 = false;
    boolean _notEquals = (!Objects.equal(this.anioIngreso, null));
    if (!_notEquals) {
      _and_1 = false;
    } else {
      boolean _notEquals_1 = (!Objects.equal(this.carreraActual, null));
      _and_1 = _notEquals_1;
    }
    if (!_and_1) {
      _and = false;
    } else {
      boolean _mailEsValido = this.mailEsValido();
      _and = _mailEsValido;
    }
    return _and;
  }
  
  /**
   * Se encarga de validar si una inscripcion ya se encuentra anotada en el sistema
   * 
   * @param inscripcionAVerificar Inscripcion a validar
   */
  public boolean inscripcionYaExiste(final Inscripcion inscripcionAVerificar) {
    return this.inscripcionesAlMomento.contains(inscripcionAVerificar);
  }
  
  /**
   * Se encarga de validar toda la informacion necesaria para crear una encuesta correctamente
   */
  public void validarEncuesta() {
    try {
      boolean _mailEsValido = this.mailEsValido();
      boolean _not = (!_mailEsValido);
      if (_not) {
        throw new Exception("El mail ingresado es invalido");
      }
      boolean _añoIngresoValido = this.añoIngresoValido();
      boolean _not_1 = (!_añoIngresoValido);
      if (_not_1) {
        throw new Exception("El año ingresado es incorrecto");
      }
      boolean _cursadasAprobadasValido = this.cursadasAprobadasValido();
      boolean _not_2 = (!_cursadasAprobadasValido);
      if (_not_2) {
        throw new Exception("No es posible tener mas finales que cursadas aprobadas");
      }
      boolean _materiasCumple = this.materiasCumple();
      boolean _not_3 = (!_materiasCumple);
      if (_not_3) {
        throw new Exception("Debe ingresar al menos una materia");
      }
      boolean _camposDeNuevaEncuestaCorrectos = this.camposDeNuevaEncuestaCorrectos();
      boolean _not_4 = (!_camposDeNuevaEncuestaCorrectos);
      if (_not_4) {
        throw new Exception("Aun quedan elementos sin completar");
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Se encarga de validar que haya suficientes inscripciones a materias de una carrera especifica
   */
  public boolean materiasCumple() {
    int _size = this.inscripcionesAlMomento.size();
    return (_size >= 1);
  }
  
  /**
   * Se encarga de validar informacion sobre el año de ingreso ingresado al sistema
   */
  public boolean añoIngresoValido() {
    boolean _or = false;
    boolean _and = false;
    boolean _and_1 = false;
    boolean _notEquals = (!Objects.equal(this.anioIngreso, null));
    if (!_notEquals) {
      _and_1 = false;
    } else {
      _and_1 = ((this.anioIngreso).intValue() < 2015);
    }
    if (!_and_1) {
      _and = false;
    } else {
      _and = ((this.anioIngreso).intValue() > 1900);
    }
    if (_and) {
      _or = true;
    } else {
      boolean _equals = Objects.equal(this.anioIngreso, null);
      _or = _equals;
    }
    return _or;
  }
  
  /**
   * Se encarga de validar informacion sobre los finales y cursadas aprobadas
   */
  public boolean cursadasAprobadasValido() {
    boolean _or = false;
    boolean _and = false;
    boolean _and_1 = false;
    boolean _notEquals = (!Objects.equal(this.cursadasAprobadas, null));
    if (!_notEquals) {
      _and_1 = false;
    } else {
      boolean _notEquals_1 = (!Objects.equal(this.finalesAprobados, null));
      _and_1 = _notEquals_1;
    }
    if (!_and_1) {
      _and = false;
    } else {
      boolean _greaterThan = (this.cursadasAprobadas.compareTo(this.finalesAprobados) > 0);
      _and = _greaterThan;
    }
    if (_and) {
      _or = true;
    } else {
      boolean _or_1 = false;
      boolean _equals = Objects.equal(this.cursadasAprobadas, null);
      if (_equals) {
        _or_1 = true;
      } else {
        boolean _equals_1 = Objects.equal(this.finalesAprobados, null);
        _or_1 = _equals_1;
      }
      _or = _or_1;
    }
    return _or;
  }
  
  /**
   * Se encarga de validar los datos y obtener una encuesta en base a ellos.
   */
  public Encuesta enviarEncuesta() {
    this.validarEncuesta();
    return this.crearEncuestaFinal();
  }
  
  /**
   * Se encarga de obtener la List«Materia» de una carrera especifica
   * 
   * @param carreraEnLaCualBuscar Carrera especifica sobre la cual buscar
   */
  public List<Materia> obtenerMateriasDeCarrera(final Carrera carreraEnLaCualBuscar) {
    List<Materia> _xblockexpression = null;
    {
      final Function1<Carrera, Boolean> _function = new Function1<Carrera, Boolean>() {
        public Boolean apply(final Carrera carrera) {
          return Boolean.valueOf(carrera.equals(carreraEnLaCualBuscar));
        }
      };
      Carrera buscada = IterableExtensions.<Carrera>findFirst(this.carrerasAElegir, _function);
      _xblockexpression = buscada.getMateriasObligatorias();
    }
    return _xblockexpression;
  }
  
  /**
   * @return True en caso de que el mail ingresado sea valido, False caso contrario
   */
  public boolean mailEsValido() {
    ValidadorDeMail _validadorDeMail = new ValidadorDeMail();
    return _validadorDeMail.validar(this.mailIngresado);
  }
  
  /**
   * Se encarga de recolecar los datos necesarios y crear un objeto Encuesta
   * 
   * @see Encuesta
   */
  public Encuesta crearEncuestaFinal() {
    return new Encuesta(this.inscripcionesAlMomento, this.carreraActual, this.mailIngresado, this.anioIngreso);
  }
  
  @Pure
  public Integer getAnioIngreso() {
    return this.anioIngreso;
  }
  
  public void setAnioIngreso(final Integer anioIngreso) {
    this.anioIngreso = anioIngreso;
  }
  
  @Pure
  public Integer getFinalesAprobados() {
    return this.finalesAprobados;
  }
  
  public void setFinalesAprobados(final Integer finalesAprobados) {
    this.finalesAprobados = finalesAprobados;
  }
  
  @Pure
  public Integer getFinalesDesaprobados() {
    return this.finalesDesaprobados;
  }
  
  public void setFinalesDesaprobados(final Integer finalesDesaprobados) {
    this.finalesDesaprobados = finalesDesaprobados;
  }
  
  @Pure
  public Integer getCursadasAprobadas() {
    return this.cursadasAprobadas;
  }
  
  public void setCursadasAprobadas(final Integer cursadasAprobadas) {
    this.cursadasAprobadas = cursadasAprobadas;
  }
  
  @Pure
  public Turno getTurnoSeleccionado() {
    return this.turnoSeleccionado;
  }
  
  public void setTurnoSeleccionado(final Turno turnoSeleccionado) {
    this.turnoSeleccionado = turnoSeleccionado;
  }
  
  @Pure
  public String getMailIngresado() {
    return this.mailIngresado;
  }
  
  public void setMailIngresado(final String mailIngresado) {
    this.mailIngresado = mailIngresado;
  }
  
  @Pure
  public List<Inscripcion> getInscripcionesAlMomento() {
    return this.inscripcionesAlMomento;
  }
  
  public void setInscripcionesAlMomento(final List<Inscripcion> inscripcionesAlMomento) {
    this.inscripcionesAlMomento = inscripcionesAlMomento;
  }
  
  @Pure
  public List<Carrera> getCarrerasAElegir() {
    return this.carrerasAElegir;
  }
  
  public void setCarrerasAElegir(final List<Carrera> carrerasAElegir) {
    this.carrerasAElegir = carrerasAElegir;
  }
  
  @Pure
  public Carrera getCarreraActual() {
    return this.carreraActual;
  }
  
  @Pure
  public List<Materia> getMateriasAElegir() {
    return this.materiasAElegir;
  }
  
  public void setMateriasAElegir(final List<Materia> materiasAElegir) {
    this.materiasAElegir = materiasAElegir;
  }
  
  @Pure
  public Materia getMateriaSeleccionada() {
    return this.materiaSeleccionada;
  }
  
  public void setMateriaSeleccionada(final Materia materiaSeleccionada) {
    this.materiaSeleccionada = materiaSeleccionada;
  }
}
