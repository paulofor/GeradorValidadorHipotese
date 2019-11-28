import { Injectable, Inject } from "@angular/core";
import { FCM } from "@ionic-native/fcm";
import { VisitanteApi } from "../shared/sdk/services/custom/Visitante";
import { Visitante } from "../shared/sdk/models/Visitante";
import { DispositivoUsuarioApi } from "../shared/sdk/services/custom/DispositivoUsuario";
import { DispositivoUsuario } from "../shared/sdk/models/DispositivoUsuario";
import { VisitaAppApi } from "../shared/sdk/services/custom/VisitaApp";
import { Storage } from '@ionic/storage';
import { Device } from '@ionic-native/device';


@Injectable()
export class AcessaFcmService {



    constructor(
        @Inject(FCM) protected fcm: FCM,
        @Inject(DispositivoUsuarioApi) protected dispositivoUsuarioSrv: DispositivoUsuarioApi,
        @Inject(VisitaAppApi) protected visitaAppSrv: VisitaAppApi,
        @Inject(VisitanteApi) protected visitanteSrv: VisitanteApi,
        @Inject(Storage) protected storage: Storage,
        @Inject(Device) protected device : Device
    ) {
    }


    public testaDevice() {
        alert('Testa device');
        //console.log('Device: ' , JSON.stringify(this.device));
        alert('Serial:' + this.device.serial);
        alert('UUID:' + this.device.uuid);
        alert('Plataforma:' + this.device.platform);
        alert('SO:' + this.device.version);
        alert('Modelo:' + this.device.model);
    }


	// Chamada externa
    public registraVisitaPagina(chavePagina) {
        this.storage.get("chave").then((chaveUsuario) => {
            if (chaveUsuario) {
                this.atualizacaoToken(chaveUsuario);
                this.visitaAppSrv.RegistraVisitaTelaApp(chaveUsuario,chavePagina)
                .subscribe((resultado: any) => {
                    //console.log('Resultado-VisitaPagina' , resultado);
                })
            }
        });
    }
    public executaValidacao(versaoAppId: number) {
        this.storage.get("chave").then((dado) => {
            if (dado) {
                //console.log('Recuperou Chave');
                this.ligaNotificacao();
                this.registraVisitaApp(dado, versaoAppId);
            } else {
                this.obtemTokenDispostivoUsuario(versaoAppId);
            }
        });
    }
    public executaValidacaoFake(versaoAppId: number) {
        this.storage.get("chave").then((dado) => {
            if (dado) {
                //console.log('Recuperou Chave');
                this.registraVisitaApp(dado, versaoAppId);
            } else {
                this.obtemTokenDispostivoUsuarioFake(versaoAppId);
            }
        });
    }


    private registraMobile(chave, versaoAppId) {
        this.storage.set("chave", chave).then((successData) => {
            this.registraVisitaApp(chave, versaoAppId);
        })
    }
    
    private registraVisitaApp(chave, versaoAppId) {
        console.log('Passou em visita: ', chave);
        this.visitaAppSrv.RegistraVisitaVersaoApp(chave,versaoAppId)
            .subscribe((resultado: any) => {
                console.log('Resultado-VisitaApp' , resultado);
            })
    }
    
    
    private atualizacaoToken(chave) {
        this.fcm.getToken().then(token => {
            this.dispositivoUsuarioSrv.AtualizaToken(chave,token);
        });
    }

    public tokenPagina() {
        this.fcm.getToken().then(token => {
            this.storage.get("chave").then(chave => {
                if (chave) {
                    this.dispositivoUsuarioSrv.AtualizaToken(chave,token);
                }
            })
        })
    }

    private obtemTokenDispostivoUsuarioFake(versaoAppId: number) {
        var token = '112231213215415615151515'
        console.log('Token fake: ', token);
        let dispositivoUsuario: DispositivoUsuario = new DispositivoUsuario();
        dispositivoUsuario.tokenFcm = token;
        dispositivoUsuario.versaoAppId = versaoAppId;
        dispositivoUsuario.codigoDispositivo = this.device.model;
        dispositivoUsuario.versaoSo = this.device.version;
        dispositivoUsuario.fabricante = this.device.manufacturer;
        dispositivoUsuario.serial = this.device.serial;
        dispositivoUsuario.uuid = this.device.uuid;
        this.dispositivoUsuarioSrv.CriaComUsuario(dispositivoUsuario)
            .subscribe((resultado: any) => {
                console.log('Chave-Server:', resultado);
                this.registraMobile(resultado, versaoAppId);
            })
    }
    private obtemTokenDispostivoUsuario(versaoAppId: number) {
        this.fcm.subscribeToTopic('novo');
        //alert('inscreveu');
        let dispositivoUsuario: DispositivoUsuario = new DispositivoUsuario();
        this.fcm.getToken().then(token => {
            //alert('Meu token:' +token);
            dispositivoUsuario.tokenFcm = token;
            dispositivoUsuario.versaoAppId = versaoAppId;
            dispositivoUsuario.codigoDispositivo = this.device.model;
            dispositivoUsuario.versaoSo = this.device.version;
            dispositivoUsuario.fabricante = this.device.manufacturer;
            dispositivoUsuario.serial = this.device.serial;
            dispositivoUsuario.uuid = this.device.uuid;
            //if (this.device) {
            //    dispositivoUsuario.codigoDispositivo = this.device.model;
            //} else {
            //    dispositivoUsuario.codigoDispositivo = "indisponivel";
            //}
            //dispositivoUsuario.versaoOs = this.device.version;
            //alert(JSON.stringify(disppositivoUsuario));
            this.dispositivoUsuarioSrv.CriaComUsuario(dispositivoUsuario)
                .subscribe((resultado: any) => {
                    console.log('Chave-Server:', resultado);
                    this.registraMobile(resultado, versaoAppId);
                })
        });
        this.ligaNotificacao();
        this.fcm.onTokenRefresh().subscribe(token => {
            //alert('token')
            //alert('Novo token: ' + token);
        });
    }



    private ligaNotificacao() {
        alert('Passou liga notificacao');
        this.fcm.onNotification().subscribe(data => {
            alert('Recebeu notificacao-01: ' + JSON.stringify(data));
            alert('Token:' + data.tokenNotificacao);
            this.registraNotificacao(data.tokenNotificacao);
            if (data.wasTapped) {
                
                alert('background-01');
                //alert('Meu Token' + data.tokenNotificacao);
            } else {
                alert('foreground-01');
            }
            //let visitaNotificacao = new Visitante();
            //visitaNotificacao.versaoAppId = 789;
            //this.visitanteSrv.criaItem(visitaNotificacao)
            //    .subscribe((resultado: any) => {
            //        alert('notificacao: ' + JSON.stringify(resultado));
            //    })
        });
    }


    private registraNotificacao(token:string) {
        this.storage.set("token", token).then((successData) => {
        })
    }
    public mostraToken() {
        this.storage.get("token").then((dado) => {
            if (dado) {
                alert('token:' + dado);
            } else {
                alert('token nao encontrado');
            }
        });
    }

    public obtemToken(visitanteCorrente: Visitante) {
        var token = '112231213215415615151515'
        console.log('Token fake: ', token);
        visitanteCorrente.fcmToken = token;
        visitanteCorrente.dataHoraNotificacao = new Date();
        this.visitanteSrv.atualizaItem(visitanteCorrente.id, visitanteCorrente)
            .subscribe((resultado: any) => {
                console.log('Resultado:', resultado);
            })
    }





}
