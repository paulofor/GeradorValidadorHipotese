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
  protected final String TEXT_2 = NL + "import { BrowserModule } from '@angular/platform-browser';" + NL + "import { ErrorHandler, NgModule } from '@angular/core';" + NL + "import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';" + NL + "import { HttpClientModule } from '@angular/common/http';" + NL + "import { SocketDriver } from '../shared/sdk/sockets/socket.driver';" + NL + "import { SDKBrowserModule, SDKModels, LoopBackAuth, InternalStorage } from '../shared/sdk';" + NL + "import { MyApp } from './app.component';" + NL + "import { HomePage } from '../pages/home/home';" + NL + "import { Screenshot } from '@ionic-native/screenshot';";
  protected final String TEXT_3 = NL + "import { ";
  protected final String TEXT_4 = " } from '../pages/";
  protected final String TEXT_5 = "/";
  protected final String TEXT_6 = "';";
  protected final String TEXT_7 = NL + NL + "import { StatusBar } from '@ionic-native/status-bar';" + NL + "import { SplashScreen } from '@ionic-native/splash-screen';";
  protected final String TEXT_8 = NL + "import { ";
  protected final String TEXT_9 = "Api } from '../shared/sdk';";
  protected final String TEXT_10 = NL + NL + NL + "@NgModule({" + NL + "  declarations: [" + NL + "    MyApp," + NL + "    HomePage,";
  protected final String TEXT_11 = NL + "    ";
  protected final String TEXT_12 = "," + NL + "\t";
  protected final String TEXT_13 = NL + "  ]," + NL + "  imports: [" + NL + "    BrowserModule," + NL + "    IonicModule.forRoot(MyApp)," + NL + "    HttpClientModule," + NL + "    SDKBrowserModule.forRoot()" + NL + "    " + NL + "  ]," + NL + "  bootstrap: [IonicApp]," + NL + "  entryComponents: [" + NL + "    MyApp," + NL + "    HomePage,";
  protected final String TEXT_14 = NL + "    ";
  protected final String TEXT_15 = "," + NL + "\t";
  protected final String TEXT_16 = NL + "  ]," + NL + "  providers: [" + NL + "    StatusBar," + NL + "    SplashScreen," + NL + "    {provide: ErrorHandler, useClass: IonicErrorHandler}," + NL + "    SocketDriver," + NL + "    SDKModels," + NL + "    LoopBackAuth," + NL + "    InternalStorage,";
  protected final String TEXT_17 = NL + "\t";
  protected final String TEXT_18 = "Api," + NL + "\t";
  protected final String TEXT_19 = NL + "    Screenshot" + NL + "  ]" + NL + "})" + NL + "export class AppModule {}";
  protected final String TEXT_20 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
List<ItemComponente> listaTela = recursos.getListaTelaApp();
List<ClasseWrapper> classes = recursos.getListaClasse();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_2);
    
Iterator<ItemComponente> iterador = listaTela.iterator();
while (iterador.hasNext()) {
	TelaAppWrapper tela = (TelaAppWrapper) iterador.next();

    stringBuffer.append(TEXT_3);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( tela.getPathArquivo() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( tela.getPathArquivo() );
    stringBuffer.append(TEXT_6);
    
}

    stringBuffer.append(TEXT_7);
    
Iterator iteradorCl = classes.iterator();
while (iteradorCl.hasNext()) {
	ClasseWrapper classe = (ClasseWrapper) iteradorCl.next();

    stringBuffer.append(TEXT_8);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_9);
    
}

    stringBuffer.append(TEXT_10);
    
	iterador = listaTela.iterator();
	while (iterador.hasNext()) {
		TelaAppWrapper tela = (TelaAppWrapper) iterador.next();
	
    stringBuffer.append(TEXT_11);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_12);
    
	}
	
    stringBuffer.append(TEXT_13);
    
	iterador = listaTela.iterator();
	while (iterador.hasNext()) {
		TelaAppWrapper tela = (TelaAppWrapper) iterador.next();
	
    stringBuffer.append(TEXT_14);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_15);
    
	}
	
    stringBuffer.append(TEXT_16);
    
	iteradorCl = classes.iterator();
	while (iteradorCl.hasNext()) {
		ClasseWrapper classe = (ClasseWrapper) iteradorCl.next();
	
    stringBuffer.append(TEXT_17);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_18);
    
	}
	
    stringBuffer.append(TEXT_19);
    stringBuffer.append(TEXT_20);
    return stringBuffer.toString();
  }
}
