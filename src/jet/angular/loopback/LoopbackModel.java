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
  protected final String TEXT_3 = NL + "\t";
  protected final String TEXT_4 = ",";
  protected final String TEXT_5 = NL + "\t";
  protected final String TEXT_6 = ",";
  protected final String TEXT_7 = NL + "} from '../index';" + NL + "" + NL + "declare var Object: any;" + NL + "export interface ";
  protected final String TEXT_8 = "Interface {";
  protected final String TEXT_9 = NL + "\t\"";
  protected final String TEXT_10 = "\"";
  protected final String TEXT_11 = ": ";
  protected final String TEXT_12 = ";";
  protected final String TEXT_13 = NL + "\t";
  protected final String TEXT_14 = "?: ";
  protected final String TEXT_15 = ";" + NL + "\t";
  protected final String TEXT_16 = "Id? : number;";
  protected final String TEXT_17 = NL + "\tlista";
  protected final String TEXT_18 = "?: ";
  protected final String TEXT_19 = "[];";
  protected final String TEXT_20 = NL + "}" + NL + "" + NL + "export class ";
  protected final String TEXT_21 = " implements ";
  protected final String TEXT_22 = "Interface {";
  protected final String TEXT_23 = NL + "\t";
  protected final String TEXT_24 = ": ";
  protected final String TEXT_25 = ";";
  protected final String TEXT_26 = NL + "\t";
  protected final String TEXT_27 = "?: ";
  protected final String TEXT_28 = ";" + NL + "\t";
  protected final String TEXT_29 = "Id? : number;";
  protected final String TEXT_30 = NL + "\tlista";
  protected final String TEXT_31 = "?: ";
  protected final String TEXT_32 = "[];";
  protected final String TEXT_33 = NL + "  constructor(data?: ";
  protected final String TEXT_34 = "Interface) {" + NL + "    Object.assign(this, data);" + NL + "  }" + NL + "  /**" + NL + "   * The name of the model represented by this $resource," + NL + "   * i.e. `GanhoDorCanvasMySql`." + NL + "   */" + NL + "  public static getModelName() {" + NL + "    return \"";
  protected final String TEXT_35 = "\";" + NL + "  }" + NL + "  /**" + NL + "  * @method factory" + NL + "  * @author Gerador Java " + NL + "  * @license MIT" + NL + "  * This method creates an instance of ";
  protected final String TEXT_36 = " for dynamic purposes." + NL + "  **/" + NL + "  public static factory(data: ";
  protected final String TEXT_37 = "Interface): ";
  protected final String TEXT_38 = "{" + NL + "    return new ";
  protected final String TEXT_39 = "(data);" + NL + "  }" + NL + "  /**" + NL + "  * @method getModelDefinition" + NL + "  * @author Gerador Java" + NL + "  * @license MIT" + NL + "  * This method returns an object that represents some of the model" + NL + "  * definitions." + NL + "  **/" + NL + "  public static getModelDefinition() {" + NL + "    return {" + NL + "      name: '";
  protected final String TEXT_40 = "'," + NL + "      plural: '";
  protected final String TEXT_41 = "s'," + NL + "      path: '";
  protected final String TEXT_42 = "s'," + NL + "      idName: 'id'," + NL + "      properties: {" + NL + "\t\t";
  protected final String TEXT_43 = NL + "        \"";
  protected final String TEXT_44 = "\" : {" + NL + "        \tname : \"";
  protected final String TEXT_45 = "\"," + NL + "        \ttype : \"";
  protected final String TEXT_46 = "\"" + NL + "        },";
  protected final String TEXT_47 = NL + "      }," + NL + "      relations: {" + NL + "      }" + NL + "    }" + NL + "  }" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
ClasseWrapperAngular classe = (ClasseWrapperAngular) recursos.getClasse();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_2);
    
	Iterator<RelacionamentoWrapper> iteradorRel = classe.obtemListaComChaveEstrangeira().iterator();
	while (iteradorRel.hasNext()) {
		RelacionamentoWrapper rel = iteradorRel.next();

    stringBuffer.append(TEXT_3);
    stringBuffer.append( rel.getTipoAngular() );
    stringBuffer.append(TEXT_4);
    
}

    
	iteradorRel = classe.obtemListaSemChaveEstrangeira().iterator();
	while (iteradorRel.hasNext()) {
		RelacionamentoWrapper rel = iteradorRel.next();

    stringBuffer.append(TEXT_5);
    stringBuffer.append( rel.getTipoAngular() );
    stringBuffer.append(TEXT_6);
    
}

    stringBuffer.append(TEXT_7);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_8);
    
	Iterator<AtributoWrapper> iterador = classe.getListaAtributoEntidadeW().iterator();
	while (iterador.hasNext()) {
		AtributoWrapper atributo = iterador.next();

    stringBuffer.append(TEXT_9);
    stringBuffer.append( atributo.getNomeVariavel() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( (atributo.ehObrigatorio()?"":"?") );
    stringBuffer.append(TEXT_11);
    stringBuffer.append( atributo.getTipo() );
    stringBuffer.append(TEXT_12);
    
	}

    
	iteradorRel = classe.getListaItem1().iterator();
	while (iteradorRel.hasNext()) {
		RelacionamentoWrapper rel = iteradorRel.next();
		ClasseWrapperAngular oposta = (ClasseWrapperAngular) rel.getClasseOposta();

    stringBuffer.append(TEXT_13);
    stringBuffer.append( rel.getVariavelAngular() );
    stringBuffer.append(TEXT_14);
    stringBuffer.append( rel.getTipoAngular() );
    stringBuffer.append(TEXT_15);
    stringBuffer.append( rel.getVariavelAngular() );
    stringBuffer.append(TEXT_16);
    
	}

    
	iteradorRel = classe.getListaItemN().iterator();
	while (iteradorRel.hasNext()) {
		RelacionamentoWrapper rel = iteradorRel.next();

    stringBuffer.append(TEXT_17);
    stringBuffer.append( rel.getTipoAngular() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( rel.getTipoAngular() );
    stringBuffer.append(TEXT_19);
    
	}

    stringBuffer.append(TEXT_20);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_21);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_22);
    
	iterador = classe.getListaAtributoEntidadeW().iterator();
	while (iterador.hasNext()) {
		AtributoWrapper atributo = iterador.next();

    stringBuffer.append(TEXT_23);
    stringBuffer.append( atributo.getNomeVariavel() );
    stringBuffer.append( (atributo.ehObrigatorio()?"":"?") );
    stringBuffer.append(TEXT_24);
    stringBuffer.append( atributo.getTipo() );
    stringBuffer.append(TEXT_25);
    
	}

    
	iteradorRel = classe.getListaItem1().iterator();
	while (iteradorRel.hasNext()) {
		RelacionamentoWrapper rel = iteradorRel.next();

    stringBuffer.append(TEXT_26);
    stringBuffer.append( rel.getVariavelAngular() );
    stringBuffer.append(TEXT_27);
    stringBuffer.append( rel.getTipoAngular() );
    stringBuffer.append(TEXT_28);
    stringBuffer.append( rel.getVariavelAngular() );
    stringBuffer.append(TEXT_29);
    
	}

    
	iteradorRel = classe.getListaItemN().iterator();
	while (iteradorRel.hasNext()) {
		RelacionamentoWrapper rel = iteradorRel.next();

    stringBuffer.append(TEXT_30);
    stringBuffer.append( rel.getTipoAngular() );
    stringBuffer.append(TEXT_31);
    stringBuffer.append( rel.getTipoAngular() );
    stringBuffer.append(TEXT_32);
    
	}

    stringBuffer.append(TEXT_33);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_35);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_36);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_38);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_39);
    stringBuffer.append( classe.getNomeModeloServer() );
    stringBuffer.append(TEXT_40);
    stringBuffer.append( classe.getNomeModeloServer() );
    stringBuffer.append(TEXT_41);
    stringBuffer.append( classe.getNomeModeloServer() );
    stringBuffer.append(TEXT_42);
    
		iterador = classe.getListaAtributoEntidadeW().iterator();
		while (iterador.hasNext()) {
			AtributoWrapper atributo = iterador.next();
		
    stringBuffer.append(TEXT_43);
    stringBuffer.append( atributo.getNomeVariavel() );
    stringBuffer.append(TEXT_44);
    stringBuffer.append( atributo.getNomeVariavel() );
    stringBuffer.append(TEXT_45);
    stringBuffer.append( atributo.getTipo() );
    stringBuffer.append(TEXT_46);
     } 
    stringBuffer.append(TEXT_47);
    return stringBuffer.toString();
  }
}
