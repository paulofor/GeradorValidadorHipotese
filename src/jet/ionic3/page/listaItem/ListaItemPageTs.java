package jet.ionic3.page.listaItem;

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
  protected final String TEXT_2 = NL + NL + NL + "import { Component } from '@angular/core';" + NL + "import { IonicPage, ModalController, NavController } from 'ionic-angular';" + NL + "import { Screenshot } from '@ionic-native/screenshot';" + NL + "import { ";
  protected final String TEXT_3 = "Base } from './";
  protected final String TEXT_4 = "-base';" + NL + "" + NL + "import { ";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = "Api } from '../../shared/sdk';" + NL + "" + NL + "@IonicPage()" + NL + "@Component({" + NL + "  selector: '";
  protected final String TEXT_7 = "'," + NL + "  templateUrl: '";
  protected final String TEXT_8 = ".html'" + NL + "})" + NL + "export class ";
  protected final String TEXT_9 = " extends ";
  protected final String TEXT_10 = "Base {" + NL + "" + NL + "" + NL + "" + NL + "  constructor(protected navCtrl: NavController, protected srv: ";
  protected final String TEXT_11 = "Api," + NL + "    protected screenshot: Screenshot) {" + NL + "    super(navCtrl, srv, screenshot);" + NL + "  }" + NL + "" + NL + "  ionViewWillEnter() {" + NL + "    console.log('ionViewWillEnter ";
  protected final String TEXT_12 = "');" + NL + "    this.carregaListaPrototipo();" + NL + "  }" + NL + "" + NL + "  ionViewDidLoad() {" + NL + "  \tconsole.log('ionViewDidLoad ";
  protected final String TEXT_13 = "');" + NL + "  }" + NL + "  " + NL + " " + NL + "" + NL + "  " + NL + "}";
  protected final String TEXT_14 = NL;

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
    stringBuffer.append( tela.getArquivo() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( tela.getNomeControle() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( tela.getArquivo() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_11);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    return stringBuffer.toString();
  }
}
