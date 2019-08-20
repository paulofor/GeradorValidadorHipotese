package jet.server.model;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;
import gerapp.modelo.node.*;
import jet.wrappers.base.node.*;

public class ModelJson
{
  protected static String nl;
  public static synchronized ModelJson create(String lineSeparator)
  {
    nl = lineSeparator;
    ModelJson result = new ModelJson();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "{" + NL + "  \"name\": \"";
  protected final String TEXT_3 = "\"," + NL + "  \"plural\": \"";
  protected final String TEXT_4 = "s\"," + NL + "  \"base\": \"PersistedModel\"," + NL + "  \"idInjection\": true," + NL + "  \"options\": {" + NL + "    \"validateUpsert\": true" + NL + "  }," + NL + "  \"properties\": {";
  protected final String TEXT_5 = ",";
  protected final String TEXT_6 = " " + NL + "\t\"";
  protected final String TEXT_7 = "\": {" + NL + "\t";
  protected final String TEXT_8 = NL + "      \"type\": \"";
  protected final String TEXT_9 = "\"";
  protected final String TEXT_10 = NL + "      \"id\": true," + NL + "      \"type\": \"string\"," + NL + "      \"defaultFn\": \"uuid\"";
  protected final String TEXT_11 = NL + "    }";
  protected final String TEXT_12 = NL + "  }," + NL + "  \"validations\": []," + NL + "  \"relations\": {";
  protected final String TEXT_13 = ",";
  protected final String TEXT_14 = " " + NL + "\t\"";
  protected final String TEXT_15 = "\": {" + NL + "      \"type\": \"belongsTo\"," + NL + "      \"model\": \"";
  protected final String TEXT_16 = "\"," + NL + "      \"foreignKey\": \"";
  protected final String TEXT_17 = "Id\"" + NL + "    }";
  protected final String TEXT_18 = "  ";
  protected final String TEXT_19 = ",";
  protected final String TEXT_20 = " " + NL + "\t\"lista";
  protected final String TEXT_21 = "\": {" + NL + "      \"type\": \"hasMany\"," + NL + "      \"model\": \"";
  protected final String TEXT_22 = "\"," + NL + "      \"foreignKey\": \"";
  protected final String TEXT_23 = "Id\"" + NL + "    }";
  protected final String TEXT_24 = NL + "  }," + NL + "  \"mixins\": {" + NL + "    \"Counts\": true" + NL + "  }," + NL + "  \"acls\": []," + NL + "  \"methods\": {";
  protected final String TEXT_25 = ",";
  protected final String TEXT_26 = " " + NL + "      \"Submit";
  protected final String TEXT_27 = "\": {" + NL + "      \"accepts\": [" + NL + "        {" + NL + "          \"arg\": \"item\"," + NL + "          \"type\": \"object\"," + NL + "          \"required\": true," + NL + "          \"description\": \"\"" + NL + "        }" + NL + "      ]," + NL + "      \"returns\": [" + NL + "        {" + NL + "          \"arg\": \"resultado\"," + NL + "          \"type\": \"object\"," + NL + "          \"root\": true," + NL + "          \"description\": \"\"" + NL + "        }" + NL + "      ]," + NL + "      \"description\": \"submit da tela ";
  protected final String TEXT_28 = "\"," + NL + "      \"http\": [" + NL + "        {" + NL + "          \"path\": \"/submit";
  protected final String TEXT_29 = "\"," + NL + "          \"verb\": \"post\"" + NL + "        }" + NL + "      ]" + NL + "    }";
  protected final String TEXT_30 = ",";
  protected final String TEXT_31 = " " + NL + "      \"Submit";
  protected final String TEXT_32 = "\": {" + NL + "      \"accepts\": [" + NL + "        {" + NL + "          \"arg\": \"item\"," + NL + "          \"type\": \"object\"," + NL + "          \"required\": true," + NL + "          \"description\": \"\"" + NL + "        }" + NL + "      ]," + NL + "      \"returns\": [" + NL + "        {" + NL + "          \"arg\": \"resultado\"," + NL + "          \"type\": \"object\"," + NL + "          \"root\": true," + NL + "          \"description\": \"\"" + NL + "        }" + NL + "      ]," + NL + "      \"description\": \"submit da tela ";
  protected final String TEXT_33 = "\"," + NL + "      \"http\": [" + NL + "        {" + NL + "          \"path\": \"/submit";
  protected final String TEXT_34 = "\"," + NL + "          \"verb\": \"post\"" + NL + "        }" + NL + "      ]" + NL + "    }";
  protected final String TEXT_35 = NL + "  }" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
Configuracao conf = recursos.getConfiguracao();
ClasseWrapperAngular classe = (ClasseWrapperAngular) recursos.getClasse();

    stringBuffer.append(TEXT_2);
    stringBuffer.append( classe.getNomeModeloServer() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( classe.getNomeModeloServer() );
    stringBuffer.append(TEXT_4);
    
boolean primeiro = true;
Iterator<AtributoWrapper> iteradorAtt = classe.getIteratorAtributo();
while (iteradorAtt.hasNext()) {
	AtributoWrapper atributo = (AtributoWrapper) iteradorAtt.next();
	if (primeiro) { primeiro = false; } else {
    stringBuffer.append(TEXT_5);
     } 
    stringBuffer.append(TEXT_6);
    stringBuffer.append( atributo.getNomeVariavel() );
    stringBuffer.append(TEXT_7);
     if (!atributo.ehChave()) { 
    stringBuffer.append(TEXT_8);
    stringBuffer.append( atributo.getTipoNode() );
    stringBuffer.append(TEXT_9);
     } else { 
    stringBuffer.append(TEXT_10);
     } 
    stringBuffer.append(TEXT_11);
    
}

    stringBuffer.append(TEXT_12);
    
primeiro = true;
Iterator<RelacionamentoWrapper> itRel =  classe.obtemListaSemChaveEstrangeira().iterator();
while (itRel.hasNext()) {
	RelacionamentoWrapper relac = itRel.next();
	ClasseWrapperAngular oposta = (ClasseWrapperAngular) relac.getClasseOposta();
	if (primeiro) { primeiro = false; } else {
    stringBuffer.append(TEXT_13);
     } 
    stringBuffer.append(TEXT_14);
    stringBuffer.append( oposta.getNomeParaVariavel() );
    stringBuffer.append(TEXT_15);
    stringBuffer.append( oposta.getNomeModeloServer() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append( oposta.getNomeParaVariavel() );
    stringBuffer.append(TEXT_17);
    
}

    stringBuffer.append(TEXT_18);
    
itRel =  classe.obtemListaComChaveEstrangeira().iterator();
while (itRel.hasNext()) {
	RelacionamentoWrapper relac = itRel.next();
	ClasseWrapperAngular oposta = (ClasseWrapperAngular) relac.getClasseOposta();
	if (primeiro) { primeiro = false; } else {
    stringBuffer.append(TEXT_19);
     } 
    stringBuffer.append(TEXT_20);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_21);
    stringBuffer.append( oposta.getNomeModeloServer() );
    stringBuffer.append(TEXT_22);
    stringBuffer.append( classe.getNomeParaVariavel() );
    stringBuffer.append(TEXT_23);
    
}

    stringBuffer.append(TEXT_24);
    
primeiro = true;
Iterator<TelaAppWrapper> itEdita = classe.getListaTelaPorTipo("EDITA").iterator();
while (itEdita.hasNext()) {
	TelaAppWrapper tela = itEdita.next();
	if (primeiro) { primeiro = false; } else {
    stringBuffer.append(TEXT_25);
     } 
    stringBuffer.append(TEXT_26);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_27);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_28);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_29);
    
}
Iterator<TelaAppWrapper> itGetPut = classe.getListaTelaPutPorTipo("GETPUT").iterator();
while (itGetPut.hasNext()) {
	TelaAppWrapper tela = itGetPut.next();
	if (primeiro) { primeiro = false; } else {
    stringBuffer.append(TEXT_30);
     } 
    stringBuffer.append(TEXT_31);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_32);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_33);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_34);
    
}

    stringBuffer.append(TEXT_35);
    return stringBuffer.toString();
  }
}
