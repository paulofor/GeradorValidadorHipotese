package jet.server.database;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;
import gerapp.modelo.node.*;

public class MySqlCreate
{
  protected static String nl;
  public static synchronized MySqlCreate create(String lineSeparator)
  {
    nl = lineSeparator;
    MySqlCreate result = new MySqlCreate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "drop table if exists ";
  protected final String TEXT_3 = ";" + NL + "create table ";
  protected final String TEXT_4 = " (";
  protected final String TEXT_5 = " " + NL + "\t";
  protected final String TEXT_6 = "  ";
  protected final String TEXT_7 = " ";
  protected final String TEXT_8 = "AUTO_INCREMENT";
  protected final String TEXT_9 = ",";
  protected final String TEXT_10 = NL;
  protected final String TEXT_11 = " " + NL + "\t";
  protected final String TEXT_12 = "Id BIGINT,";
  protected final String TEXT_13 = "  " + NL + "" + NL + "\tPRIMARY KEY (";
  protected final String TEXT_14 = ")" + NL + "); ";
  protected final String TEXT_15 = NL;
  protected final String TEXT_16 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
Configuracao conf = recursos.getConfiguracao();
List<ClasseWrapper> listaClasse = recursos.getListaClasse();

    
Iterator<ClasseWrapper> iterador = listaClasse.iterator();
while (iterador.hasNext()) {
	ClasseWrapperAngular item = (ClasseWrapperAngular) iterador.next();

    stringBuffer.append(TEXT_2);
    stringBuffer.append( item.getNomeModeloServer() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( item.getNomeModeloServer() );
    stringBuffer.append(TEXT_4);
    
// Atributos
boolean primeiro = true;
Iterator<AtributoWrapper> iteradorAtt = item.getIteratorAtributo();
while (iteradorAtt.hasNext()) {
	AtributoWrapper atributo = (AtributoWrapper) iteradorAtt.next();

    stringBuffer.append(TEXT_5);
    stringBuffer.append( atributo.getNomeVariavel() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( atributo.getTipoSql() );
    stringBuffer.append(TEXT_7);
     if (atributo.ehChave()) {
    stringBuffer.append(TEXT_8);
     } 
    stringBuffer.append(TEXT_9);
    
}

    stringBuffer.append(TEXT_10);
    
// Chave estrangeira de relacionamentos

Iterator<RelacionamentoWrapper> itRel =  item.obtemListaSemChaveEstrangeira().iterator();
while (itRel.hasNext()) {
	RelacionamentoWrapper relac = itRel.next();
	ClasseWrapperAngular oposta = (ClasseWrapperAngular) relac.getClasseOposta();

    stringBuffer.append(TEXT_11);
    stringBuffer.append( oposta.getNomeParaVariavel() );
    stringBuffer.append(TEXT_12);
    
}

    stringBuffer.append(TEXT_13);
    stringBuffer.append( item.getChaveW().getNomePropriedade() );
    stringBuffer.append(TEXT_14);
    
}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(TEXT_16);
    return stringBuffer.toString();
  }
}
