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
  protected final String TEXT_2 = NL + NL + "<ion-header *ngIf=\"listaItem\">" + NL + "  <ion-navbar color=\"primary\">" + NL + "    <ion-title>Titulo</ion-title>" + NL + "  </ion-navbar>" + NL + "</ion-header>" + NL + "" + NL + "<ion-content padding>" + NL + "\t<ng-container *ngIf=\"listaItem\">" + NL + "   \t<ion-list>" + NL + "      <ion-item *ngFor=\"let item of listaItem\">" + NL + "" + NL + "      </ion-item>" + NL + "    </ion-list>" + NL + "\t</ng-container>" + NL + "</ion-content>";

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