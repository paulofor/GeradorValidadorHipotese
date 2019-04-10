package jet.server.model;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;
import gerapp.modelo.node.*;

public class ModelJson
{
  protected static String nl;
  public static synchronized ModelJson create(String lineSeparator)
  {
    nl = lineSeparator;
    ModelJson result = new ModelJson();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "{" + NL + "  \"name\": \"";
  protected final String TEXT_3 = "\"," + NL + "  \"base\": \"PersistedModel\"," + NL + "  \"idInjection\": true," + NL + "  \"options\": {" + NL + "    \"validateUpsert\": true" + NL + "  }," + NL + "  \"properties\": {" + NL + "    \"id\": {" + NL + "      \"type\": \"string\"" + NL + "    }";
  protected final String TEXT_4 = NL + "\t,\"";
  protected final String TEXT_5 = "\": {" + NL + "      \"type\": \"";
  protected final String TEXT_6 = "\"" + NL + "    }";
  protected final String TEXT_7 = NL + "  }," + NL + "  \"validations\": []," + NL + "  \"relations\": {}," + NL + "  \"acls\": []," + NL + "  \"methods\": {}" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
Configuracao conf = recursos.getConfiguracao();
ItemLoopbackServer classe = (ItemLoopbackServer) recursos.getClasse();

    stringBuffer.append(TEXT_2);
    stringBuffer.append( classe.getNomeModeloServer() );
    stringBuffer.append(TEXT_3);
    
Iterator<AtributoWrapper> iteradorAtt = classe.getIteratorAtributo();
while (iteradorAtt.hasNext()) {
	AtributoWrapper atributo = (AtributoWrapper) iteradorAtt.next();

    stringBuffer.append(TEXT_4);
    stringBuffer.append( atributo.getNomePropriedade() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( atributo.getTipoNode() );
    stringBuffer.append(TEXT_6);
    
}

    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
