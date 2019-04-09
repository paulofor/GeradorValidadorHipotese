package jet.server.app;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;
import gerapp.modelo.node.*;

public class ModelConfigJson
{
  protected static String nl;
  public static synchronized ModelConfigJson create(String lineSeparator)
  {
    nl = lineSeparator;
    ModelConfigJson result = new ModelConfigJson();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "{" + NL + "  \"_meta\": {" + NL + "    \"sources\": [" + NL + "      \"loopback/common/models\"," + NL + "      \"loopback/server/models\"," + NL + "      \"../common/models\"," + NL + "      \"../common/models/treino\"," + NL + "      \"./models\"" + NL + "    ]," + NL + "    \"mixins\": [" + NL + "      \"loopback/common/mixins\"," + NL + "      \"loopback/server/mixins\"," + NL + "      \"../common/mixins\"," + NL + "      \"./mixins\"" + NL + "    ]" + NL + "  }," + NL + "  \"User\": {" + NL + "    \"dataSource\": \"db\"" + NL + "  }," + NL + "  \"AccessToken\": {" + NL + "    \"dataSource\": \"db\"," + NL + "    \"public\": false" + NL + "  }," + NL + "  \"ACL\": {" + NL + "    \"dataSource\": \"db\"," + NL + "    \"public\": false" + NL + "  }," + NL + "  \"RoleMapping\": {" + NL + "    \"dataSource\": \"db\"," + NL + "    \"public\": false," + NL + "    \"options\": {" + NL + "      \"strictObjectIDCoercion\": true" + NL + "    }" + NL + "  }," + NL + "  \"Role\": {" + NL + "    \"dataSource\": \"db\"," + NL + "    \"public\": false" + NL + "  }," + NL + "  \"ExemploModelo\": {" + NL + "    \"dataSource\": \"mysqlDS\"," + NL + "    \"public\": true" + NL + "  }";
  protected final String TEXT_3 = NL + "  ,\"";
  protected final String TEXT_4 = "\": {" + NL + "    \"dataSource\": \"mysqlDS\"," + NL + "    \"public\": true" + NL + "  }";
  protected final String TEXT_5 = NL + "}";
  protected final String TEXT_6 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
Configuracao conf = recursos.getConfiguracao();
List<ClasseWrapper> listaClasse = recursos.getListaClasse();

    stringBuffer.append(TEXT_2);
    
Iterator<ClasseWrapper> iterador = listaClasse.iterator();
while (iterador.hasNext()) {
	ItemLoopbackServer item = (ItemLoopbackServer) iterador.next();

    stringBuffer.append(TEXT_3);
    stringBuffer.append( item.getNomeModeloServer() );
    stringBuffer.append(TEXT_4);
    
}

    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
