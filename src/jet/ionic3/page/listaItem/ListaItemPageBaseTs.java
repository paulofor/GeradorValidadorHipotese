package jet.ionic3.page.listaItem;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.base.node.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;
import gerapp.modelo.node.*;

public class ListaItemPageBaseTs
{
  protected static String nl;
  public static synchronized ListaItemPageBaseTs create(String lineSeparator)
  {
    nl = lineSeparator;
    ListaItemPageBaseTs result = new ListaItemPageBaseTs();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + NL + "import { Component } from '@angular/core';" + NL + "import { IonicPage, ModalController, NavController } from 'ionic-angular';" + NL + "import { Screenshot } from '@ionic-native/screenshot';" + NL + "" + NL + "" + NL + "import { ";
  protected final String TEXT_3 = ", ";
  protected final String TEXT_4 = "Api } from '../../shared/sdk';" + NL + "" + NL + "" + NL + "export abstract class ";
  protected final String TEXT_5 = "Base {" + NL + "" + NL + "  protected item: ";
  protected final String TEXT_6 = ";" + NL + "" + NL + "  constructor(protected navCtrl: NavController, protected srv: ";
  protected final String TEXT_7 = "Api, " + NL + "  \t\t\t\t protected screenshot: Screenshot) {" + NL + "  }" + NL + "" + NL + "  //protected abstract getLista();" + NL + "  " + NL + "  protected carrega() {" + NL + "    this.srv.";
  protected final String TEXT_8 = "()" + NL + "      .subscribe((result: ";
  protected final String TEXT_9 = ") => {" + NL + "        console.log('Result', JSON.stringify(result));" + NL + "        this.item = result;" + NL + "      });" + NL + "  }" + NL + "  " + NL + "   " + NL + "  protected carregaPrototipo() {" + NL + "    this.srv.";
  protected final String TEXT_10 = "()" + NL + "      .subscribe((result: ";
  protected final String TEXT_11 = ") => {" + NL + "        console.log('Result-Prototipo', JSON.stringify(result));" + NL + "        this.item = result;" + NL + "      });" + NL + "  }" + NL + "  " + NL + "  protected testaFoto() {" + NL + "    this.screenshot.save('jpg', 100, '";
  protected final String TEXT_12 = "');" + NL + "  }" + NL + "" + NL + "  " + NL + "}";
  protected final String TEXT_13 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
TelaAppWrapper tela = (TelaAppWrapper) recursos.getItemCorrente();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_2);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( tela.getMetodoCarga() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append( tela.getMetodoCarga() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_11);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}
