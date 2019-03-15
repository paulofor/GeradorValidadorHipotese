package jet.ionic3.page;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.base.node.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;
import gerapp.modelo.node.*;

public class PageModuleTs
{
  protected static String nl;
  public static synchronized PageModuleTs create(String lineSeparator)
  {
    nl = lineSeparator;
    PageModuleTs result = new PageModuleTs();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "import { NgModule } from '@angular/core';" + NL + "import { TranslateModule } from '@ngx-translate/core';" + NL + "import { IonicPageModule } from 'ionic-angular';" + NL + "" + NL + "import { ";
  protected final String TEXT_3 = " } from './";
  protected final String TEXT_4 = "';" + NL + "" + NL + "@NgModule({" + NL + "  declarations: [";
  protected final String TEXT_5 = NL + "    ";
  protected final String TEXT_6 = "," + NL + "  ]," + NL + "  imports: [" + NL + "    IonicPageModule.forChild(";
  protected final String TEXT_7 = ")," + NL + "    TranslateModule.forChild()" + NL + "  ]," + NL + "  exports: [";
  protected final String TEXT_8 = NL + "    ";
  protected final String TEXT_9 = NL + "  ]" + NL + "})" + NL + "export class ";
  protected final String TEXT_10 = "Module { }";
  protected final String TEXT_11 = NL;

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
    stringBuffer.append( tela.getPathArquivo() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}
