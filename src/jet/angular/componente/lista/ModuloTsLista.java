package jet.angular.componente.lista;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;

public class ModuloTsLista
{
  protected static String nl;
  public static synchronized ModuloTsLista create(String lineSeparator)
  {
    nl = lineSeparator;
    ModuloTsLista result = new ModuloTsLista();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "import { NgModule } from '@angular/core';" + NL + "import { CommonModule } from '@angular/common';";
  protected final String TEXT_3 = "  " + NL + "import { ";
  protected final String TEXT_4 = " } from './";
  protected final String TEXT_5 = "/";
  protected final String TEXT_6 = "';";
  protected final String TEXT_7 = NL + NL + NL + "@NgModule({" + NL + "  imports: [" + NL + "    CommonModule" + NL + "  ]," + NL + "  declarations: [";
  protected final String TEXT_8 = "  ";
  protected final String TEXT_9 = NL + "    ";
  protected final String TEXT_10 = ",";
  protected final String TEXT_11 = NL + "  ]," + NL + "  exports: [";
  protected final String TEXT_12 = "  ";
  protected final String TEXT_13 = NL + "    ";
  protected final String TEXT_14 = ",";
  protected final String TEXT_15 = NL + "  ]" + NL + "})" + NL + "export class ";
  protected final String TEXT_16 = " { }";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
ModuloComponente modulo =  (ModuloComponente) recursos.getComponente();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_2);
     
Iterator it = modulo.getListaComponente().iterator();
while (it.hasNext()) {
	ComponenteTela comp = (ComponenteTela) it.next(); 

    stringBuffer.append(TEXT_3);
    stringBuffer.append( comp.getNome() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( comp.getArquivo() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( comp.getArquivo() );
    stringBuffer.append(TEXT_6);
    
}

    stringBuffer.append(TEXT_7);
     
it = modulo.getListaComponente().iterator();
while (it.hasNext()) {
	ComponenteTela comp = (ComponenteTela) it.next(); 

    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    stringBuffer.append( comp.getNome() );
    stringBuffer.append(TEXT_10);
    
}

    stringBuffer.append(TEXT_11);
     
it = modulo.getListaComponente().iterator();
while (it.hasNext()) {
	ComponenteTela comp = (ComponenteTela) it.next(); 

    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    stringBuffer.append( comp.getNome() );
    stringBuffer.append(TEXT_14);
    
}

    stringBuffer.append(TEXT_15);
    stringBuffer.append( modulo.getNome() );
    stringBuffer.append(TEXT_16);
    return stringBuffer.toString();
  }
}
