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
  protected final String TEXT_2 = NL + "import { Component } from '@angular/core';" + NL + "import { IonicPage, NavController } from 'ionic-angular';" + NL + "import { Page } from 'ionic-angular/navigation/nav-util';" + NL + "import { ";
  protected final String TEXT_3 = "Base } from './";
  protected final String TEXT_4 = "-base';" + NL + "import { ";
  protected final String TEXT_5 = "Api, LoopBackFilter } from '../../shared/sdk';" + NL + "" + NL + "" + NL + "@IonicPage()" + NL + "@Component({" + NL + "  selector: '";
  protected final String TEXT_6 = "'," + NL + "  templateUrl: '";
  protected final String TEXT_7 = ".html'" + NL + "})" + NL + "export class ";
  protected final String TEXT_8 = " extends ";
  protected final String TEXT_9 = "Base {" + NL + "" + NL + "  constructor(public navCtrl: NavController, protected srv: ";
  protected final String TEXT_10 = "Api) {" + NL + "    super(navCtrl, srv);" + NL + "  }" + NL + "" + NL + "" + NL + "  protected getPageEdicao(): Page {" + NL + "    throw new Error(\"";
  protected final String TEXT_11 = ".getPageEdicao() nao implementado.\");" + NL + "  }" + NL + "" + NL + "  protected getFiltro(): LoopBackFilter {" + NL + "    return {};" + NL + "  }" + NL + "  " + NL + "}";
  protected final String TEXT_12 = NL;

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
    stringBuffer.append( tela.getNomeControle() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( tela.getArquivo() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}
