import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { Assinatura } from '../../app/shared/assinatura';
import { PagSeguroAssinaturaDadoCartaoPage } from '../pag-seguro-assinatura-dado-cartao/pag-seguro-assinatura-dado-cartao';
import { PagSeguroAssinaturaDadoIdentificacaoPage } from '../pag-seguro-assinatura-dado-identificacao/pag-seguro-assinatura-dado-identificacao';

/**
 * Generated class for the PagSeguroAssinaturaDadoClientePage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-pag-seguro-assinatura-dado-cliente',
  templateUrl: 'pag-seguro-assinatura-dado-cliente.html',
})
export class PagSeguroAssinaturaDadoClientePage {


  address = {
    "street": "",
    "number": "",
    "complement": "",
    "district": "",
    "city": "",
    "state": "",
    "country": "BRA",
    "postalCode": ""
  }

  constructor(public navCtrl: NavController, public navParams: NavParams) {
    console.log('Assinatura:', Assinatura.sender.address.street);
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad PagSeguroAssinaturaDadoClientePage');
    this.address = Assinatura.sender.address;
  }

  avancar() {
    this.navCtrl.push(PagSeguroAssinaturaDadoCartaoPage);
  }
  voltar() {
    this.navCtrl.push(PagSeguroAssinaturaDadoIdentificacaoPage);
  }

  preencher() {
    this.address.street = 'Rua Antonio Basilio';
    this.address.number = '204';
    this.address.complement = 'apt. 805';
    this.address.district = 'Tijuca';
    this.address.city = 'Rio de Janeiro';
    this.address.state = 'RJ';
    this.address.postalCode = '20511190';
  }

}
