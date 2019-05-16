package jet.ionic3.page.detalhe;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.base.node.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;
import gerapp.modelo.node.*;

public class DetalhePageProdBaseTs
{
  protected static String nl;
  public static synchronized DetalhePageProdBaseTs create(String lineSeparator)
  {
    nl = lineSeparator;
    DetalhePageProdBaseTs result = new DetalhePageProdBaseTs();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "import { ";
  protected final String TEXT_2 = ", ";
  protected final String TEXT_3 = "Api , LoopBackFilter, Usuario } from '../../shared/sdk';" + NL + "import { NavParams, NavController } from 'ionic-angular';" + NL + "import { Storage } from '@ionic/storage';" + NL + "" + NL + "// Tipo: ";
  protected final String TEXT_4 = NL + "export abstract class ";
  protected final String TEXT_5 = "Base {" + NL + "" + NL + "  protected usuario: Usuario;" + NL + "  " + NL + "  protected item: ";
  protected final String TEXT_6 = ";" + NL + "  " + NL + "  // filtro com parametro id" + NL + "  protected abstract filtroLoadId(id:any) : LoopBackFilter;" + NL + "  // filtro sem parametro id" + NL + "  protected abstract filtroLoadOne() : LoopBackFilter;" + NL + "  // chamada caso item nao tenha sido encontrado" + NL + "  //protected abstract itemNaoEncontrado();" + NL + "  " + NL + "  // chamada antes e depois da inicializacao" + NL + "  protected abstract posInicializaItem();" + NL + "  protected abstract preInicializaItem();" + NL + "  " + NL + " " + NL + "  constructor(\tpublic navParams: NavParams," + NL + "  \t\t\t\tpublic navCtrl: NavController," + NL + "\t\t\t\tpublic srv: ";
  protected final String TEXT_7 = "Api," + NL + "\t\t\t\tprotected storage: Storage) {" + NL + "  } " + NL + "  " + NL + "\tprivate inicializaItem() {" + NL + "\t\tthis.item = this.navParams.get('item');" + NL + "\t\tconsole.log('";
  protected final String TEXT_8 = "Base:ItemParametro: ', this.item);" + NL + "\t\tif (!this.item) {" + NL + "\t\t\tvar id = this.navParams.get('id');" + NL + "\t\t\tconsole.log('";
  protected final String TEXT_9 = "Base:Id: ' , id);" + NL + "\t\t\tif (id) {" + NL + "\t\t\t\tconsole.log('";
  protected final String TEXT_10 = "Base:filtro: ' , JSON.stringify(this.filtroLoadId(id)));" + NL + "\t\t\t\tconsole.log('";
  protected final String TEXT_11 = ".findById');" + NL + "\t\t\t\tthis.srv.findById(id, this.filtroLoadId(id))" + NL + "\t\t\t\t\t.subscribe(" + NL + "\t\t\t\t\t\t(result: ";
  protected final String TEXT_12 = ") => {" + NL + "\t\t\t\t\t\t\tthis.item = result;" + NL + "\t\t\t\t\t\t\tconsole.log('";
  protected final String TEXT_13 = "Base.item: ' , this.item)" + NL + "\t\t\t\t\t\t}," + NL + "\t\t\t\t\t\t(erro: any) => console.log('";
  protected final String TEXT_14 = "Base:LoadId(Erro): ' , JSON.stringify(erro))" + NL + "\t\t\t\t\t)" + NL + "\t\t\t} else  {" + NL + "\t\t\t\tconsole.log('";
  protected final String TEXT_15 = "Base:filtro: ' , JSON.stringify(this.filtroLoadOne()));" + NL + "\t\t\t\tconsole.log('";
  protected final String TEXT_16 = ".findOne');" + NL + "\t\t\t\t// se nao encontrar vai pro erro -> 404" + NL + "\t\t\t\tthis.srv.findOne(this.filtroLoadOne())" + NL + "\t\t\t\t\t.subscribe(" + NL + "\t\t\t\t\t\t(result: ";
  protected final String TEXT_17 = ") => {" + NL + "\t\t\t\t\t\t\tthis.item = result;" + NL + "\t\t\t\t\t\t\tconsole.log('";
  protected final String TEXT_18 = "Base.item: ' , this.item);" + NL + "\t\t\t\t\t\t\t//if (!this.item) this.itemNaoEncontrado();" + NL + "\t\t\t\t\t\t}," + NL + "\t\t\t\t\t\t(erro: any) => console.log('";
  protected final String TEXT_19 = "Base:LoadId(Erro): ' , JSON.stringify(erro))" + NL + "\t\t\t\t\t)" + NL + "\t\t\t}" + NL + "\t\t}  " + NL + "\t}" + NL + "\tcarregaUsuario() {" + NL + "\t\tthis.storage.get('user').then((val: Usuario) => {" + NL + "\t\t\tthis.usuario = val;" + NL + "\t\t\tthis.preInicializaItem();" + NL + "\t\t\tthis.inicializaItem();" + NL + "\t\t\tthis.posInicializaItem();" + NL + "\t\t})" + NL + "\t}" + NL + "  " + NL + "\tionViewWillEnter() {" + NL + "\t\tconsole.log('ionViewWillEnter ";
  protected final String TEXT_20 = "<<";
  protected final String TEXT_21 = ">>');" + NL + "\t\tthis.carregaUsuario();" + NL + "\t}" + NL + "  " + NL + "\tionViewDidLoad() {" + NL + "\t\tconsole.log('ionViewDidLoad ";
  protected final String TEXT_22 = "<<";
  protected final String TEXT_23 = ">>');" + NL + "\t}" + NL + "}" + NL + "    ";
  protected final String TEXT_24 = NL + "    ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
Recursos recursos = (Recursos) argument;  
TelaAppWrapper tela = (TelaAppWrapper) recursos.getItemCorrente();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_1);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( tela.getTipo() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_11);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_13);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_14);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_15);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_20);
    stringBuffer.append( tela.getTipo() );
    stringBuffer.append(TEXT_21);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_22);
    stringBuffer.append( tela.getTipo() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(TEXT_24);
    return stringBuffer.toString();
  }
}
