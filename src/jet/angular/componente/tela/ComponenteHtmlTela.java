package jet.angular.componente.tela;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.base.node.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;

public class ComponenteHtmlTela
{
  protected static String nl;
  public static synchronized ComponenteHtmlTela create(String lineSeparator)
  {
    nl = lineSeparator;
    ComponenteHtmlTela result = new ComponenteHtmlTela();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
TelaWebWrapper tela = (TelaWebWrapper) recursos.getItemCorrente();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}
