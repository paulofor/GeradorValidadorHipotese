package jet.ionic3.page.form;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.base.node.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;
import gerapp.modelo.node.*;

public class FormPageProdBaseTs
{
  protected static String nl;
  public static synchronized FormPageProdBaseTs create(String lineSeparator)
  {
    nl = lineSeparator;
    FormPageProdBaseTs result = new FormPageProdBaseTs();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "import { ";
  protected final String TEXT_2 = ", ";
  protected final String TEXT_3 = "Api } from '../../shared/sdk';";
  protected final String TEXT_4 = NL + "import { ";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = "Api } from '../../shared/sdk';";
  protected final String TEXT_7 = NL + NL + "export abstract class ";
  protected final String TEXT_8 = "PageBase {" + NL + "  " + NL + "  protected item: ";
  protected final String TEXT_9 = ";" + NL + "  " + NL + "  protected abstract inicializacao();" + NL + "" + NL + "  constructor(\t" + NL + "\t\t\t\tpublic srv: ";
  protected final String TEXT_10 = "Api, ";
  protected final String TEXT_11 = NL + "\t\t\t\tpublic srv";
  protected final String TEXT_12 = " : ";
  protected final String TEXT_13 = "Api,";
  protected final String TEXT_14 = NL + "  \t\t\t\t) {" + NL + "  }" + NL + "" + NL + "  ionViewWillEnter() {" + NL + "    console.log('ionViewWillEnter ";
  protected final String TEXT_15 = "');" + NL + "    this.inicializacao();" + NL + "  }" + NL + "" + NL + "  ionViewDidLoad() {" + NL + "  \tconsole.log('ionViewDidLoad ";
  protected final String TEXT_16 = "');" + NL + "  }" + NL + "  ";
  protected final String TEXT_17 = NL + "\tprotected lista";
  protected final String TEXT_18 = " : ";
  protected final String TEXT_19 = "[];" + NL + "\tprotected carrega";
  protected final String TEXT_20 = "(){" + NL + "\t\tthis.srv";
  protected final String TEXT_21 = ".find()" + NL + "      \t\t.subscribe((result:";
  protected final String TEXT_22 = "[]) => {" + NL + "        \t\tthis.lista";
  protected final String TEXT_23 = " = result;" + NL + "      \t})" + NL + "\t}" + NL + "\t" + NL + "\tprotected lista";
  protected final String TEXT_24 = "Usuario : ";
  protected final String TEXT_25 = "[];" + NL + "\tprotected carrega";
  protected final String TEXT_26 = "Usuario(idUsuario:number){" + NL + "\t\tthis.srv";
  protected final String TEXT_27 = ".find({'where' : {'idUsuario' : idUsuario} })" + NL + "      \t\t.subscribe((result:";
  protected final String TEXT_28 = "[]) => {" + NL + "        \t\tthis.lista";
  protected final String TEXT_29 = "Usuario = result;" + NL + "      \t})" + NL + "\t}" + NL;
  protected final String TEXT_30 = NL + "  " + NL + "}";
  protected final String TEXT_31 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
Recursos recursos = (Recursos) argument;  
TelaAppWrapper tela = (TelaAppWrapper) recursos.getItemCorrente();
ClasseWrapper classe = tela.getEntidade();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_1);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_3);
    
Iterator<RelacionamentoWrapper> itRel =  classe.obtemListaSemChaveEstrangeira().iterator();
while (itRel.hasNext()) {
	RelacionamentoWrapper relac = itRel.next();
	ClasseWrapper oposta = relac.getClasseOposta();

    stringBuffer.append(TEXT_4);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_6);
    
}

    stringBuffer.append(TEXT_7);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append( tela.getEntidade().getNomeParaClasse() );
    stringBuffer.append(TEXT_10);
    
itRel =  classe.obtemListaSemChaveEstrangeira().iterator();
while (itRel.hasNext()) {
	RelacionamentoWrapper relac = itRel.next();
	ClasseWrapper oposta = relac.getClasseOposta();

    stringBuffer.append(TEXT_11);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_13);
    
}

    stringBuffer.append(TEXT_14);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_15);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_16);
    
itRel =  classe.obtemListaSemChaveEstrangeira().iterator();
while (itRel.hasNext()) {
	RelacionamentoWrapper relac = itRel.next();
	ClasseWrapper oposta = relac.getClasseOposta();

    stringBuffer.append(TEXT_17);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_20);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_21);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_22);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_24);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_25);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_26);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_27);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_28);
    stringBuffer.append( oposta.getNomeParaClasse() );
    stringBuffer.append(TEXT_29);
    
}

    stringBuffer.append(TEXT_30);
    stringBuffer.append(TEXT_31);
    return stringBuffer.toString();
  }
}
