package jet.ionic3.page.listaVitrine;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.base.node.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;
import gerapp.modelo.node.*;

public class ListaItemPageTs
{
  protected static String nl;
  public static synchronized ListaItemPageTs create(String lineSeparator)
  {
    nl = lineSeparator;
    ListaItemPageTs result = new ListaItemPageTs();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + NL + "import { Component } from '@angular/core';" + NL + "import { IonicPage, ModalController, NavController } from 'ionic-angular';" + NL + "import { Screenshot } from '@ionic-native/screenshot';" + NL + "" + NL + "" + NL + "import { ";
  protected final String TEXT_3 = ", ";
  protected final String TEXT_4 = "Api } from '../../shared/sdk';" + NL + "" + NL + "@IonicPage()" + NL + "@Component({" + NL + "  selector: '";
  protected final String TEXT_5 = "'," + NL + "  templateUrl: '";
  protected final String TEXT_6 = ".html'" + NL + "})" + NL + "export class ";
  protected final String TEXT_7 = " {" + NL + "  listaItem: ";
  protected final String TEXT_8 = "[];" + NL + "" + NL + "  constructor(public navCtrl: NavController, public srv: ";
  protected final String TEXT_9 = "Api, " + NL + "  \t\t\t\t private screenshot: Screenshot, public modalCtrl: ModalController) {" + NL + "  }" + NL + "" + NL + "  ionViewWillEnter() {" + NL + "    console.log('ionViewWillEnter ";
  protected final String TEXT_10 = "');" + NL + "    this.carregaLista();" + NL + "  }" + NL + "" + NL + "  ionViewDidLoad() {" + NL + "  \tconsole.log('ionViewDidLoad ";
  protected final String TEXT_11 = "');" + NL + "  }" + NL + "  " + NL + "  carregaLista() {" + NL + "    this.srv.obtemLista()" + NL + "      .subscribe((result: ";
  protected final String TEXT_12 = "[]) => {" + NL + "        console.log('Result', JSON.stringify(result));" + NL + "        this.listaItem = result;" + NL + "      });" + NL + "  }" + NL + "  " + NL + "  testaFoto() {" + NL + "    this.screenshot.save('jpg', 100, '";
  protected final String TEXT_13 = "');" + NL + "  }" + NL + "" + NL + "  " + NL + "}";
  protected final String TEXT_14 = NL;

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
    stringBuffer.append( tela.getNomeControle() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( tela.getArquivo() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_11);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    return stringBuffer.toString();
  }
}
