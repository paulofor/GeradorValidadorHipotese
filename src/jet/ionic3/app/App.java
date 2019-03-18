package jet.ionic3.app;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.base.node.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;
import gerapp.modelo.node.*;

public class App
{
  protected static String nl;
  public static synchronized App create(String lineSeparator)
  {
    nl = lineSeparator;
    App result = new App();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "import { Component, ViewChild } from '@angular/core';" + NL + "import { Nav, Platform } from 'ionic-angular';" + NL + "import { StatusBar } from '@ionic-native/status-bar';" + NL + "import { SplashScreen } from '@ionic-native/splash-screen';" + NL + "" + NL + "import { HomePage } from '../pages/home/home';";
  protected final String TEXT_3 = NL + "import { ";
  protected final String TEXT_4 = " } from '../pages/";
  protected final String TEXT_5 = "/";
  protected final String TEXT_6 = "';";
  protected final String TEXT_7 = NL + NL + NL + "@Component({" + NL + "  templateUrl: 'app.html'" + NL + "})" + NL + "export class MyApp {" + NL + "  @ViewChild(Nav) nav: Nav;" + NL + "" + NL + "  rootPage: any = HomePage;" + NL + "" + NL + "  pages: Array<{title: string, component: any}>;" + NL + "" + NL + "  constructor(public platform: Platform, public statusBar: StatusBar, public splashScreen: SplashScreen) {" + NL + "    this.initializeApp();" + NL + "" + NL + "    // used for an example of ngFor and navigation" + NL + "    this.pages = [" + NL + "\t";
  protected final String TEXT_8 = NL + "      { title: '";
  protected final String TEXT_9 = "' , component: ";
  protected final String TEXT_10 = "}," + NL + "\t";
  protected final String TEXT_11 = NL + "     ];" + NL + "" + NL + "  }" + NL + "" + NL + "  initializeApp() {" + NL + "    this.platform.ready().then(() => {" + NL + "      // Okay, so the platform is ready and our plugins are available." + NL + "      // Here you can do any higher level native things you might need." + NL + "      this.statusBar.styleDefault();" + NL + "      this.splashScreen.hide();" + NL + "    });" + NL + "  }" + NL + "" + NL + "  openPage(page) {" + NL + "    // Reset the content nav to have just this page" + NL + "    // we wouldn't want the back button to show in this scenario" + NL + "    this.nav.setRoot(page.component);" + NL + "  }" + NL + "}";
  protected final String TEXT_12 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
List<ItemComponente> listaTela = recursos.getListaTelaApp();
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
    
	iterador = listaTela.iterator();
	while (iterador.hasNext()) {
		TelaAppWrapper tela = (TelaAppWrapper) iterador.next();
	
    stringBuffer.append(TEXT_8);
    stringBuffer.append( tela.getMenuPrototipo() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_10);
    
	}
	
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}
