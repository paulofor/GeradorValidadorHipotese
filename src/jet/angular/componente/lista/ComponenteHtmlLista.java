package jet.angular.componente.lista;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;

public class ComponenteHtmlLista
{
  protected static String nl;
  public static synchronized ComponenteHtmlLista create(String lineSeparator)
  {
    nl = lineSeparator;
    ComponenteHtmlLista result = new ComponenteHtmlLista();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "<p>Componente Lista</p>";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
ClasseWrapperAngular classe = (ClasseWrapperAngular) recursos.getItemCorrente();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}
