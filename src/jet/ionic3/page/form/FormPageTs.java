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
  protected final String TEXT_1 = "import { Component } from '@angular/core';" + NL + "import { IonicPage, ModalController, NavController } from 'ionic-angular';" + NL + "import { Screenshot } from '@ionic-native/screenshot';" + NL + "" + NL + "import { ";
  protected final String TEXT_2 = ", ";
  protected final String TEXT_3 = "Api } from '../../shared/sdk';" + NL + "" + NL + "@IonicPage()" + NL + "@Component({" + NL + "  selector: '";
  protected final String TEXT_4 = "'," + NL + "  templateUrl: '";
  protected final String TEXT_5 = ".html'" + NL + "})" + NL + "export class ";
  protected final String TEXT_6 = " extends ";
  protected final String TEXT_7 = "Base {" + NL + "  item: ";
  protected final String TEXT_8 = ";" + NL + "" + NL + "  constructor(public navCtrl: NavController, public srv: ";
  protected final String TEXT_9 = "Api, " + NL + "  \t\t\t\tprivate screenshot: Screenshot, public modalCtrl: ModalController) {" + NL + "  }" + NL + "" + NL + " " + NL + "  " + NL + " " + NL + "  " + NL + "}";
  protected final String TEXT_10 = NL;

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
    stringBuffer.append( tela.getNomeControle() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( tela.getArquivo() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}
