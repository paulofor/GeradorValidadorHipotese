package jet.angular.componente.tela;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.base.node.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;

public class ComponenteSpecTela
{
  protected static String nl;
  public static synchronized ComponenteSpecTela create(String lineSeparator)
  {
    nl = lineSeparator;
    ComponenteSpecTela result = new ComponenteSpecTela();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "import { async, ComponentFixture, TestBed } from '@angular/core/testing';" + NL + "" + NL + "import { ";
  protected final String TEXT_3 = "TelaComponent } from './tela-";
  protected final String TEXT_4 = ".component';" + NL + "" + NL + "describe('";
  protected final String TEXT_5 = "TelaComponent', () => {" + NL + "  let component: ListaProjetoValorComponent;" + NL + "  let fixture: ComponentFixture<";
  protected final String TEXT_6 = "TelaComponent>;" + NL + "" + NL + "  beforeEach(async(() => {" + NL + "    TestBed.configureTestingModule({" + NL + "      declarations: [ ";
  protected final String TEXT_7 = "TelaComponent ]" + NL + "    })" + NL + "    .compileComponents();" + NL + "  }));" + NL + "" + NL + "  beforeEach(() => {" + NL + "    fixture = TestBed.createComponent(";
  protected final String TEXT_8 = "TelaComponent);" + NL + "    component = fixture.componentInstance;" + NL + "    fixture.detectChanges();" + NL + "  });" + NL + "" + NL + "  it('should create', () => {" + NL + "    expect(component).toBeTruthy();" + NL + "  });" + NL + "});";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
TelaWebWrapper tela = (TelaWebWrapper) recursos.getTelaWebCorrente();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_2);
    stringBuffer.append( tela.getNomeComponente() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( tela.getNomeArquivoComponente() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( tela.getNomeComponente() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( tela.getNomeComponente() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( tela.getNomeComponente() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( tela.getNomeComponente() );
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}
