package jet.angular.projeto;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;

public class Principal
{
  protected static String nl;
  public static synchronized Principal create(String lineSeparator)
  {
    nl = lineSeparator;
    Principal result = new Principal();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "import { NgModule } from '@angular/core';" + NL + "import { CommonModule } from '@angular/common';" + NL + "import { Routes, RouterModule } from '@angular/router';" + NL + "import { PrincipalComponent } from '../principal/principal.component';" + NL + "import { LoginComponent } from '../login/login.component';" + NL + "import { AdmHomeComponent } from '../adm-home/adm-home.component';" + NL + "import { FormsModule }   from '@angular/forms';" + NL + "import { SidebarComponent } from '../sidebar/sidebar.component';" + NL + "" + NL + "" + NL + "const principalRotas: Routes = [" + NL + "  { path : '' , component: LoginComponent  }," + NL + "  { " + NL + "    path : 'home' , component: PrincipalComponent, " + NL + "    children : [" + NL + "      {path:'', component: AdmHomeComponent}" + NL + "    ]" + NL + "  }" + NL + "]" + NL + "" + NL + "" + NL + "" + NL + "" + NL + "@NgModule({" + NL + "  imports: [" + NL + "    CommonModule," + NL + "    RouterModule.forRoot(principalRotas)," + NL + "    FormsModule" + NL + "  ]," + NL + "  exports: [" + NL + "    RouterModule" + NL + "  ]," + NL + "  declarations: [" + NL + "    LoginComponent," + NL + "    PrincipalComponent," + NL + "    AdmHomeComponent," + NL + "    PedidoComponent," + NL + "    ProdutoComponent," + NL + "    SidebarComponent" + NL + "  ]" + NL + "})" + NL + "export class PrincipalRoutingModule { }";
  protected final String TEXT_3 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
ClasseWrapperAngular classe = (ClasseWrapperAngular) recursos.getClasse();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}
