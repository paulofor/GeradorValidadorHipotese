package jet.ionic3.page.form;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.base.node.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;
import gerapp.modelo.node.*;

public class FormPageHtml
{
  protected static String nl;
  public static synchronized FormPageHtml create(String lineSeparator)
  {
    nl = lineSeparator;
    FormPageHtml result = new FormPageHtml();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "<ion-header >" + NL + "  <ion-navbar color=\"titulo\">" + NL + "    <ion-title (click)=\"testaFoto()\">";
<<<<<<< HEAD
  protected final String TEXT_3 = "</ion-title>" + NL + "  </ion-navbar>" + NL + "</ion-header>" + NL + "" + NL + "<ion-content padding class=\"quadroBase\">" + NL + "\t<ng-container *ngIf=\"item\">" + NL + "" + NL + "\t</ng-container>" + NL + "</ion-content>";
=======
  protected final String TEXT_3 = "</ion-title>" + NL + "  </ion-navbar>" + NL + "</ion-header>" + NL + "" + NL + "<ion-content padding class=\"quadroBase\">" + NL + " <ion-card>" + NL + "    <form>" + NL + "    " + NL + "      <ion-item>" + NL + "        <ion-label floating>Grupo Muscular</ion-label>" + NL + "        <ion-select>" + NL + "          <ion-option value=\"f\">Peitoral</ion-option>" + NL + "          <ion-option value=\"m\">Male</ion-option>" + NL + "        </ion-select>" + NL + "      </ion-item>" + NL + "     " + NL + "      <ion-item>" + NL + "        <ion-label floating>Carga</ion-label>" + NL + "        <ion-input type=\"text\"></ion-input>" + NL + "      </ion-item>" + NL + "" + NL + "      <button ion-button type=\"submit\" block>Adicionar</button>" + NL + "    </form>" + NL + "  </ion-card>" + NL + "</ion-content>";
>>>>>>> c70d4da1a0217900b196db61835d24c3c6435e10

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
TelaAppWrapper tela = (TelaAppWrapper) recursos.getItemCorrente();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_2);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}
