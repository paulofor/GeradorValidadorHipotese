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
  protected final String TEXT_2 = NL + "repair table ";
  protected final String TEXT_3 = ";" + NL + "drop table if exists ";
  protected final String TEXT_4 = ";" + NL + "create table ";
  protected final String TEXT_5 = " (";
  protected final String TEXT_6 = " " + NL + "\t";
  protected final String TEXT_7 = "  ";
  protected final String TEXT_8 = " VARCHAR(50) ";
  protected final String TEXT_9 = " ";
  protected final String TEXT_10 = "  ";
  protected final String TEXT_11 = ",";
  protected final String TEXT_12 = NL;
  protected final String TEXT_13 = " " + NL + "\t";
  protected final String TEXT_14 = "Id VARCHAR(50)," + NL + "\t ";
  protected final String TEXT_15 = "  " + NL + "" + NL + "\tPRIMARY KEY (";
  protected final String TEXT_16 = ")" + NL + "\t" + NL + "\t" + NL + "\t" + NL + "); ";
  protected final String TEXT_17 = NL;
  protected final String TEXT_18 = NL + "alter table ";
  protected final String TEXT_19 = " " + NL + "ADD FOREIGN KEY (";
  protected final String TEXT_20 = "Id) REFERENCES ";
  protected final String TEXT_21 = "(";
  protected final String TEXT_22 = ") ON DELETE CASCADE,";
  protected final String TEXT_23 = " " + NL;
  protected final String TEXT_24 = NL + NL;
  protected final String TEXT_25 = NL;

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
    stringBuffer.append( item.getNomeModeloServer() );
    stringBuffer.append(TEXT_5);
    
// Atributos
boolean primeiro = true;
Iterator<AtributoWrapper> iteradorAtt = item.getIteratorAtributo();
while (iteradorAtt.hasNext()) {
	AtributoWrapper atributo = (AtributoWrapper) iteradorAtt.next();

    stringBuffer.append(TEXT_6);
    stringBuffer.append( atributo.getNomeVariavel() );
    stringBuffer.append(TEXT_7);
     if (atributo.ehChave()) {
    stringBuffer.append(TEXT_8);
     } else {
    stringBuffer.append(TEXT_9);
    stringBuffer.append( atributo.getTipoSql() );
    stringBuffer.append(TEXT_10);
     } 
    stringBuffer.append(TEXT_11);
    
}

    stringBuffer.append(TEXT_12);
    
// Chave estrangeira de relacionamentos

Iterator<RelacionamentoWrapper> itRel =  item.obtemListaSemChaveEstrangeira().iterator();
while (itRel.hasNext()) {
	RelacionamentoWrapper relac = itRel.next();
	ClasseWrapperAngular oposta = (ClasseWrapperAngular) relac.getClasseOposta();

    stringBuffer.append(TEXT_13);
    stringBuffer.append( oposta.getNomeParaVariavel() );
    stringBuffer.append(TEXT_14);
    
}

    stringBuffer.append(TEXT_15);
    stringBuffer.append( item.getChaveW().getNomeVariavel() );
    stringBuffer.append(TEXT_16);
    
}

    stringBuffer.append(TEXT_17);
    
// Alterando para colocar chave estrangeira
iterador = listaClasse.iterator();
while (iterador.hasNext()) {
	ClasseWrapperAngular item = (ClasseWrapperAngular) iterador.next();

    stringBuffer.append(TEXT_18);
    stringBuffer.append( item.getNomeModeloServer() );
    
Iterator<RelacionamentoWrapper> itRel =  item.obtemListaSemChaveEstrangeira().iterator();
while (itRel.hasNext()) {
	RelacionamentoWrapper relac = itRel.next();
	ClasseWrapperAngular oposta = (ClasseWrapperAngular) relac.getClasseOposta();

    stringBuffer.append(TEXT_19);
    stringBuffer.append( oposta.getNomeParaVariavel() );
    stringBuffer.append(TEXT_20);
    stringBuffer.append( oposta.getNomeModeloServer() );
    stringBuffer.append(TEXT_21);
    stringBuffer.append( oposta.getChaveW().getNomeVariavel());
    stringBuffer.append(TEXT_22);
    
}

    stringBuffer.append(TEXT_23);
    
}

    stringBuffer.append(TEXT_24);
    stringBuffer.append(TEXT_25);
    return stringBuffer.toString();
  }
}
