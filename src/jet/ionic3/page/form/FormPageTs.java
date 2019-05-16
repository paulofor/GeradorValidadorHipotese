package jet.ionic3.page.form;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.base.node.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;
import gerapp.modelo.node.*;

public class FormPageTs
{
  protected static String nl;
  public static synchronized FormPageTs create(String lineSeparator)
  {
    nl = lineSeparator;
    FormPageTs result = new FormPageTs();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
<<<<<<< HEAD
  protected final String TEXT_1 = "import { Component } from '@angular/core';" + NL + "import { IonicPage, ModalController, NavController } from 'ionic-angular';" + NL + "import { Screenshot } from '@ionic-native/screenshot';" + NL + "" + NL + "import { ";
  protected final String TEXT_2 = ", ";
  protected final String TEXT_3 = "Api } from '../../shared/sdk';" + NL + "" + NL + "@IonicPage()" + NL + "@Component({" + NL + "  selector: '";
  protected final String TEXT_4 = "'," + NL + "  templateUrl: '";
  protected final String TEXT_5 = ".html'" + NL + "})" + NL + "export class ";
  protected final String TEXT_6 = " {" + NL + "  item: ";
  protected final String TEXT_7 = ";" + NL + "" + NL + "  constructor(public navCtrl: NavController, public srv: ";
  protected final String TEXT_8 = "Api, " + NL + "  \t\t\t\tprivate screenshot: Screenshot, public modalCtrl: ModalController) {" + NL + "  }" + NL + "" + NL + "  ionViewWillEnter() {" + NL + "    console.log('ionViewWillEnter ";
  protected final String TEXT_9 = "');" + NL + "    this.carregaItem();" + NL + "  }" + NL + "" + NL + "  ionViewDidLoad() {" + NL + "  \tconsole.log('ionViewDidLoad ";
  protected final String TEXT_10 = "');" + NL + "  }" + NL + "  " + NL + "  carregaItem() {" + NL + "    this.srv.obtemPrimeiro()" + NL + "      .subscribe((result: ";
  protected final String TEXT_11 = ") => {" + NL + "        console.log('Result', JSON.stringify(result));" + NL + "        this.item = result;" + NL + "      });" + NL + "  }" + NL + "" + NL + "  testaFoto() {" + NL + "    this.screenshot.save('jpg', 100, '";
  protected final String TEXT_12 = "');" + NL + "  }" + NL + "  " + NL + "}";
=======
  protected final String TEXT_1 = "import { Component } from '@angular/core';" + NL + "import { IonicPage, ModalController, NavController } from 'ionic-angular';" + NL + "import { Screenshot } from '@ionic-native/screenshot';" + NL + "import { CriaSerieWorkPageBase } from './cria-serie-work-base';" + NL + "import { ";
  protected final String TEXT_2 = ", ";
  protected final String TEXT_3 = "Api, LoopBackFilter } from '../../shared/sdk';" + NL + "import { Storage } from '@ionic/storage';" + NL + "" + NL + "@IonicPage()" + NL + "@Component({" + NL + "  selector: '";
  protected final String TEXT_4 = "'," + NL + "  templateUrl: '";
  protected final String TEXT_5 = ".html'" + NL + "})" + NL + "export class ";
  protected final String TEXT_6 = " extends ";
  protected final String TEXT_7 = "Base {" + NL + "" + NL + "" + NL + "  constructor(\tpublic navParams: NavParams," + NL + "  \t\t\t\tpublic navCtrl: NavController," + NL + "\t\t\t\tpublic srv: ";
  protected final String TEXT_8 = "Api, " + NL + "\t\t\t\tprotecte storage: Storage,";
  protected final String TEXT_9 = NL + "\t\t\t\tpublic srv";
  protected final String TEXT_10 = " : ";
  protected final String TEXT_11 = "Api,";
  protected final String TEXT_12 = NL + "  \t\t\t\t) {" + NL + "  }" + NL + "" + NL + "  protected inicializacaoComplementos() {" + NL + "    throw new Error(\"Method not implemented.\");" + NL + "  }" + NL + "  protected criaItem(): ItemSerie {" + NL + "    throw new Error(\"Method not implemented.\");" + NL + "  }" + NL + "  protected executaNavegacao(navCtrl: NavController, result: ItemSerie) {" + NL + "    throw new Error(\"Method not implemented.\");" + NL + "  }" + NL + "  protected filtroLoadId(id: any): LoopBackFilter {" + NL + "    throw new Error(\"Method not implemented.\");" + NL + "  }" + NL + "  protected complementaItem(novo: ItemSerie): ItemSerie {" + NL + "    throw new Error(\"Method not implemented.\");" + NL + "  }" + NL + "" + NL + "  " + NL + "}";
>>>>>>> c70d4da1a0217900b196db61835d24c3c6435e10
  protected final String TEXT_13 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
Recursos recursos = (Recursos) argument;  
TelaAppWrapper tela = (TelaAppWrapper) recursos.getItemCorrente();
<<<<<<< HEAD
=======
ClasseWrapper classe = tela.getEntidade();
>>>>>>> c70d4da1a0217900b196db61835d24c3c6435e10
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_1);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( tela.getNomeControle() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( tela.getArquivo() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_6);
<<<<<<< HEAD
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_11);
    stringBuffer.append( tela.getNome() );
=======
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_8);
    
Iterator<RelacionamentoWrapper> itRel =  classe.obtemListaSemChaveEstrangeira().iterator();
while (itRel.hasNext()) {
	RelacionamentoWrapper relac = itRel.next();
	ClasseWrapper oposta = relac.getClasseOposta();

    stringBuffer.append(TEXT_9);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_11);
    
}

>>>>>>> c70d4da1a0217900b196db61835d24c3c6435e10
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}
