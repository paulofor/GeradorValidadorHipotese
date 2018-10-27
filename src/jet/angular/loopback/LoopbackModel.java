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
  protected final String TEXT_2 = NL + "/* tslint:disable */" + NL + "import {";
  protected final String TEXT_3 = NL + "  ";
  protected final String TEXT_4 = NL + "} from '../index';" + NL + "" + NL + "declare var Object: any;" + NL + "export interface ";
  protected final String TEXT_5 = "Interface {";
  protected final String TEXT_6 = NL + "  \"";
  protected final String TEXT_7 = "\": ";
  protected final String TEXT_8 = ";";
  protected final String TEXT_9 = NL + NL + "}" + NL + "" + NL + "export class ";
  protected final String TEXT_10 = " implements ";
  protected final String TEXT_11 = "Interface {";
  protected final String TEXT_12 = NL + "  \"";
  protected final String TEXT_13 = "\": ";
  protected final String TEXT_14 = ";";
  protected final String TEXT_15 = NL + "  constructor(data?: ";
  protected final String TEXT_16 = "Interface) {" + NL + "    Object.assign(this, data);" + NL + "  }" + NL + "  /**" + NL + "   * The name of the model represented by this $resource," + NL + "   * i.e. `GanhoDorCanvasMySql`." + NL + "   */" + NL + "  public static getModelName() {" + NL + "    return \"";
  protected final String TEXT_17 = "\";" + NL + "  }" + NL + "  /**" + NL + "  * @method factory" + NL + "  * @author Paulo " + NL + "  * @license MIT" + NL + "  * This method creates an instance of ";
  protected final String TEXT_18 = " for dynamic purposes." + NL + "  **/" + NL + "  public static factory(data: ";
  protected final String TEXT_19 = "Interface): ";
  protected final String TEXT_20 = "{" + NL + "    return new ";
  protected final String TEXT_21 = "(data);" + NL + "  }" + NL + "  /**" + NL + "  * @method getModelDefinition" + NL + "  * @author Paulo" + NL + "  * @license MIT" + NL + "  * This method returns an object that represents some of the model" + NL + "  * definitions." + NL + "  **/" + NL + "  public static getModelDefinition() {" + NL + "    return {" + NL + "      name: '";
  protected final String TEXT_22 = "'," + NL + "      plural: '";
  protected final String TEXT_23 = "s'," + NL + "      path: '";
  protected final String TEXT_24 = "s'," + NL + "      idName: 'id'," + NL + "      properties: {" + NL + "\t\t";
  protected final String TEXT_25 = NL + "        \"";
  protected final String TEXT_26 = "\" : {" + NL + "        \tname : \"";
  protected final String TEXT_27 = "\"," + NL + "        \ttype : \"";
  protected final String TEXT_28 = "\"" + NL + "        },";
  protected final String TEXT_29 = NL + "      }," + NL + "      relations: {" + NL + "      }" + NL + "    }" + NL + "  }" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
ClasseWrapperAngular classe = (ClasseWrapperAngular) recursos.getClasse();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_5);
    
	Iterator<AtributoTotalI> iterador = classe.getListaAtributoTotal().iterator();
	while (iterador.hasNext()) {
		AtributoTotalI atributo = iterador.next();

    stringBuffer.append(TEXT_6);
    stringBuffer.append( atributo.getNomeVariavel() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( atributo.getTipo() );
    stringBuffer.append(TEXT_8);
    
	}

    stringBuffer.append(TEXT_9);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_11);
    
	iterador = classe.getListaAtributoTotal().iterator();
	while (iterador.hasNext()) {
		AtributoTotalI atributo = iterador.next();

    stringBuffer.append(TEXT_12);
    stringBuffer.append( atributo.getNomeVariavel() );
    stringBuffer.append(TEXT_13);
    stringBuffer.append( atributo.getTipo() );
    stringBuffer.append(TEXT_14);
    
	}

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
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_24);
    
		iterador = classe.getListaAtributoTotal().iterator();
		while (iterador.hasNext()) {
			AtributoTotalI atributo = iterador.next();
		
    stringBuffer.append(TEXT_25);
    stringBuffer.append( atributo.getNomeVariavel() );
    stringBuffer.append(TEXT_26);
    stringBuffer.append( atributo.getNomeVariavel() );
    stringBuffer.append(TEXT_27);
    stringBuffer.append( atributo.getTipo() );
    stringBuffer.append(TEXT_28);
     } 
    stringBuffer.append(TEXT_29);
    return stringBuffer.toString();
  }
}
