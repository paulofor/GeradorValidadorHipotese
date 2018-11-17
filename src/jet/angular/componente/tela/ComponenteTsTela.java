package jet.angular.componente.tela;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.base.node.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;

public class ComponenteTsTela
{
  protected static String nl;
  public static synchronized ComponenteTsTela create(String lineSeparator)
  {
    nl = lineSeparator;
    ComponenteTsTela result = new ComponenteTsTela();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "import { Component, OnInit } from '@angular/core';" + NL + "" + NL + "@Component({" + NL + "  selector: 'app-";
  protected final String TEXT_3 = "-tela'," + NL + "  templateUrl: './";
  protected final String TEXT_4 = "-tela.component.html'," + NL + "  styleUrls: ['./";
  protected final String TEXT_5 = "-tela.component.scss']" + NL + "})" + NL + "export class ";
  protected final String TEXT_6 = "TelaComponent implements OnInit {" + NL + "" + NL + "  constructor() {" + NL + "  }" + NL + "" + NL + "  ngOnInit() {" + NL + "  }" + NL + "" + NL + "" + NL + "" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
TelaWebWrapper tela = (TelaWebWrapper) recursos.getTelaWebCorrente();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_2);
    stringBuffer.append( tela.getNomeArquivoComponente() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( tela.getNomeArquivoComponente() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( tela.getNomeArquivoComponente() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( tela.getNomeComponente() );
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
