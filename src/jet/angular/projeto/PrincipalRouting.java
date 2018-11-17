package jet.angular.projeto;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.base.node.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;

public class PrincipalRouting
{
  protected static String nl;
  public static synchronized PrincipalRouting create(String lineSeparator)
  {
    nl = lineSeparator;
    PrincipalRouting result = new PrincipalRouting();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "import { NgModule } from '@angular/core';" + NL + "import { CommonModule } from '@angular/common';" + NL + "import { Routes, RouterModule } from '@angular/router';" + NL + "import { PrincipalComponent } from '../principal/principal.component';" + NL + "import { LoginComponent } from '../login/login.component';" + NL + "import { AdmHomeComponent } from '../adm-home/adm-home.component';" + NL + "import { FormsModule }   from '@angular/forms';" + NL + "import { SidebarComponent } from '../sidebar/sidebar.component';";
  protected final String TEXT_3 = NL + "import { ";
  protected final String TEXT_4 = "TelaComponent } from '../tela/";
  protected final String TEXT_5 = "-tela/";
  protected final String TEXT_6 = "-tela.component';";
  protected final String TEXT_7 = NL + NL + NL + "const principalRotas: Routes = [" + NL + "  { path : '' , component: LoginComponent  }," + NL + "  { " + NL + "    path : 'home' , component: PrincipalComponent, " + NL + "    children : [" + NL + "      \t{path:'', component: AdmHomeComponent},";
  protected final String TEXT_8 = NL + "\t\t{path:'";
  protected final String TEXT_9 = "' , component: ";
  protected final String TEXT_10 = "TelaComponent },";
  protected final String TEXT_11 = NL + "    ]" + NL + "  }" + NL + "]" + NL + "" + NL + "" + NL + "@NgModule({" + NL + "  imports: [" + NL + "    CommonModule," + NL + "    RouterModule.forRoot(principalRotas)," + NL + "    FormsModule" + NL + "  ]," + NL + "  exports: [" + NL + "    RouterModule" + NL + "  ]," + NL + "  declarations: [" + NL + "    LoginComponent," + NL + "    PrincipalComponent," + NL + "    AdmHomeComponent," + NL + "    SidebarComponent,";
  protected final String TEXT_12 = NL + "\t";
  protected final String TEXT_13 = "TelaComponent,";
  protected final String TEXT_14 = NL + "  ]" + NL + "})" + NL + "export class PrincipalRoutingModule { }";
  protected final String TEXT_15 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
List<TelaWebWrapper> telas = recursos.getListaTelaWeb();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_2);
    
Iterator<TelaWebWrapper> iterador = telas.iterator();
while (iterador.hasNext()) {
	TelaWebWrapper tela = iterador.next();

    stringBuffer.append(TEXT_3);
    stringBuffer.append( tela.getNomeComponente() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( tela.getNomeArquivoComponente() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( tela.getNomeArquivoComponente() );
    stringBuffer.append(TEXT_6);
    
	}

    stringBuffer.append(TEXT_7);
    
iterador = telas.iterator();
while (iterador.hasNext()) {
	TelaWebWrapper tela = iterador.next();

    stringBuffer.append(TEXT_8);
    stringBuffer.append( tela.getNomeUrl() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append( tela.getNomeComponente() );
    stringBuffer.append(TEXT_10);
    
	}

    stringBuffer.append(TEXT_11);
    
iterador = telas.iterator();
while (iterador.hasNext()) {
	TelaWebWrapper tela = iterador.next();

    stringBuffer.append(TEXT_12);
    stringBuffer.append( tela.getNomeComponente() );
    stringBuffer.append(TEXT_13);
    
	}

    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    return stringBuffer.toString();
  }
}
