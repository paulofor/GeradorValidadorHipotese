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
<<<<<<< HEAD
  protected final String TEXT_4 = NL + "}";
=======
  protected final String TEXT_4 = NL + "}" + NL + "" + NL + "" + NL + ".linha1 {" + NL + "    padding-top: 3px" + NL + "}" + NL + ".linhan {" + NL + "    padding-top: 1px; " + NL + "}" + NL + "" + NL + "" + NL + ".quadro10 {" + NL + "    height: 10%;" + NL + "}" + NL + ".quadro20 {" + NL + "    height: 20%;" + NL + "}" + NL + ".quadro30 {" + NL + "    height: 30%;" + NL + "}" + NL + ".quadro40 {" + NL + "    height: 40%;" + NL + "}" + NL + ".quadro50 {" + NL + "    height: 50%;" + NL + "}" + NL + ".quadro60 {" + NL + "    height: 60%;" + NL + "}" + NL + ".quadro70 {" + NL + "    height: 70%;" + NL + "}" + NL + ".quadro80 {" + NL + "    height: 80%;" + NL + "}" + NL + ".quadro90 {" + NL + "    height: 90%;" + NL + "}";
>>>>>>> c70d4da1a0217900b196db61835d24c3c6435e10

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
