package jet.angular.modulo;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;
import gerapp.modelo.node.*;

public class ModuloSpec
{
  protected static String nl;
  public static synchronized ModuloSpec create(String lineSeparator)
  {
    nl = lineSeparator;
    ModuloSpec result = new ModuloSpec();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "import { ";
  protected final String TEXT_3 = " } from './";
  protected final String TEXT_4 = "';" + NL + "" + NL + "describe('";
  protected final String TEXT_5 = "', () => {" + NL + "  let ";
  protected final String TEXT_6 = ": ";
  protected final String TEXT_7 = ";" + NL + "" + NL + "  beforeEach(() => {";
  protected final String TEXT_8 = NL + "    ";
  protected final String TEXT_9 = " = new ";
  protected final String TEXT_10 = "();" + NL + "  });" + NL + "" + NL + "  it('should create an instance', () => {" + NL + "    expect(";
  protected final String TEXT_11 = ").toBeTruthy();" + NL + "  });" + NL + "});" + NL;
  protected final String TEXT_12 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
ModuloComponente comp = (ModuloComponente) recursos.getItemCorrente();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_2);
    stringBuffer.append( comp.getNome() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( comp.getArquivo() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( comp.getNome() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( comp.getNomeVariavel() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( comp.getNome() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    stringBuffer.append( comp.getNomeVariavel() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append( comp.getNome() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( comp.getNomeVariavel() );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}
