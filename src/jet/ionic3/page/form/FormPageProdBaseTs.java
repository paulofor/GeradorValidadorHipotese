package jet.ionic3.page.form;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.base.node.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;
import gerapp.modelo.node.*;

public class FormPageProdBaseTs
{
  protected static String nl;
  public static synchronized FormPageProdBaseTs create(String lineSeparator)
  {
    nl = lineSeparator;
    FormPageProdBaseTs result = new FormPageProdBaseTs();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "import { ";
  protected final String TEXT_2 = ", ";
  protected final String TEXT_3 = "Api , LoopBackFilter } from '../../shared/sdk';";
  protected final String TEXT_4 = NL + "import { ";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = "Api } from '../../shared/sdk';";
  protected final String TEXT_7 = NL + "import { NavParams, NavController } from 'ionic-angular';" + NL + "" + NL + "export abstract class ";
  protected final String TEXT_8 = "Base {" + NL + "  " + NL + "  protected item: ";
  protected final String TEXT_9 = ";" + NL + "  " + NL + "  protected abstract inicializacaoComplementos();" + NL + "  protected abstract criaItem() : ";
  protected final String TEXT_10 = ";" + NL + "  protected abstract executaNavegacao(navCtrl: NavController, result: ";
  protected final String TEXT_11 = ");" + NL + "  protected abstract filtroLoadId() : LoopBackFilter;" + NL + "  protected abstract complementaItem(novo:";
  protected final String TEXT_12 = ") : ";
  protected final String TEXT_13 = ";" + NL + "" + NL + "  constructor(\tpublic navParams: NavParams," + NL + "  \t\t\t\tpublic navCtrl: NavController," + NL + "\t\t\t\tpublic srv: ";
  protected final String TEXT_14 = "Api, ";
  protected final String TEXT_15 = NL + "\t\t\t\tpublic srv";
  protected final String TEXT_16 = " : ";
  protected final String TEXT_17 = "Api,";
  protected final String TEXT_18 = NL + "  \t\t\t\t) {" + NL + "  }" + NL + "  private inicializaItem() {" + NL + "\tthis.item = this.navParams.get('item');" + NL + "\tconsole.log('";
  protected final String TEXT_19 = "Base:ItemParametro: ', this.item);" + NL + "\tif (!this.item) {" + NL + "\t\tvar id = this.navParams.get('id');" + NL + "\t\tif (id) {" + NL + "\t\t\tconsole.log('";
  protected final String TEXT_20 = "Base:Id: ' , id);" + NL + "\t\t\tthis.srv.findById(id, this.filtroLoadId())" + NL + "\t\t\t\t.subscribe((result:";
  protected final String TEXT_21 = ") => {" + NL + "\t\t\t\t\tthis.item = result;" + NL + "\t\t\t\t\tconsole.log('";
  protected final String TEXT_22 = "Base:LoadId: ' , this.item);" + NL + "\t\t\t\t})" + NL + "\t\t} else {" + NL + "\t\t\tthis.item = this.criaItem();" + NL + "\t\t\tconsole.log('";
  protected final String TEXT_23 = "Base:ItemCriado: ', this.item);" + NL + "\t\t}" + NL + "\t} else {" + NL + "\t\tthis.item = this.complementaItem(this.item);" + NL + "\t}" + NL + "  }" + NL + "  ionViewWillEnter() {" + NL + "    console.log('ionViewWillEnter ";
  protected final String TEXT_24 = "');" + NL + "    this.inicializacaoComplementos();" + NL + "    this.inicializaItem();" + NL + "  }" + NL + "  ionViewDidLoad() {" + NL + "  \tconsole.log('ionViewDidLoad ";
  protected final String TEXT_25 = "');" + NL + "  }" + NL + "  ";
  protected final String TEXT_26 = NL + "\tprotected lista";
  protected final String TEXT_27 = " : ";
  protected final String TEXT_28 = "[];" + NL + "\tprotected carrega";
  protected final String TEXT_29 = "(){" + NL + "\t\tthis.srv";
  protected final String TEXT_30 = ".find()" + NL + "      \t\t.subscribe((result:";
  protected final String TEXT_31 = "[]) => {" + NL + "        \t\tconsole.log('lista";
  protected final String TEXT_32 = ":' , result);" + NL + "        \t\tthis.lista";
  protected final String TEXT_33 = " = result;" + NL + "      \t})" + NL + "\t}" + NL + "\tprotected lista";
  protected final String TEXT_34 = "Usuario : ";
  protected final String TEXT_35 = "[];" + NL + "\tprotected carrega";
  protected final String TEXT_36 = "Usuario(idUsuario:number){" + NL + "\t\tthis.srv";
  protected final String TEXT_37 = ".find({'where' : {'idUsuario' : idUsuario} })" + NL + "      \t\t.subscribe((result:";
  protected final String TEXT_38 = "[]) => {" + NL + "        \t\tthis.lista";
  protected final String TEXT_39 = "Usuario = result;" + NL + "      \t})" + NL + "\t}";
  protected final String TEXT_40 = NL + "\tprotected submit() {" + NL + "\t\tconsole.log('";
  protected final String TEXT_41 = "Base:Submit-Item:' , this.item);" + NL + "    \tthis.srv.submit";
  protected final String TEXT_42 = "(this.item)" + NL + "      \t\t.subscribe((resultado:";
  protected final String TEXT_43 = ") => {" + NL + "        \t\tconsole.log('";
  protected final String TEXT_44 = "Base:Submit-Result: ' , resultado);" + NL + "\t\t\t\tthis.executaNavegacao(this.navCtrl,resultado);" + NL + "      \t})" + NL + "\t}" + NL + "}";
  protected final String TEXT_45 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
Recursos recursos = (Recursos) argument;  
TelaAppWrapper tela = (TelaAppWrapper) recursos.getItemCorrente();
ClasseWrapper classe = tela.getEntidade();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_1);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_3);
    
Iterator<RelacionamentoWrapper> itRel =  classe.obtemListaSemChaveEstrangeira().iterator();
while (itRel.hasNext()) {
	RelacionamentoWrapper relac = itRel.next();
	ClasseWrapper oposta = relac.getClasseOposta();

    stringBuffer.append(TEXT_4);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_6);
    
}

    stringBuffer.append(TEXT_7);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_11);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_13);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_14);
    
itRel =  classe.obtemListaSemChaveEstrangeira().iterator();
while (itRel.hasNext()) {
	RelacionamentoWrapper relac = itRel.next();
	ClasseWrapper oposta = relac.getClasseOposta();

    stringBuffer.append(TEXT_15);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_17);
    
}

    stringBuffer.append(TEXT_18);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_20);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_21);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_22);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_24);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_25);
    
itRel =  classe.obtemListaSemChaveEstrangeira().iterator();
while (itRel.hasNext()) {
	RelacionamentoWrapper relac = itRel.next();
	ClasseWrapper oposta = relac.getClasseOposta();

    stringBuffer.append(TEXT_26);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_27);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_28);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_29);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_30);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_31);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_32);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_33);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_35);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_36);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_38);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_39);
    
}

    stringBuffer.append(TEXT_40);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_41);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_42);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_43);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(TEXT_45);
    return stringBuffer.toString();
  }
}
