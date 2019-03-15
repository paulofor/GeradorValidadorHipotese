package jet.angular.componente;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;
import gerapp.modelo.node.*;

public class ComponenteSpec
{
  protected static String nl;
  public static synchronized ComponenteSpec create(String lineSeparator)
  {
    nl = lineSeparator;
    ComponenteSpec result = new ComponenteSpec();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "import { async, ComponentFixture, TestBed } from '@angular/core/testing';" + NL + "" + NL + "import { ";
  protected final String TEXT_3 = " } from './";
  protected final String TEXT_4 = "';" + NL + "" + NL + "describe('";
  protected final String TEXT_5 = "', () => {" + NL + "  let component: ";
  protected final String TEXT_6 = ";" + NL + "  let fixture: ComponentFixture<";
  protected final String TEXT_7 = ">;" + NL + "" + NL + "  beforeEach(async(() => {" + NL + "    TestBed.configureTestingModule({" + NL + "      declarations: [ ";
  protected final String TEXT_8 = " ]" + NL + "    })" + NL + "    .compileComponents();" + NL + "  }));" + NL + "" + NL + "  beforeEach(() => {" + NL + "    fixture = TestBed.createComponent(";
  protected final String TEXT_9 = ");" + NL + "    component = fixture.componentInstance;" + NL + "    fixture.detectChanges();" + NL + "  });" + NL + "" + NL + "  it('should create', () => {" + NL + "    expect(component).toBeTruthy();" + NL + "  });" + NL + "});";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
ItemAngular comp = (ItemAngular) recursos.getItemCorrente();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_2);
    stringBuffer.append( comp.getNome() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( comp.getArquivo() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( comp.getNome() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( comp.getNome() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( comp.getNome() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( comp.getNome() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( comp.getNome() );
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}
