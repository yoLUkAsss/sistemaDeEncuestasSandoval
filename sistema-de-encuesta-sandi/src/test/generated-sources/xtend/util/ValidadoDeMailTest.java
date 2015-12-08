package util;

import javax.annotation.Generated;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ValidadorDeMail;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class ValidadoDeMailTest {
  private ValidadorDeMail SUT;
  
  private String mailCorrecto;
  
  private String mailIncorrecto;
  
  private String mailPotencialmenteCorrecto;
  
  @Before
  public void init() {
    ValidadorDeMail _validadorDeMail = new ValidadorDeMail();
    this.SUT = _validadorDeMail;
    this.mailCorrecto = "algo@gmail.com";
    this.mailIncorrecto = "nosoycorrecto";
    this.mailPotencialmenteCorrecto = "podriaSerloPeroNo@noSirvo.edu.ar";
  }
  
  @Test
  public void test_funciona_con_dominios_existentes() {
    boolean _validar = this.SUT.validar(this.mailCorrecto);
    Assert.assertTrue(_validar);
  }
  
  @Test
  public void test_sin_arroba_no_es_valido() {
    boolean _validar = this.SUT.validar(this.mailIncorrecto);
    Assert.assertFalse(_validar);
  }
  
  @Test
  public void test_no_funciona_con_dominios_inexistentes_o_no_cargados() {
    boolean _validar = this.SUT.validar(this.mailPotencialmenteCorrecto);
    Assert.assertFalse(_validar);
  }
  
  @Test
  public void test_agrego_nuevo_dominio_y_funciona_correctamente() {
    this.SUT.agregarNuevoDominio("noSirvo.edu.ar");
    boolean _validar = this.SUT.validar(this.mailPotencialmenteCorrecto);
    Assert.assertTrue(_validar);
  }
}
