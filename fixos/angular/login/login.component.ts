import { Component, OnInit, Inject } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Cliente, ClienteApi } from '../shared/sdk';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  cliente: Cliente;

  ngOnInit() {
    this.cliente = new Cliente();
  }


  constructor(
    private clienteSrv: ClienteApi, private router: Router) {

  }

  onSubmit() {
    console.log("User: ", this.cliente);
    this.verificaLogin();
  }

  verificaLogin() {
    this.clienteSrv.findOne({ "where": { "login": this.cliente.login } })
      .subscribe((item: Cliente) => {
        console.log('Cliente: ', item);

        if (item.senha === this.cliente.senha) {
          this.loginOk();
          //this.dialogRef.close();
          this.router.navigate(['/principal']);
        } else {
          this.loginErro();
        }

      })
  }

  loginOk() {
    console.log('Login ok');
  }
  loginErro() {
    console.log('Login com erro');

  }
}
