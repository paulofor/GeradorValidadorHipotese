import { NavController } from "ionic-angular";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Usuario, UsuarioApi, UsuarioProduto } from "../../shared/sdk/index";
import { HomePage } from "../home/home";
import { Storage } from '@ionic/storage';
//import { ComandosZeroPage } from "../comandos-zero/comandos-zero";
import { ComponenteBase } from '../componente-base';
import { MSG_CADASTRO_TAMANHO_SENHA, MSG_CADASTRO_EMAIL, VERSAO_APP_ID } from "../../app/const";
import { AcessaFcmService } from "../../servico/acessa-fcm-service";
import { UsuarioProdutoApi } from "../../shared/sdk/services/custom/UsuarioProduto";
import { ListaOportunidadePrecoAssinaturaPage } from "../lista-oportunidade-preco-assinatura/lista-oportunidade-preco-assinatura";
import { Page } from "ionic-angular/navigation/nav-util";



export abstract class SignupPageBase extends ComponenteBase {

  protected usuario: UsuarioProduto;
  protected signupForm: FormGroup;
  protected erroMsg: string;
  protected enviando: boolean;

  protected msgSenha: string = MSG_CADASTRO_TAMANHO_SENHA;
  protected msgEmail: string = MSG_CADASTRO_EMAIL;

  chavePagina = 'c2b925b0dd233741e199e83a93afc1ad46047828';

  abstract getPaginaInicial(): Page;

  constructor(public navCtrl: NavController, protected formBuilder: FormBuilder, protected storage: Storage,
    protected srv: UsuarioProdutoApi, protected fcmSrv: AcessaFcmService) {
    super();
    this.signupForm = this.formBuilder.group({
      login: ['', Validators.email],
      senha1: ['', Validators.compose([Validators.minLength(8), Validators.required])],
      senha2: ['', Validators.compose([Validators.minLength(8), Validators.required])]
    });
  }

  ionViewDidLoad() {
    //console.log('ionViewDidLoad LoginPage');
    this.fcmSrv.registraVisitaPagina(this.chavePagina, VERSAO_APP_ID);
  }

  ionViewWillEnter() {
    console.log('');
    console.log('Tela: SignupPage');
  }

  verificado(): boolean {
    let saida = (this.signupForm.get('login').valid) &&
      (this.signupForm.get('senha1').valid) &&
      (this.signupForm.get('senha2').valid);
    return saida;
  }

  onSubmit() {
    if (this.verificado()) {
      this.processaSubmit();
    }
  }

  


  processaSubmit() {
    this.usuario = new UsuarioProduto();
    this.usuario.email = this.signupForm.get("login").value;
    let senha1 = this.signupForm.get("senha1").value;
    let senha2 = this.signupForm.get("senha2").value;
    if (senha1 != senha2) {
      this.erroMsg = 'Senhas diferentes';
      return;
    } else {
      this.usuario.senha = senha1;
      this.storage.get("chave").then((chaveUsuario) => {
        this.usuario.chave = chaveUsuario;
        alert("usuario:" + JSON.stringify(this.usuario));
        this.srv.PrimeiroAcesso(this.usuario)
          .subscribe(
            (result) => {
              //this.storage.set('user', result);
              console.log('SignUp: ', result);
              this.navCtrl.push(this.getPaginaInicial());
            },
            (error) => {
              console.log('Erro: ', error);
              this.erroMsg = 'Ocorreu um erro, tente novamente';
            }
          )
      });
    }
  }

}
