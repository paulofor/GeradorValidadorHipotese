import { Injectable, Inject } from "@angular/core";
import { FCM } from "@ionic-native/fcm";
import { VisitanteApi } from "../shared/sdk/services/custom/Visitante";
import { Visitante } from "../shared/sdk/models/Visitante";
import { DispositivoUsuarioApi } from "../shared/sdk/services/custom/DispositivoUsuario";
import { DispositivoUsuario } from "../shared/sdk/models/DispositivoUsuario";
import { VisitaAppApi } from "../shared/sdk/services/custom/VisitaApp";
import { Storage } from '@ionic/storage';
import { Device } from '@ionic-native/device';
import { NotificacaoAppApi } from "../shared/sdk/services/custom/NotificacaoApp";
import { MonitorFaseInicialApp } from "../shared/sdk/models/MonitorFaseInicialApp";
import { MonitorFaseInicialAppApi } from "../shared/sdk/services/custom/MonitorFaseInicialApp";




@Injectable()
export class AcessaFcmService {

    versaoApp = ' v0.9.1';
    contMsg = 0;

    constructor(
        @Inject(FCM) protected fcm: FCM,
        @Inject(DispositivoUsuarioApi) protected dispositivoUsuarioSrv: DispositivoUsuarioApi,
        @Inject(VisitaAppApi) protected visitaAppSrv: VisitaAppApi,
        @Inject(VisitanteApi) protected visitanteSrv: VisitanteApi,
        @Inject(Storage) protected storage: Storage,
        @Inject(Device) protected device: Device,
        @Inject(NotificacaoAppApi) protected notificacaoAppSrv: NotificacaoAppApi,
        @Inject(MonitorFaseInicialAppApi) protected monitorSrv : MonitorFaseInicialAppApi
    ) {
    }


    public carregaUsuario() {

    }

     public mensagemLog(texto) {
        let monitor = new MonitorFaseInicialApp();
        monitor.descricao = (this.contMsg++) + ') ' + texto + "-" + this.versaoApp,'';
        //this.monitorSrv.create(monitor)
        //    .subscribe((result) => {
        //
        //    })
    }

    chavePaginaPendente = null;
    versaoAppIdPendente = null;

    // Chamada externa
    public registraVisitaPagina(chavePagina, versaoAppId) {
        console.log('Passou em visitaPaginaApp: ', chavePagina);
        this.storage.get("chave")
            .then((chaveUsuario) => {
                console.log('Encontrou chave no storage:' , chaveUsuario);
                if (chaveUsuario) {
                    this.visitaAppSrv.RegistraVisitaTelaApp(chaveUsuario, chavePagina, versaoAppId)
                        .subscribe((resultado: any) => {
                            //console.log('Resultado-VisitaPagina' , resultado);
                            this.chavePaginaPendente = null;
                            this.versaoAppIdPendente = null;
                    })
                } else {
                    this.chavePaginaPendente = chavePagina;
                    this.versaoAppIdPendente = versaoAppId;
                    console.log('itens pendentes');
                }
            })
            .catch((result) => {
               
            })
        
    }


    public executaValidacao(versaoAppId: number) {
        this.mensagemLog('inicia validacao');
        this.storage.get("chave")
            .then((dado) => {
                if (dado) {
                    this.mensagemLog('Possui chaveCliente');
                    console.log('Possui chaveCliente:', dado);
                    //alert('Recuperou Chave');
                    this.ligaReceptorNotificacao();
                    this.registraVisitaApp(dado, versaoAppId);
                } else {
                    this.mensagemLog('N�o possui chave cliente');
                    console.log('N�o possui chaveClient');
                    this.executaValidacaoRemote(versaoAppId);
                }
            })
            .catch((result) => {
                this.mensagemLog('Erro no getChave');
            })
    }


    public executaValidacaoRemote(versaoAppId: number) {
        let filtro = { "include": "usuarioProduto", "where": { "and": [{ "uuid": this.device.uuid }] } }
        console.log('Tentativa recuperação chave por uuid: '+ this.device.uuid);
        this.mensagemLog('Tentativa recuperação chave por uuid: '+ this.device.uuid);
        this.dispositivoUsuarioSrv.FindByUuid(this.device.uuid)
            .subscribe(
                (dispositivo: DispositivoUsuario) => {
                					if (dispositivo) {
                        console.log('Encontrou usuario por uuid');
                        this.mensagemLog('Encontrou usuario por uuid');
                    						this.ligaReceptorNotificacao();
                    						this.registraMobile(dispositivo.usuarioProduto.chave,versaoAppId);
                    						this.registraVisitaApp(dispositivo.usuarioProduto.chave, versaoAppId);
                    					} else {
                        console.log('Não encontrou usuario por uuid');
                        this.mensagemLog('Não encontrou usuario por uuid');
                    						this.inscreveFcm(versaoAppId)
                    					}
                },
                erro => {
                    console.log('Não encontrou usuario por uuid - erro');
                    this.mensagemLog('Não encontrou usuario por uuid - erro')
                    this.inscreveFcm(versaoAppId)
                }
            )
    }




 	private registraMobile(chave, versaoAppId) {
        console.log('Vai setar chave:' , chave);
        this.storage.set("chave", chave).then((successData) => {
            this.registraVisitaApp(chave, versaoAppId);
            if (this.chavePaginaPendente) {
                this.registraVisitaPagina(this.chavePaginaPendente,this.versaoAppIdPendente);

            }
        })
    }

    private registraVisitaApp(chave, versaoAppId) {
        console.log('Passou em visitaApp: ', chave);
        this.visitaAppSrv.RegistraVisitaVersaoApp(chave, versaoAppId)
            .subscribe((resultado: any) => {
                console.log('Resultado-VisitaApp', resultado);
            },
            erro => {
                console.log(erro);
                this.mensagemLog(erro)
            })
    }


    private inscreveFcm(versaoAppId: number) {
        this.mensagemLog('Solicita inscrição em FCM');
        console.log('Solicita inscrição em FCM');
        this.fcm.subscribeToTopic('novo');
        this.fcm.getToken().then(token => {
            this.mensagemLog('Recebeu token:' + token);
            console.log('Recebeu token:' + token);
            this.registraTokenFcm(token, versaoAppId);
        });
        //let token = 'fCXMR9m6Ul8:APA91bFZrnR0O4svqLQjHyOHZI6apl8k97_tM7dwvMddK06egoa-rlz8zsXo27VDkReTJZg1JUjxj7BnRYDwYUBshIL-JAx4CUJyZfz4XLHv6KMj5XiT1gJ53Jk-u1SfYB_rfn3C-mpb'
        //this.registraTokenFcm(token,versaoAppId);
        this.ligaReceptorNotificacao();
        this.fcm.onTokenRefresh().subscribe(token => {
            this.registraTokenFcm(token, versaoAppId);
        });
    }

    
    private registraTokenFcm(token, versaoAppId) {
        let dispositivoUsuario: DispositivoUsuario = new DispositivoUsuario();
        dispositivoUsuario.tokenFcm = token;
        dispositivoUsuario.versaoAppId = versaoAppId;
        dispositivoUsuario.codigoDispositivo = this.device.model;
        dispositivoUsuario.versaoSo = this.device.version;
        dispositivoUsuario.fabricante = this.device.manufacturer;
        dispositivoUsuario.serial = this.device.serial;
        dispositivoUsuario.uuid = this.device.uuid;
        this.mensagemLog('Vai para o cria com usuario');
        console.log('Vai para o cria com usuario');
        this.criaComUsuario(dispositivoUsuario, versaoAppId);
    }

    public criaComUsuario(dispositivo: DispositivoUsuario, versaoApp) {
        this.dispositivoUsuarioSrv.CriaComUsuario(dispositivo)
            .subscribe((resultado: any) => {
                this.registraMobile(resultado, versaoApp);
            },
            erro => {
                console.log('Erro no criaComUsuario');
                console.log(erro);
                this.mensagemLog(erro);
                
            })
    }


    private ligaReceptorNotificacao() {
        //alert('ligaReceptorNotificacao()');
        this.fcm.onNotification().subscribe(data => {
            if (data.wasTapped) {
                this.notificacaoAppSrv.RegistraAcesso(data.tokenNotificacao)
                    .subscribe((resultado) => {
                        //console.log('Resultado: ', resultado);
                    });
            }
        });
    }



}
