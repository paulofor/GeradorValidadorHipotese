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
  protected final String TEXT_2 = NL + "import { Injectable } from '@angular/core';" + NL + "import { Container } from '../../models/Container';" + NL + "import { User } from '../../models/User';";
  protected final String TEXT_3 = NL + "import { ";
  protected final String TEXT_4 = " } from '../../models/";
  protected final String TEXT_5 = "';";
  protected final String TEXT_6 = NL + NL + "export interface Models { [name: string]: any }" + NL + "" + NL + "@Injectable()" + NL + "export class SDKModels {" + NL + "" + NL + "  private models: Models = {" + NL + "    User: User," + NL + "    Projeto: Projeto," + NL + "    ProjetoCanvas: ProjetoCanvas," + NL + "    ProjetoMySql: ProjetoMySql," + NL + "    ProjetoCanvasMySql: ProjetoCanvasMySql," + NL + "    MvpCanvasMySql: MvpCanvasMySql," + NL + "    GanhoDorCanvasMySql: GanhoDorCanvasMySql," + NL + "    PaginaValidacaoWeb: PaginaValidacaoWeb," + NL + "    ItemValidacaoPagina: ItemValidacaoPagina," + NL + "    RegistroInteresse: RegistroInteresse," + NL + "    ProjetoExemplo: ProjetoExemplo," + NL + "    Receita: Receita," + NL + "    Container: Container," + NL + "    Visitante: Visitante," + NL + "    AnuncioAds: AnuncioAds," + NL + "    CampanhaAds: CampanhaAds," + NL + "    PalavraChaveAds: PalavraChaveAds," + NL + "    Aplicacao: Aplicacao," + NL + "    Atributo_entidade: Atributo_entidade," + NL + "    Entidade: Entidade," + NL + "    ModeloCampanhaAds: ModeloCampanhaAds," + NL + "    Relacionamento_entidade: Relacionamento_entidade," + NL + "    " + NL + "  };" + NL + "" + NL + "  public get(modelName: string): any {" + NL + "    return this.models[modelName];" + NL + "  }" + NL + "" + NL + "  public getAll(): Models {" + NL + "    return this.models;" + NL + "  }" + NL + "" + NL + "  public getModelNames(): string[] {" + NL + "    return Object.keys(this.models);" + NL + "  }" + NL + "}";
  protected final String TEXT_7 = NL;

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
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
