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
  protected final String TEXT_3 = "Api , LoopBackFilter } from '../../shared/sdk';" + NL + "import { NavParams, NavController } from 'ionic-angular';" + NL + "" + NL + "" + NL + "export abstract class ";
  protected final String TEXT_4 = "Base {" + NL + "  " + NL + "  protected item: ";
  protected final String TEXT_5 = ";" + NL + "  " + NL + "  " + NL + "  protected abstract filtroLoadId() : LoopBackFilter;" + NL + " " + NL + " " + NL + "  constructor(\tpublic navParams: NavParams," + NL + "  \t\t\t\tpublic navCtrl: NavController," + NL + "\t\t\t\tpublic srv: ";
  protected final String TEXT_6 = "Api) {" + NL + "  } " + NL + "  " + NL + "  private inicializaItem() {" + NL + "\tthis.item = this.navParams.get('item');" + NL + "\tconsole.log('";
  protected final String TEXT_7 = "Base:ItemParametro: ', this.item);" + NL + "\tif (!this.item) {" + NL + "\t\tvar id = this.navParams.get('id');" + NL + "\t\tif (id) {" + NL + "\t\t\tconsole.log('";
  protected final String TEXT_8 = "Base:Id: ' , id);" + NL + "\t\t\tconsole.log('";
  protected final String TEXT_9 = "Base:filtro: ' , JSON.stringify(this.filtroLoadId()));" + NL + "\t\t\tconsole.log('";
  protected final String TEXT_10 = ".findById');" + NL + "\t\t\tthis.srv.findById(id, this.filtroLoadId())" + NL + "\t\t\t\t\t.subscribe(" + NL + "\t\t\t\t\t\t(result: ";
  protected final String TEXT_11 = ") => {" + NL + "\t\t\t\t\t\t\tthis.item = result;" + NL + "\t\t\t\t\t\t\tconsole.log('";
  protected final String TEXT_12 = "Base.item: ' , JSON.stringify(this.item))" + NL + "\t\t\t\t\t\t}," + NL + "\t\t\t\t\t\t(erro: any) => console.log('";
  protected final String TEXT_13 = "Base:LoadId(Erro): ' , JSON.stringify(erro))" + NL + "\t\t\t\t\t)" + NL + "\t\t\t}" + NL + "\t\t} " + NL + "  }" + NL + "" + NL + "  " + NL + "  ionViewWillEnter() {" + NL + "    console.log('ionViewWillEnter ";
  protected final String TEXT_14 = "');" + NL + "    this.inicializaItem();" + NL + "  }" + NL + "  ionViewDidLoad() {" + NL + "  \tconsole.log('ionViewDidLoad ";
  protected final String TEXT_15 = "');" + NL + "  }" + NL + "}" + NL + "    ";
  protected final String TEXT_16 = NL + "    ";

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
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_11);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_13);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_14);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(TEXT_16);
    return stringBuffer.toString();
  }
}
