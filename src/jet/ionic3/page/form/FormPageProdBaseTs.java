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
  protected final String TEXT_3 = "Api } from '../../shared/sdk';";
  protected final String TEXT_4 = NL + "import { ";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = "Api } from '../../shared/sdk';";
  protected final String TEXT_7 = NL + "import { NavParams, NavController } from 'ionic-angular';" + NL + "" + NL + "export abstract class ";
  protected final String TEXT_8 = "Base {" + NL + "  " + NL + "  protected item: ";
  protected final String TEXT_9 = ";" + NL + "  " + NL + "  protected abstract inicializacaoComplementos();" + NL + "  protected abstract criaItem() : ";
  protected final String TEXT_10 = ";" + NL + "" + NL + "  constructor(\tpublic navParams: NavParams," + NL + "  \t\t\t\tpublic navCtrl: NavController," + NL + "\t\t\t\tpublic srv: ";
  protected final String TEXT_11 = "Api, ";
  protected final String TEXT_12 = NL + "\t\t\t\tpublic srv";
  protected final String TEXT_13 = " : ";
  protected final String TEXT_14 = "Api,";
  protected final String TEXT_15 = NL + "  \t\t\t\t) {" + NL + "  }" + NL + "" + NL + "" + NL + "  private inicializaItem() {" + NL + "\tthis.item = this.navParams.get('item');" + NL + "\tconsole.log('Item: ', this.item);" + NL + "\tif (!this.item) this.item = this.criaItem();" + NL + "  }" + NL + "" + NL + "" + NL + "  ionViewWillEnter() {" + NL + "    console.log('ionViewWillEnter ";
  protected final String TEXT_16 = "');" + NL + "    this.inicializacaoComplementos();" + NL + "    this.inicializaItem();" + NL + "  }" + NL + "" + NL + "  ionViewDidLoad() {" + NL + "  \tconsole.log('ionViewDidLoad ";
  protected final String TEXT_17 = "');" + NL + "  }" + NL + "  ";
  protected final String TEXT_18 = NL + "\tprotected lista";
  protected final String TEXT_19 = " : ";
  protected final String TEXT_20 = "[];" + NL + "\tprotected carrega";
  protected final String TEXT_21 = "(){" + NL + "\t\tthis.srv";
  protected final String TEXT_22 = ".find()" + NL + "      \t\t.subscribe((result:";
  protected final String TEXT_23 = "[]) => {" + NL + "        \t\tconsole.log('lista";
  protected final String TEXT_24 = ":' , result);" + NL + "        \t\tthis.lista";
  protected final String TEXT_25 = " = result;" + NL + "      \t})" + NL + "\t}" + NL + "\t" + NL + "\tprotected lista";
  protected final String TEXT_26 = "Usuario : ";
  protected final String TEXT_27 = "[];" + NL + "\tprotected carrega";
  protected final String TEXT_28 = "Usuario(idUsuario:number){" + NL + "\t\tthis.srv";
  protected final String TEXT_29 = ".find({'where' : {'idUsuario' : idUsuario} })" + NL + "      \t\t.subscribe((result:";
  protected final String TEXT_30 = "[]) => {" + NL + "        \t\tthis.lista";
  protected final String TEXT_31 = "Usuario = result;" + NL + "      \t})" + NL + "\t}" + NL;
  protected final String TEXT_32 = NL + "\tprotected submit() {" + NL + "    \tthis.srv.submit";
  protected final String TEXT_33 = "(this.item)" + NL + "      \t\t.subscribe((resultado) => {" + NL + "        \t\tconsole.log('Resultado-Submit";
  protected final String TEXT_34 = ": ' , resultado);" + NL + "\t\t\t\tthis.navCtrl.pop();" + NL + "      \t})" + NL + "\t}" + NL + "}";
  protected final String TEXT_35 = NL;

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
    
itRel =  classe.obtemListaSemChaveEstrangeira().iterator();
while (itRel.hasNext()) {
	RelacionamentoWrapper relac = itRel.next();
	ClasseWrapper oposta = relac.getClasseOposta();

    stringBuffer.append(TEXT_12);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_13);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_14);
    
}

    stringBuffer.append(TEXT_15);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_17);
    
itRel =  classe.obtemListaSemChaveEstrangeira().iterator();
while (itRel.hasNext()) {
	RelacionamentoWrapper relac = itRel.next();
	ClasseWrapper oposta = relac.getClasseOposta();

    stringBuffer.append(TEXT_18);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_20);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_21);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_22);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_24);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_25);
    stringBuffer.append( oposta.getNomeParaClasse() );
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
    
}

    stringBuffer.append(TEXT_32);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_33);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(TEXT_35);
    return stringBuffer.toString();
  }
}
