package jet.angular.componente.tela;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.base.node.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;
import gerapp.modelo.node.*;

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
  protected final String TEXT_3 = NL + "\t<";
  protected final String TEXT_4 = "></";
  protected final String TEXT_5 = ">";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
TelaWebWrapper tela = (TelaWebWrapper) recursos.getItemCorrente();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_2);
    
Iterator<ItemComponente> iterador = tela.getComponenteIterator();
while (iterador.hasNext()) {
	ComponenteWebWrapper comp = (ComponenteWebWrapper) iterador.next();

    stringBuffer.append(TEXT_3);
    stringBuffer.append( comp.getNomeControle() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( comp.getNomeControle() );
    stringBuffer.append(TEXT_5);
    
	}

    return stringBuffer.toString();
  }
}
