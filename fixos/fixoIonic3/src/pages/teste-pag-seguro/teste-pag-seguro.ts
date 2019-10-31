import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { HttpClient } from '@angular/common/http';
import { PagSeguroApi } from '../../app/shared/sdk/index';

declare var PagSeguroDirectPayment: any;


/**
 * Generated class for the TestePagSeguroPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-teste-pag-seguro',
  templateUrl: 'teste-pag-seguro.html',
})
export class TestePagSeguroPage {


  idSession = '';
  codigoHash = '';
  tokenCartao = '';

  constructor(public navCtrl: NavController, public navParams: NavParams, private pagSrv: PagSeguroApi) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad TestePagSeguroPage');
    this.pagSrv.ObtemSessao()
      .subscribe((resp) => {
        //console.log('Err:' + JSON.stringify(err));
        //console.log('Resp:' + JSON.stringify(resp));
        this.idSession = resp.idSessao;
        this.setSessao();
      })
  }

  setSessao() {
    PagSeguroDirectPayment.setSessionId(this.idSession);
    PagSeguroDirectPayment.getPaymentMethods({
      amount: 1.15,
      success: function (response) {
        console.log('Resultado setSessao() ok' + new Date());
        //console.log('MeioPagto Sucesso:' + JSON.stringify(response));
        //console.log('Vai chamar on sender');
        //this.obtemHashCliente();
      },
      error: function (response) {
        console.log('MeioPgto Falha:' + JSON.stringify(response));
        // Callback para chamadas que falharam.
      },
      complete: function (response) {
        // Callback para todas chamadas.
        //console.log('MeioPgto Total:' + JSON.stringify(response));
      }
    });
  }

  comprar() {
    console.log('Chamou comprar');
    this.obtemHashCliente();
  }


  meusDados() {
    console.log('********************************');
    console.log(this);
    console.log('Hash: ' + hashGlobal);
    console.log('Cartao: ' + tokenGlobal);
  }

  obtemHashCliente() {
    console.log('--> Vai buscar o hash');
    PagSeguroDirectPayment.onSenderHashReady(function (response) {
      console.log('onSender-response:' + JSON.stringify(response));
      if (response.status == 'error') {
        console.log('onSender:' + response.message);
        return false;
      }
      console.log('This:' + this);
      //console.log('IdSessao: ' + this.idSession);
      //console.log('HashAtual:' + this.codigoHash);
      //console.log('response.senderHash:' , response.senderHash);
      //hashGlobal = response.senderHash; //Hash estará disponível nesta variável.
      console.log('Hash: ' ,  response.senderHash);
      hashGlobal = response.senderHash;
      //this.setHash(hash);
    });
  }

  obtemParcelamento() {
    console.log('--> obtem parcelamento');
    PagSeguroDirectPayment.getInstallments({
      amount: 118.80,
      maxInstallmentNoInterest: 2,
      brand: 'visa',
      success: function (response) {
        // Retorna as opções de parcelamento disponíveis
        console.log('Parcelamento Sucesso:' + JSON.stringify(response));
      },
      error: function (response) {
        // callback para chamadas que falharam.
        console.log('Parcelamento Erro:' + JSON.stringify(response));
      },
      complete: function (response) {
        // Callback para todas chamadas.
        //console.log('Parcelamento Completo:' + JSON.stringify(response));
      }
    });
  }


  // seis primeiros digitos do cartao
  obtemBandeira() {
    console.log('--> Chamou bandeira');
    PagSeguroDirectPayment.getBrand({
      cardBin: 411111,
      success: function (response) {
        //bandeira encontrada
        console.log('Bandeira Sucesso:' + JSON.stringify(response));
      },
      error: function (response) {
        //tratamento do erro
        console.log('Bandeira Erro:' + JSON.stringify(response));
      },
      complete: function (response) {
        //tratamento comum para todas chamadas
        //console.log('Bandeira Completo:' + JSON.stringify(response));
      }
    });
  }


  obtemTokenCartao() {
    console.log('--> Chamou token card');
    PagSeguroDirectPayment.createCardToken({
      cardNumber: '4111111111111111', // Número do cartão de crédito
      brand: 'visa', // Bandeira do cartão
      cvv: '013', // CVV do cartão
      expirationMonth: '12', // Mês da expiração do cartão
      expirationYear: '2026', // Ano da expiração do cartão, é necessário os 4 dígitos.
      success: function (response) {
        // Retorna o cartão tokenizado.
        console.log('TokenCard Sucesso:' + JSON.stringify(response.card.token));
        tokenGlobal = response.card.token;
      },
      error: function (response) {
        // Callback para chamadas que falharam.
        console.log('TokenCard Erro:' + JSON.stringify(response));
      },
      complete: function (response) {
        // Callback para todas chamadas.
        //console.log('TokenCard Completo:' + JSON.stringify(response));
      }
    });
  }


}

export var tokenGlobal : string;
export var hashGlobal : string;
