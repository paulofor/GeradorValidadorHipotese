package jet.ionic3.page.detalhe;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.base.node.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;
import gerapp.modelo.node.*;

public class DetalhePageTs
{
  protected static String nl;
  public static synchronized DetalhePageTs create(String lineSeparator)
  {
    nl = lineSeparator;
    DetalhePageTs result = new DetalhePageTs();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "import { Component } from '@angular/core';" + NL + "import {IonicPage, ModalController, NavController, NavParams } from 'ionic-angular';" + NL + "import { ";
  protected final String TEXT_2 = "Base } from './";
  protected final String TEXT_3 = "-base';" + NL + "import { ";
  protected final String TEXT_4 = "Api, LoopBackFilter } from '../../shared/sdk/index';" + NL + "" + NL + "" + NL + "@IonicPage()" + NL + "@Component({" + NL + "  selector: '";
  protected final String TEXT_5 = "'," + NL + "  templateUrl: '";
  protected final String TEXT_6 = ".html'" + NL + "})" + NL + "export class ";
  protected final String TEXT_7 = " extends ";
  protected final String TEXT_8 = "Base {" + NL + "" + NL + "  constructor(public navParams: NavParams," + NL + "    public navCtrl: NavController," + NL + "    public srv: ";
  protected final String TEXT_9 = "Api) {" + NL + "      super(navParams,navCtrl,srv);" + NL + "  }" + NL + "  " + NL + "  protected filtroLoadId(id: any): LoopBackFilter {" + NL + "    return {};" + NL + "  }" + NL + "  protected filtroLoadOne(): LoopBackFilter {" + NL + "    return {};" + NL + "  }" + NL + "  " + NL + "}";
  protected final String TEXT_10 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
Recursos recursos = (Recursos) argument;  
TelaAppWrapper tela = (TelaAppWrapper) recursos.getItemCorrente();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_1);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( tela.getArquivo() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( tela.getNomeControle() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( tela.getArquivo() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}
