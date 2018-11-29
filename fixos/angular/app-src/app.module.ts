import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { SDKBrowserModule } from './shared/sdk';
import { SocketDriver } from './shared/sdk/sockets/socket.driver';
import { PrincipalRoutingModule } from './principal-routing/principal-routing.module';
import { ComponenteTelaModule } from './tela/componente-tela.module';
import { ServicoModule } from './servico/servico.module';
import { ComponenteListaModule } from './lista/componente-lista.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    PrincipalRoutingModule,
    ComponenteTelaModule,
    ServicoModule,
    ComponenteListaModule
  ],
  providers: [
    
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }