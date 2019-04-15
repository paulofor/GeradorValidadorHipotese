package jet.ionic3.page.listaItem;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.base.node.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;
import gerapp.modelo.node.*;

public class ListaItemPageProdBaseTs
{
  protected static String nl;
  public static synchronized ListaItemPageProdBaseTs create(String lineSeparator)
  {
    nl = lineSeparator;
    ListaItemPageProdBaseTs result = new ListaItemPageProdBaseTs();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "import { ";
  protected final String TEXT_3 = ", ";
  protected final String TEXT_4 = "Api } from '../../shared/sdk';" + NL + "import { LoopBackFilter } from '../../shared/sdk';" + NL + "import { NavController } from 'ionic-angular';" + NL + "import { Page } from 'ionic-angular/umd/navigation/nav-util';" + NL + "" + NL + "export abstract class ";
  protected final String TEXT_5 = "Base {" + NL + "" + NL + "\tprotected listaItem: ";
  protected final String TEXT_6 = "[];" + NL + "\t//protected abstract inicializacao();" + NL + "\tprotected abstract getFiltro(): LoopBackFilter;" + NL + "\tprotected abstract getPageEdicao(): Page;" + NL + "" + NL + "\tconstructor(public navCtrl: NavController, protected srv: ";
  protected final String TEXT_7 = "Api) {" + NL + "\t}" + NL + "" + NL + "\tionViewWillEnter() {" + NL + "    \tconsole.log('ionViewWillEnter ";
  protected final String TEXT_8 = "');" + NL + "    \t//this.inicializacao();" + NL + "    \tthis.carregaLista();" + NL + "  \t}" + NL + "  \t" + NL + "  \tcarregaLista() {" + NL + "  \t\tthis.srv.find(this.getFiltro())" + NL + "  \t\t\t.subscribe((resultado: ";
  protected final String TEXT_9 = "[]) => {" + NL + "  \t\t\t\tconsole.log('ListaItem:' , resultado);" + NL + "  \t\t\t\tthis.listaItem = resultado;" + NL + "  \t\t\t})" + NL + "  \t}" + NL + "  " + NL + "\tprotected alterar(item: ";
  protected final String TEXT_10 = ") {" + NL + "\t\tthis.navCtrl.push(this.getPageEdicao(), {" + NL + "      \t\titem: item" + NL + "\t\t});" + NL + "  \t}" + NL + "  \t" + NL + "  \tprotected novo() {" + NL + "\t\tthis.navCtrl.push(this.getPageEdicao());" + NL + "\t}" + NL + "}";
  protected final String TEXT_11 = NL;

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
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}
