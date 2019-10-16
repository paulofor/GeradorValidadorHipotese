package jet.angular.loopback;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;

public class SDKModel
{
  protected static String nl;
  public static synchronized SDKModel create(String lineSeparator)
  {
    nl = lineSeparator;
    SDKModel result = new SDKModel();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "import { Injectable } from '@angular/core';" + NL + "import { Container } from '../../models/Container';" + NL + "import { User } from '../../models/User';" + NL + "import { Visitante } from '../../models/Visitante';" + NL + "import { DispositivoUsuario } from '../../models/DispositivoUsuario';";
  protected final String TEXT_3 = NL + "import { ";
  protected final String TEXT_4 = " } from '../../models/";
  protected final String TEXT_5 = "';";
  protected final String TEXT_6 = NL + "export interface Models { [name: string]: any }" + NL + "" + NL + "@Injectable()" + NL + "export class SDKModels {" + NL + "" + NL + "  private models: Models = {";
  protected final String TEXT_7 = NL + "\t";
  protected final String TEXT_8 = ": ";
  protected final String TEXT_9 = ",";
  protected final String TEXT_10 = NL + "\tUser: User," + NL + "    Container: Container," + NL + "    Visitante : Visitante," + NL + "    DispositivoUsuario : DispositivoUsuario" + NL + "  };" + NL + "" + NL + "  public get(modelName: string): any {" + NL + "    return this.models[modelName];" + NL + "  }" + NL + "" + NL + "  public getAll(): Models {" + NL + "    return this.models;" + NL + "  }" + NL + "" + NL + "  public getModelNames(): string[] {" + NL + "    return Object.keys(this.models);" + NL + "  }" + NL + "}";
  protected final String TEXT_11 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
List<ClasseWrapper> classes = recursos.getListaClasse();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_2);
    
Iterator<ClasseWrapper> iterador = classes.iterator();
while (iterador.hasNext()) {
	ClasseWrapper classe = iterador.next();

    stringBuffer.append(TEXT_3);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_5);
    
}

    stringBuffer.append(TEXT_6);
    
iterador = classes.iterator();
while (iterador.hasNext()) {
	ClasseWrapper classe = iterador.next();

    stringBuffer.append(TEXT_7);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_9);
    
}

    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}
