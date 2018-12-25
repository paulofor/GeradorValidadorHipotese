package jet.ionic3.page.lista;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.base.node.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;
import gerapp.modelo.node.*;

public class ListaPageTs
{
  protected static String nl;
  public static synchronized ListaPageTs create(String lineSeparator)
  {
    nl = lineSeparator;
    ListaPageTs result = new ListaPageTs();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + NL + "import { Component } from '@angular/core';" + NL + "import { IonicPage, ModalController, NavController } from 'ionic-angular';" + NL + "" + NL + "import { Item } from '../../models/item';" + NL + "import { Items } from '../../providers';" + NL + "" + NL + "@IonicPage()" + NL + "@Component({" + NL + "  selector: '";
  protected final String TEXT_3 = "'," + NL + "  templateUrl: '";
  protected final String TEXT_4 = ".html'" + NL + "})" + NL + "export class ";
  protected final String TEXT_5 = " {" + NL + "  currentItems: Item[];" + NL + "" + NL + "  constructor(public navCtrl: NavController, public items: Items, public modalCtrl: ModalController) {" + NL + "    this.currentItems = this.items.query();" + NL + "  }" + NL + "" + NL + "  /**" + NL + "   * The view loaded, let's query our items for the list" + NL + "   */" + NL + "  ionViewDidLoad() {" + NL + "  }" + NL + "" + NL + "  addItem() {" + NL + "  }" + NL + "  deleteItem(item) {" + NL + "  }" + NL + "  openItem(item) {" + NL + "  }" + NL + "  " + NL + " " + NL + "  /* " + NL + "  addItem() {" + NL + "    let addModal = this.modalCtrl.create('TelaCriar');" + NL + "    addModal.onDidDismiss(item => {" + NL + "      if (item) {" + NL + "        this.items.add(item);" + NL + "      }" + NL + "    })" + NL + "    addModal.present();" + NL + "  }" + NL + "  deleteItem(item) {" + NL + "    this.items.delete(item);" + NL + "  }" + NL + "  openItem(item: Item) {" + NL + "    this.navCtrl.push('TelaDetalhe', {" + NL + "      item: item" + NL + "    });" + NL + "  }" + NL + "  */" + NL + "  " + NL + "}";
  protected final String TEXT_6 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
TelaAppWrapper tela = (TelaAppWrapper) recursos.getItemCorrente();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_2);
    stringBuffer.append( tela.getNomeControle() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( tela.getArquivo() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
