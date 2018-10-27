package jet.angular.loopback;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;

public class IndexService
{
  protected static String nl;
  public static synchronized IndexService create(String lineSeparator)
  {
    nl = lineSeparator;
    IndexService result = new IndexService();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "export * from './";
  protected final String TEXT_3 = "';";
  protected final String TEXT_4 = NL + "export * from './Container';" + NL + "export * from './SDKModels';" + NL + "export * from './logger.service';";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
List<ClasseWrapper> classes = recursos.getListaClasse();
Configuracao conf = recursos.getConfiguracao();

    
Iterator<ClasseWrapper> iterador = classes.iterator();
while (iterador.hasNext()) {
	ClasseWrapper classe = iterador.next();

    stringBuffer.append(TEXT_2);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_3);
    
}

    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}
