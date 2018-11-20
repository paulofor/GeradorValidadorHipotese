import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { SDKBrowserModule } from './shared/sdk';
import { SocketDriver } from './shared/sdk/sockets/socket.driver';
import { PrincipalRoutingModule } from './principal-routing/principal-routing.module';
import { ListaModule } from './lista/lista.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    PrincipalRoutingModule,
    SDKBrowserModule.forRoot(),
    ListaModule
  ],
  providers: [
    SocketDriver
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }