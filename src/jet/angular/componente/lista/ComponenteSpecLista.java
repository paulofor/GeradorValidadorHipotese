package jet.angular.componente.lista;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;

public class ComponenteSpecLista
{
  protected static String nl;
  public static synchronized ComponenteSpecLista create(String lineSeparator)
  {
    nl = lineSeparator;
    ComponenteSpecLista result = new ComponenteSpecLista();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "import { async, ComponentFixture, TestBed } from '@angular/core/testing';" + NL + "" + NL + "import { Lista";
  protected final String TEXT_3 = "Component } from './lista-";
  protected final String TEXT_4 = ".component';" + NL + "" + NL + "describe('Lista";
  protected final String TEXT_5 = "Component', () => {" + NL + "  let component: ListaProjetoValorComponent;" + NL + "  let fixture: ComponentFixture<Lista";
  protected final String TEXT_6 = "Component>;" + NL + "" + NL + "  beforeEach(async(() => {" + NL + "    TestBed.configureTestingModule({" + NL + "      declarations: [ Lista";
  protected final String TEXT_7 = "Component ]" + NL + "    })" + NL + "    .compileComponents();" + NL + "  }));" + NL + "" + NL + "  beforeEach(() => {" + NL + "    fixture = TestBed.createComponent(Lista";
  protected final String TEXT_8 = "Component);" + NL + "    component = fixture.componentInstance;" + NL + "    fixture.detectChanges();" + NL + "  });" + NL + "" + NL + "  it('should create', () => {" + NL + "    expect(component).toBeTruthy();" + NL + "  });" + NL + "});";

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
    stringBuffer.append( classe.getNomeParaArquivo() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}
