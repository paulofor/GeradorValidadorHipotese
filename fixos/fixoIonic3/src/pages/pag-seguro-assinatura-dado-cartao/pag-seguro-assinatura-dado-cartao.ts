import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { Assinatura } from '../../shared/assinatura';
import { PagSeguroApi } from '../../shared/sdk/services/integracao/PagSeguro';

/**
 * Generated class for the PagSeguroAssinaturaDadoCartaoPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */
declare var PagSeguroDirectPayment: any;

@IonicPage()
@Component({
  selector: 'page-pag-seguro-assinatura-dado-cartao',
  templateUrl: 'pag-seguro-assinatura-dado-cartao.html',
})



export class PagSeguroAssinaturaDadoCartaoPage {


  erroNome: string;
  erroNumero: string;
  erroMes: string;
  erroAno: string;
  erroVerificador: string;

  codigoFinal = '';

  cartao = {
    "nome" : "",
    "bandeira" : "",
    "numero" : "",
    "anoExpira" : "",
    "mesExpira" : "" ,
    "verificador" : ""
  }


  

  constructor(public navCtrl: NavController, public navParams: NavParams, private pagSrv: PagSeguroApi) {
  }

  enviar() {
    this.obtemTokenCartao();
  }
 
  // tratementos do cartao


  idSession = '';
  codigoHash = '';
  tokenCartao = '';

  ionViewDidLoad() {
    console.log('ionViewDidLoad PagSeguroAssinaturaDadoCartaoPage');
    this.pagSrv.ObtemSessao()
      .subscribe((resp) => {
        console.log('Resp- Sessao:' + JSON.stringify(resp));
        this.idSession = resp.idSessao;
        this.obtemMeioPagamento(1.15);
        this.obtemHashCliente();
      })
  }
 
  obtemMeioPagamento(valor:number) {
    PagSeguroDirectPayment.setSessionId(this.idSession);
    PagSeguroDirectPayment.getPaymentMethods({
      amount: valor,
      success: function (response) {
        console.log('Meio pagto:' + JSON.stringify(response));
        this.obtemHashCliente();
      },
      error: function (response) {
        console.log('MeioPgto Falha:' + JSON.stringify(response));
      },
      complete: function (response) {
      }
    });
  }
  
  obtemHashCliente() {
    PagSeguroDirectPayment.setSessionId(this.idSession);
    console.log('--> Vai buscar o hash');
    PagSeguroDirectPayment.onSenderHashReady(function (response) {
      console.log('onSender-response:' + JSON.stringify(response));
      if (response.status == 'error') {
        console.log('onSender:' + response.message);
        return false;
      }
      console.log('Hash: ' ,  response.senderHash);
      hashGlobal = response.senderHash;
    });
  }

  obtemTokenCartao() {
    console.log('--> Chamou token card');
    PagSeguroDirectPayment.createCardToken({
      cardNumber: this.cartao.numero, // Número do cartão de crédito
      brand: this.cartao.bandeira, // Bandeira do cartão
      cvv: this.cartao.verificador, // CVV do cartão
      expirationMonth: this.cartao.mesExpira, // Mês da expiração do cartão
      expirationYear: this.cartao.anoExpira, // Ano da expiração do cartão, é necessário os 4 dígitos.
      success: function (response) {
        // Retorna o cartão tokenizado.
        console.log('TokenCard Sucesso:' + JSON.stringify(response.card.token));
        tokenGlobal = response.card.token;
        console.log('Vai chamar finalizar');
        this.finalizar();

       
      },
      error: function (response) {
        console.log('TokenCard Erro:' + JSON.stringify(response));
      },
      complete: function (response) {
        // Callback para todas chamadas.
      }
    });
  }


  preencher() {
    this.cartao.numero = '123456789888';
    this.cartao.verificador = '919';
    this.cartao.mesExpira = '01';
    this.cartao.anoExpira = '2027';
    this.cartao.bandeira = 'visa';
  }

  finalizar() {
    Assinatura.paymentMethod.creditCard.holder.phone = Assinatura.sender.phone;
    Assinatura.paymentMethod.creditCard.token = tokenGlobal;
    Assinatura.paymentMethod.creditCard.holder.name = Assinatura.sender.name;
    Assinatura.paymentMethod.creditCard.holder.documents = Assinatura.sender.documents;
    Assinatura.sender.hash = hashGlobal;
    //Assinatura.paymentMethod.creditCard.holder.birthDate = Assinatura.sender.
    console.log('Entrou em finalizar:' , Assinatura);
    this.pagSrv.AderePlanoTreino(Assinatura)
      .subscribe((result) => {
        console.log('Result:' , result);
        if (result.code)
          this.codigoFinal = result.code;
      })
  }

}

export var tokenGlobal : string;
export var hashGlobal : string;
