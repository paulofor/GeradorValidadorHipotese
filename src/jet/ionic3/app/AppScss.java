package jet.ionic3.app;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.base.node.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;
import gerapp.modelo.node.*;
import loopback.cliente.modelo.*;

public class AppScss
{
  protected static String nl;
  public static synchronized AppScss create(String lineSeparator)
  {
    nl = lineSeparator;
    AppScss result = new AppScss();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + ".quadroBase {" + NL + "    background-color:";
  protected final String TEXT_3 = NL + "}" + NL + ".quadroTitulo {" + NL + "    background-color:";
  protected final String TEXT_4 = NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
PaletaCorRest paleta = recursos.getPaletaCor();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_2);
    stringBuffer.append( paleta.getCor2() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( paleta.getCor2() );
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}
