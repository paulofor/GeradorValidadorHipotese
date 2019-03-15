package jet.angular.loopback;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;

public class IndexPrincipal
{
  protected static String nl;
  public static synchronized IndexPrincipal create(String lineSeparator)
  {
    nl = lineSeparator;
    IndexPrincipal result = new IndexPrincipal();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/* tslint:disable */" + NL + "/**" + NL + "* @module SDKModule" + NL + "* @author Jonathan Casarrubias <t:@johncasarrubias> <gh:jonathan-casarrubias>" + NL + "* @license MIT 2016 Jonathan Casarrubias" + NL + "* @version 2.1.0" + NL + "* @description" + NL + "* The SDKModule is a generated Software Development Kit automatically built by" + NL + "* the LoopBack SDK Builder open source module." + NL + "*" + NL + "* The SDKModule provides Angular 2 >= RC.5 support, which means that NgModules" + NL + "* can import this Software Development Kit as follows:" + NL + "*" + NL + "*" + NL + "* APP Route Module Context" + NL + "* ============================================================================" + NL + "* import { NgModule }       from '@angular/core';" + NL + "* import { BrowserModule }  from '@angular/platform-browser';" + NL + "* // App Root " + NL + "* import { AppComponent }   from './app.component';" + NL + "* // Feature Modules" + NL + "* import { SDK[Browser|Node|Native]Module } from './shared/sdk/sdk.module';" + NL + "* // Import Routing" + NL + "* import { routing }        from './app.routing';" + NL + "* @NgModule({" + NL + "*  imports: [" + NL + "*    BrowserModule," + NL + "*    routing," + NL + "*    SDK[Browser|Node|Native]Module.forRoot()" + NL + "*  ]," + NL + "*  declarations: [ AppComponent ]," + NL + "*  bootstrap:    [ AppComponent ]" + NL + "* })" + NL + "* export class AppModule { }" + NL + "*" + NL + "**/" + NL + "import { ErrorHandler } from './services/core/error.service';" + NL + "import { LoopBackAuth } from './services/core/auth.service';" + NL + "import { LoggerService } from './services/custom/logger.service';" + NL + "import { SDKModels } from './services/custom/SDKModels';" + NL + "import { InternalStorage, SDKStorage } from './storage/storage.swaps';" + NL + "import { HttpClientModule } from '@angular/common/http';" + NL + "import { CommonModule } from '@angular/common';" + NL + "import { NgModule, ModuleWithProviders } from '@angular/core';" + NL + "import { CookieBrowser } from './storage/cookie.browser';" + NL + "import { StorageBrowser } from './storage/storage.browser';" + NL + "import { SocketBrowser } from './sockets/socket.browser';" + NL + "" + NL + "import { SocketConnection } from './sockets/socket.connections';" + NL + "import { RealTime } from './services/core/real.time';" + NL + "import { UserApi } from './services/custom/User';" + NL + "import { ContainerApi } from './services/custom/Container';" + NL;
  protected final String TEXT_3 = NL + "import { ";
  protected final String TEXT_4 = "Api } from './services/custom/";
  protected final String TEXT_5 = "';";
  protected final String TEXT_6 = NL + NL + "/**" + NL + "* @module SDKBrowserModule" + NL + "* @description" + NL + "* This module should be imported when building a Web Application in the following scenarios:" + NL + "*" + NL + "*  1.- Regular web application" + NL + "*  2.- Angular universal application (Browser Portion)" + NL + "*  3.- Progressive applications (Angular Mobile, Ionic, WebViews, etc)" + NL + "**/" + NL + "@NgModule({" + NL + "  imports:      [ CommonModule, HttpClientModule ]," + NL + "  declarations: [ ]," + NL + "  exports:      [ ]," + NL + "  providers:    [" + NL + "    ErrorHandler," + NL + "    SocketConnection" + NL + "  ]" + NL + "})" + NL + "export class SDKBrowserModule {" + NL + "  static forRoot(internalStorageProvider: any = {" + NL + "    provide: InternalStorage," + NL + "    useClass: CookieBrowser" + NL + "  }): ModuleWithProviders {" + NL + "    return {" + NL + "      ngModule  : SDKBrowserModule," + NL + "      providers : [" + NL + "        LoopBackAuth," + NL + "        LoggerService," + NL + "        SDKModels," + NL + "        RealTime," + NL + "        UserApi," + NL + "        ContainerApi," + NL + "\t";
  protected final String TEXT_7 = NL + "\t\t";
  protected final String TEXT_8 = "Api," + NL + "\t";
  protected final String TEXT_9 = NL + "        internalStorageProvider," + NL + "        { provide: SDKStorage, useClass: StorageBrowser }" + NL + "      ]" + NL + "    };" + NL + "  }" + NL + "}" + NL + "/**" + NL + "* Have Fun!!!" + NL + "* - Jon" + NL + "**/" + NL + "export * from './models/index';" + NL + "export * from './services/index';" + NL + "export * from './lb.config';" + NL + "export * from './storage/storage.swaps';" + NL + "export { CookieBrowser } from './storage/cookie.browser';" + NL + "export { StorageBrowser } from './storage/storage.browser';" + NL;
  protected final String TEXT_10 = NL;

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
    
	iterador = classes.iterator();
	while (iterador.hasNext()) {
		ClasseWrapper classe = iterador.next();
	
    stringBuffer.append(TEXT_7);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_8);
    
	}
	
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}
