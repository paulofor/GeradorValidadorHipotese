package jet.ionic3.page.listaItem;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.base.node.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;
import gerapp.modelo.node.*;

public class ListaItemPageHtml
{
  protected static String nl;
  public static synchronized ListaItemPageHtml create(String lineSeparator)
  {
    nl = lineSeparator;
    ListaItemPageHtml result = new ListaItemPageHtml();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
<<<<<<< HEAD
  protected final String TEXT_2 = NL + NL + "<ion-header>" + NL + "  <ion-navbar color=\"titulo\">" + NL + "    <ion-title (click)=\"testaFoto()\">";
  protected final String TEXT_3 = "</ion-title>" + NL + "  </ion-navbar>" + NL + "</ion-header>" + NL + "" + NL + "<ion-content padding class=\"quadroBase\">" + NL + "\t<ng-container *ngIf=\"listaItem\">" + NL + "   \t<ion-list>" + NL + "      <ion-item *ngFor=\"let item of listaItem\">" + NL + "" + NL + "      </ion-item>" + NL + "    </ion-list>" + NL + "\t</ng-container>" + NL + "</ion-content>";
=======
  protected final String TEXT_2 = NL + NL + "<ion-header>" + NL + "  <ion-navbar color=\"titulo\">" + NL + "    <ion-title>";
  protected final String TEXT_3 = "</ion-title>" + NL + "  </ion-navbar>" + NL + "</ion-header>" + NL + "" + NL + "<ion-content padding class=\"quadroBase\">" + NL + "" + NL + "  <ng-container *ngIf=\"listaItem\">" + NL + "" + NL + "    <ion-card *ngIf=\"listaItem.length==0\">" + NL + "      <ion-card-header>" + NL + "        Nenhum ... encontrada" + NL + "      </ion-card-header>" + NL + "      <ion-card-content>" + NL + "        Crie " + NL + "      </ion-card-content>" + NL + "    </ion-card>" + NL + "" + NL + "    <ion-list *ngIf=\"listaItem.length>0\">" + NL + "      <ion-item *ngFor=\"let item of listaItem\">" + NL + "        <h3 class=\"linha1\"></h3>" + NL + "        <h3 class=\"linhan\"></h3>" + NL + "        <button ion-button clear item-end (click)=\"alterarId(item)\">alterar</button>" + NL + "      </ion-item>" + NL + "    </ion-list>" + NL + "" + NL + "  </ng-container>" + NL + "" + NL + "  <ion-fab right bottom>" + NL + "    <button ion-fab (click)=\"novo()\">Criar</button>" + NL + "  </ion-fab>" + NL + "" + NL + "</ion-content>";
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
