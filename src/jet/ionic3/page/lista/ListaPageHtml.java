package jet.ionic3.page.lista;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.base.node.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;
import gerapp.modelo.node.*;

public class ListaPageHtml
{
  protected static String nl;
  public static synchronized ListaPageHtml create(String lineSeparator)
  {
    nl = lineSeparator;
    ListaPageHtml result = new ListaPageHtml();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "<ion-header>" + NL + "" + NL + "  <ion-navbar>" + NL + "    <ion-title>{{ 'LIST_MASTER_TITLE' | translate }}</ion-title>" + NL + "" + NL + "    <ion-buttons end>" + NL + "      <button ion-button icon-only (click)=\"addItem()\">" + NL + "        <ion-icon name=\"add\"></ion-icon>" + NL + "      </button>" + NL + "    </ion-buttons>" + NL + "  </ion-navbar>" + NL + "" + NL + "</ion-header>" + NL + "" + NL + "<ion-content>" + NL + "" + NL + "  <ion-list>" + NL + "    <ion-item-sliding *ngFor=\"let item of currentItems\">" + NL + "      <button ion-item (click)=\"openItem(item)\">" + NL + "        <h2>{{item.nome}}</h2>" + NL + "      </button>" + NL + "" + NL + "      <ion-item-options>" + NL + "        <button ion-button color=\"danger\" (click)=\"deleteItem(item)\">" + NL + "          {{ 'DELETE_BUTTON' | translate }}" + NL + "        </button>" + NL + "      </ion-item-options>" + NL + "    </ion-item-sliding>" + NL + "  </ion-list>" + NL + "</ion-content>";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
TelaAppWrapper tela = (TelaAppWrapper) recursos.getItemCorrente();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}
