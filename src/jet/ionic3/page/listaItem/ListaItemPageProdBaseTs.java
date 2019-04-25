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
  protected final String TEXT_4 = "Api } from '../../shared/sdk';" + NL + "import { LoopBackFilter } from '../../shared/sdk';" + NL + "import { NavController } from 'ionic-angular';" + NL + "import { Page } from 'ionic-angular/umd/navigation/nav-util';";
  protected final String TEXT_5 = NL + "import { ";
  protected final String TEXT_6 = " } from '../";
  protected final String TEXT_7 = "/";
  protected final String TEXT_8 = "';";
  protected final String TEXT_9 = NL + NL + NL + "export abstract class ";
  protected final String TEXT_10 = "Base {" + NL + "" + NL + "\tprotected listaItem: ";
  protected final String TEXT_11 = "[];" + NL + "\tprotected abstract inicializacao();" + NL + "\tprotected abstract getFiltro(): LoopBackFilter;" + NL + "\t" + NL + "\t " + NL + "\tgetPageEdicao(): Page {" + NL + "\t\t";
  protected final String TEXT_12 = NL + "    \tthrow new Error(\"";
  protected final String TEXT_13 = " sem tela de edicao.\");" + NL + "    \t";
  protected final String TEXT_14 = NL + "    \treturn ";
  protected final String TEXT_15 = ";" + NL + "    \t";
  protected final String TEXT_16 = NL + "  \t}" + NL + "  \tgetPageDetalhe(): Page {" + NL + "\t\t";
  protected final String TEXT_17 = NL + "    \tthrow new Error(\"";
  protected final String TEXT_18 = " sem tela de detalhe.\");" + NL + "    \t";
  protected final String TEXT_19 = NL + "    \treturn ";
  protected final String TEXT_20 = ";" + NL + "    \t";
  protected final String TEXT_21 = NL + "  \t}" + NL + "" + NL + "\tconstructor(public navCtrl: NavController, protected srv: ";
  protected final String TEXT_22 = "Api) {" + NL + "\t}" + NL + "" + NL + "\tionViewWillEnter() {" + NL + "    \tconsole.log('ionViewWillEnter ";
  protected final String TEXT_23 = "<<";
  protected final String TEXT_24 = ">>');" + NL + "    \tthis.inicializacao();" + NL + "    \tthis.carregaLista();" + NL + "  \t}" + NL + "  \t" + NL + "  \tcarregaLista() {" + NL + "  \t\tconsole.log('";
  protected final String TEXT_25 = "Base:filtro: ' , JSON.stringify(this.getFiltro()));" + NL + "\t\tconsole.log('";
  protected final String TEXT_26 = ".find');" + NL + "  \t\tthis.srv.find(this.getFiltro())" + NL + "  \t\t\t.subscribe((resultado: ";
  protected final String TEXT_27 = "[]) => {" + NL + "  \t\t\t\tconsole.log('";
  protected final String TEXT_28 = "Base:LoadLista:' , resultado);" + NL + "  \t\t\t\tthis.listaItem = resultado;" + NL + "  \t\t\t})" + NL + "  \t}" + NL + "  " + NL + "\tprotected detalheId(item: ";
  protected final String TEXT_29 = ") {" + NL + "\t\tthis.navCtrl.push(this.getPageEdicao(), {" + NL + "      \t\tid: item.id" + NL + "\t\t});" + NL + "  \t}" + NL + "  \tprotected alterarId(item: ";
  protected final String TEXT_30 = ") {" + NL + "\t\tthis.navCtrl.push(this.getPageDetalhe(), {" + NL + "      \t\tid: item.id" + NL + "\t\t});" + NL + "  \t}" + NL + "  \tprotected novo() {" + NL + "\t\tthis.navCtrl.push(this.getPageEdicao());" + NL + "\t}" + NL + "}";
  protected final String TEXT_31 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
TelaAppWrapper tela = (TelaAppWrapper) recursos.getItemCorrente();
Configuracao conf = recursos.getConfiguracao();
TelaAppWrapper telaEdicao = tela.getTelaEdicao();

    stringBuffer.append(TEXT_2);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_4);
     if (telaEdicao!=null) { 
    stringBuffer.append(TEXT_5);
    stringBuffer.append( telaEdicao.getNome() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( telaEdicao.getPathArquivo() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( telaEdicao.getArquivo() );
    stringBuffer.append(TEXT_8);
     } 
    stringBuffer.append(TEXT_9);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_11);
     if (telaEdicao==null) { 
    stringBuffer.append(TEXT_12);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_13);
     } else { 
    stringBuffer.append(TEXT_14);
    stringBuffer.append( telaEdicao.getNome() );
    stringBuffer.append(TEXT_15);
     } 
    stringBuffer.append(TEXT_16);
     if (telaEdicao==null) { 
    stringBuffer.append(TEXT_17);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_18);
     } else { 
    stringBuffer.append(TEXT_19);
    stringBuffer.append( telaEdicao.getNome() );
    stringBuffer.append(TEXT_20);
     } 
    stringBuffer.append(TEXT_21);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_22);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append( tela.getTipo() );
    stringBuffer.append(TEXT_24);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_25);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_26);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_27);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_28);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_29);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(TEXT_31);
    return stringBuffer.toString();
  }
}
