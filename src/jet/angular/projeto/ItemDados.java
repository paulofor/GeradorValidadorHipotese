package jet.angular.projeto;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;
import gerapp.modelo.node.*;

public class ItemDados
{
  protected static String nl;
  public static synchronized ItemDados create(String lineSeparator)
  {
    nl = lineSeparator;
    ItemDados result = new ItemDados();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "import { ";
  protected final String TEXT_3 = " } from \"../shared/sdk/models\";" + NL + "" + NL + "export const  ";
  protected final String TEXT_4 = " : ";
  protected final String TEXT_5 = "[] = [" + NL + "]";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
ClasseWrapper classe = (ClasseWrapper) recursos.getItemCorrente();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_2);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( classe.getNomeParaConstante() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}
