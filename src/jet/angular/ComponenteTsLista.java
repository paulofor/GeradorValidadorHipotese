package jet.angular;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;

public class ComponenteTsLista
{
  protected static String nl;
  public static synchronized ComponenteTsLista create(String lineSeparator)
  {
    nl = lineSeparator;
    ComponenteTsLista result = new ComponenteTsLista();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "import { Component, OnInit } from '@angular/core';" + NL + "import { ";
  protected final String TEXT_3 = ", ";
  protected final String TEXT_4 = "Api } from '../shared/sdk';" + NL + "" + NL + "" + NL + "@Component({" + NL + "  selector: 'app-lista-";
  protected final String TEXT_5 = "'," + NL + "  templateUrl: './lista-";
  protected final String TEXT_6 = ".component.html'," + NL + "  styleUrls: ['./lista-";
  protected final String TEXT_7 = ".component.scss']" + NL + "})" + NL + "export class Lista";
  protected final String TEXT_8 = "Component implements OnInit {" + NL + "" + NL + "" + NL + "  itens: ";
  protected final String TEXT_9 = "[];" + NL + "  errMess: string;" + NL + "" + NL + "  constructor(private srv: ";
  protected final String TEXT_10 = "Api) {" + NL + "" + NL + "  }" + NL + "" + NL + "  ngOnInit() {" + NL + "    this.srv.find()" + NL + "      .subscribe((result: ";
  protected final String TEXT_11 = "[]) =>" + NL + "        this.itens = result" + NL + "      );" + NL + "  }" + NL + "" + NL + "" + NL + "" + NL + "}";

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
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( classe.getNomeParaArquivo() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( classe.getNomeParaArquivo() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( classe.getNomeParaArquivo() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}
