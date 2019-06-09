package jet.angular.projeto;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.base.node.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;
import gerapp.modelo.node.*;

public class ModuloServicoTs
{
  protected static String nl;
  public static synchronized ModuloServicoTs create(String lineSeparator)
  {
    nl = lineSeparator;
    ModuloServicoTs result = new ModuloServicoTs();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "import { NgModule } from '@angular/core';" + NL + "import { CommonModule } from '@angular/common';" + NL + "import { SDKBrowserModule, SDKModels, LoopBackAuth, InternalStorage } from '../shared/sdk';" + NL + "import { HttpClientModule } from '@angular/common/http';" + NL + "import { SocketDriver } from '../shared/sdk/sockets/socket.driver';" + NL;
  protected final String TEXT_3 = NL + "import { ";
  protected final String TEXT_4 = "Api } from '../shared/sdk';";
  protected final String TEXT_5 = NL + NL + "// Nao tem PagSeguroApi pq parece nao ser usado em lugar nenhum." + NL + "" + NL + "@NgModule({" + NL + "\timports: [" + NL + "\t\tCommonModule," + NL + "\t\tHttpClientModule," + NL + "\t\tSDKBrowserModule.forRoot()," + NL + "\t]," + NL + "\tproviders: [" + NL + "\t\tSocketDriver," + NL + "\t\tSDKModels," + NL + "\t\tLoopBackAuth," + NL + "\t\tInternalStorage,";
  protected final String TEXT_6 = NL + "\t\t";
  protected final String TEXT_7 = "Api,";
  protected final String TEXT_8 = NL + "\t]," + NL + "\tdeclarations: " + NL + "\t[" + NL + "\t]" + NL + "})" + NL + "export class ServicoModule { }";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
List<ClasseWrapper> classes = recursos.getListaClasse();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_2);
    
Iterator iterador = classes.iterator();
while (iterador.hasNext()) {
	ClasseWrapper classe = (ClasseWrapper) iterador.next();

    stringBuffer.append(TEXT_3);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_4);
    
}

    stringBuffer.append(TEXT_5);
    
iterador = classes.iterator();
while (iterador.hasNext()) {
	ClasseWrapper classe = (ClasseWrapper) iterador.next();

    stringBuffer.append(TEXT_6);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_7);
    
}

    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}
