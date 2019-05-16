package jet.server.model;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;
import gerapp.modelo.node.*;

public class ModelJs
{
  protected static String nl;
  public static synchronized ModelJs create(String lineSeparator)
  {
    nl = lineSeparator;
    ModelJs result = new ModelJs();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "'use strict';" + NL + "" + NL + "module.exports = function(";
  protected final String TEXT_3 = ") {" + NL + "" + NL + "};";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
Configuracao conf = recursos.getConfiguracao();
ItemLoopbackServer classe = (ItemLoopbackServer) recursos.getClasse();

    stringBuffer.append(TEXT_2);
    stringBuffer.append( classe.getNomeParametroServer() );
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}
