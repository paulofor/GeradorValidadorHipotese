package jet.angular.componente.aplicacao;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.base.node.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;

public class SidebarHtml
{
  protected static String nl;
  public static synchronized SidebarHtml create(String lineSeparator)
  {
    nl = lineSeparator;
    SidebarHtml result = new SidebarHtml();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "<div class=\"sidebar\" data-color=\"purple\" data-image=\"../../assets-lbd/img/sidebar-5.jpg\">" + NL + "  <!--" + NL + "      Tip 1: you can change the color of the sidebar using: data-color=\"blue | azure | green | orange | red | purple\"" + NL + "      Tip 2: you can also add an image using data-image tag" + NL + "      versao nova" + NL + "  -->" + NL + "  <div class=\"sidebar-wrapper\">" + NL + "  " + NL + "    <div class=\"logo\">" + NL + "      <a href=\"http://www.creative-tim.com\" class=\"simple-text\">" + NL + "        Digicom" + NL + "      </a>" + NL + "    </div>" + NL + "" + NL + "    <ul class=\"nav\">";
  protected final String TEXT_3 = NL + "\t<li>" + NL + "    \t<a routerLink=\"/home/";
  protected final String TEXT_4 = "\">" + NL + "    \t<i class=\"pe-7s-graph\"></i>" + NL + "    \t<p>";
  protected final String TEXT_5 = "</p>" + NL + "    \t</a>" + NL + "    </li>";
  protected final String TEXT_6 = NL + "    </ul>" + NL + "    " + NL + "  </div>" + NL + "</div>";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
List<TelaWebWrapper> telas = recursos.getListaTelaWeb();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_2);
    
Iterator<TelaWebWrapper> iterador = telas.iterator();
while (iterador.hasNext()) {
	TelaWebWrapper tela = iterador.next();

    stringBuffer.append(TEXT_3);
    stringBuffer.append( tela.getNomeUrl() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( tela.getNomeMenu() );
    stringBuffer.append(TEXT_5);
    
	}

    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
