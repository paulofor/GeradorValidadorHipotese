package jet.angular.loopback;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;

public class LoopbackModel
{
  protected static String nl;
  public static synchronized LoopbackModel create(String lineSeparator)
  {
    nl = lineSeparator;
    LoopbackModel result = new LoopbackModel();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/* tslint:disable */" + NL + "import {" + NL + " " + NL + "} from '../index';" + NL + "" + NL + "declare var Object: any;" + NL + "export interface ";
  protected final String TEXT_3 = "Interface {";
  protected final String TEXT_4 = NL + "  \"";
  protected final String TEXT_5 = "\": ";
  protected final String TEXT_6 = ";";
  protected final String TEXT_7 = NL + NL + "}" + NL + "" + NL + "export class ";
  protected final String TEXT_8 = " implements ";
  protected final String TEXT_9 = "Interface {";
  protected final String TEXT_10 = NL + "  \"";
  protected final String TEXT_11 = "\": ";
  protected final String TEXT_12 = ";";
  protected final String TEXT_13 = NL + "  constructor(data?: ";
  protected final String TEXT_14 = "Interface) {" + NL + "    Object.assign(this, data);" + NL + "  }" + NL + "  /**" + NL + "   * The name of the model represented by this $resource," + NL + "   * i.e. `GanhoDorCanvasMySql`." + NL + "   */" + NL + "  public static getModelName() {" + NL + "    return \"";
  protected final String TEXT_15 = "\";" + NL + "  }" + NL + "  /**" + NL + "  * @method factory" + NL + "  * @author Paulo " + NL + "  * @license MIT" + NL + "  * This method creates an instance of ";
  protected final String TEXT_16 = " for dynamic purposes." + NL + "  **/" + NL + "  public static factory(data: ";
  protected final String TEXT_17 = "Interface): ";
  protected final String TEXT_18 = "{" + NL + "    return new ";
  protected final String TEXT_19 = "(data);" + NL + "  }" + NL + "  /**" + NL + "  * @method getModelDefinition" + NL + "  * @author Paulo" + NL + "  * @license MIT" + NL + "  * This method returns an object that represents some of the model" + NL + "  * definitions." + NL + "  **/" + NL + "  public static getModelDefinition() {" + NL + "    return {" + NL + "      name: '";
  protected final String TEXT_20 = "'," + NL + "      plural: '";
  protected final String TEXT_21 = "s'," + NL + "      path: '";
  protected final String TEXT_22 = "s'," + NL + "      idName: 'id'," + NL + "      properties: {" + NL + "\t\t";
  protected final String TEXT_23 = NL + "        \"";
  protected final String TEXT_24 = "\" : {" + NL + "        \tname : \"";
  protected final String TEXT_25 = "\"," + NL + "        \ttype : \"";
  protected final String TEXT_26 = "\"" + NL + "        },";
  protected final String TEXT_27 = NL + "      }," + NL + "      relations: {" + NL + "      }" + NL + "    }" + NL + "  }" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
ClasseWrapperAngular classe = (ClasseWrapperAngular) recursos.getClasse();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_2);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_3);
    
	Iterator<AtributoTotalI> iterador = classe.getListaAtributoTotal().iterator();
	while (iterador.hasNext()) {
		AtributoTotalI atributo = iterador.next();

    stringBuffer.append(TEXT_4);
    stringBuffer.append( atributo.getNomeVariavel() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( atributo.getTipo() );
    stringBuffer.append(TEXT_6);
    
	}

    stringBuffer.append(TEXT_7);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_9);
    
	iterador = classe.getListaAtributoTotal().iterator();
	while (iterador.hasNext()) {
		AtributoTotalI atributo = iterador.next();

    stringBuffer.append(TEXT_10);
    stringBuffer.append( atributo.getNomeVariavel() );
    stringBuffer.append(TEXT_11);
    stringBuffer.append( atributo.getTipo() );
    stringBuffer.append(TEXT_12);
    
	}

    stringBuffer.append(TEXT_13);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_14);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_15);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_20);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_21);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_22);
    
		iterador = classe.getListaAtributoTotal().iterator();
		while (iterador.hasNext()) {
			AtributoTotalI atributo = iterador.next();
		
    stringBuffer.append(TEXT_23);
    stringBuffer.append( atributo.getNomeVariavel() );
    stringBuffer.append(TEXT_24);
    stringBuffer.append( atributo.getNomeVariavel() );
    stringBuffer.append(TEXT_25);
    stringBuffer.append( atributo.getTipo() );
    stringBuffer.append(TEXT_26);
     } 
    stringBuffer.append(TEXT_27);
    return stringBuffer.toString();
  }
}
