package jet.ionic3.app;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.base.node.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;
import gerapp.modelo.node.*;

public class AppModuleTs
{
  protected static String nl;
  public static synchronized AppModuleTs create(String lineSeparator)
  {
    nl = lineSeparator;
    AppModuleTs result = new AppModuleTs();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "import { BrowserModule } from '@angular/platform-browser';" + NL + "import { ErrorHandler, NgModule } from '@angular/core';" + NL + "import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';" + NL + "" + NL + "import { MyApp } from './app.component';" + NL + "import { HomePage } from '../pages/home/home';" + NL + "" + NL + "import { StatusBar } from '@ionic-native/status-bar';" + NL + "import { SplashScreen } from '@ionic-native/splash-screen';" + NL + "" + NL + "@NgModule({" + NL + "  declarations: [" + NL + "    MyApp," + NL + "    HomePage," + NL + "    ListPage" + NL + "  ]," + NL + "  imports: [" + NL + "    BrowserModule," + NL + "    IonicModule.forRoot(MyApp)," + NL + "  ]," + NL + "  bootstrap: [IonicApp]," + NL + "  entryComponents: [" + NL + "    MyApp," + NL + "    HomePage," + NL + "  ]," + NL + "  providers: [" + NL + "    StatusBar," + NL + "    SplashScreen," + NL + "    {provide: ErrorHandler, useClass: IonicErrorHandler}" + NL + "  ]" + NL + "})" + NL + "export class AppModule {}";
  protected final String TEXT_3 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
List<ItemComponente> listaTela = recursos.getListaTelaApp();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}
