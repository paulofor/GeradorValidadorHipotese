import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { LoginComponent } from '../login/login.component';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  tituloValor1 = 'Exibir Produtos';
  tituloValor2 = 'Receber Pedidos'

  title = 'app';

  constructor(public dialog: MatDialog) { }

   ngOnInit() {
    console.log('Ola Mundo');
  }

  exibeItem() {
    console.log('Exibe Item');
  }


  openDialog(): void {
    console.log('Tentando abrir tela');
    let dialogRef = this.dialog.open(LoginComponent, {
      width: '350px', height: '350px'
      //data: { name: this.name, animal: this.animal }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      //this.animal = result;
    });
  }

}
