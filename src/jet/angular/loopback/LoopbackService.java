package jet.angular.loopback;

import java.util.*;
import gerapp.app.*;
import jet.wrappers.base.*;
import jet.wrappers.angular.*;
import gerapp.modelo.*;
import jet.wrappers.base.node.*;

public class LoopbackService
{
  protected static String nl;
  public static synchronized LoopbackService create(String lineSeparator)
  {
    nl = lineSeparator;
    LoopbackService result = new LoopbackService();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/* tslint:disable */" + NL + "import { Injectable, Inject, Optional } from '@angular/core';" + NL + "import { HttpClient, HttpResponse } from '@angular/common/http';" + NL + "import { SDKModels } from './SDKModels';" + NL + "import { BaseLoopBackApi } from '../core/base.service';" + NL + "import { LoopBackConfig } from '../../lb.config';" + NL + "import { LoopBackAuth } from '../core/auth.service';" + NL + "import { LoopBackFilter,  } from '../../models/BaseModels';" + NL + "import { ErrorHandler } from '../core/error.service';" + NL + "import { Observable, Subject } from 'rxjs';" + NL + "import { map } from 'rxjs/operators';" + NL + "import { ";
  protected final String TEXT_3 = " } from '../../models/";
  protected final String TEXT_4 = "';" + NL + "import { SocketConnection } from '../../sockets/socket.connections';" + NL + "import { ";
  protected final String TEXT_5 = " } from '../../../../dados/";
  protected final String TEXT_6 = "';" + NL + "//import { of } from 'rxjs';" + NL + "//Versao Ionic" + NL + "import { of } from 'rxjs/observable/of';";
  protected final String TEXT_7 = NL + "import {";
  protected final String TEXT_8 = "} from  '../../../../dados/";
  protected final String TEXT_9 = "';";
  protected final String TEXT_10 = NL + "/**" + NL + " * Api services for the `Aplicacao` model." + NL + " */" + NL + "@Injectable()" + NL + "export class ";
  protected final String TEXT_11 = "Api extends BaseLoopBackApi {" + NL + "" + NL + "  constructor(" + NL + "    @Inject(HttpClient) protected http: HttpClient," + NL + "    @Inject(SocketConnection) protected connection: SocketConnection," + NL + "    @Inject(SDKModels) protected models: SDKModels," + NL + "    @Inject(LoopBackAuth) protected auth: LoopBackAuth," + NL + "    @Optional() @Inject(ErrorHandler) protected errorHandler: ErrorHandler" + NL + "  ) {" + NL + "    super(http,  connection,  models, auth, errorHandler);" + NL + "  }" + NL + "" + NL + "  public patchOrCreate(data: any = {}, customHeaders?: Function): Observable<any> {" + NL + "    let _method: string = \"PATCH\";" + NL + "    let _url: string = LoopBackConfig.getPath() + \"/\" + LoopBackConfig.getApiVersion() +" + NL + "    \"/";
  protected final String TEXT_12 = "s\";" + NL + "    let _routeParams: any = {};" + NL + "    let _postBody: any = {" + NL + "      data: data" + NL + "    };" + NL + "    let _urlParams: any = {};" + NL + "    let result = this.request(_method, _url, _routeParams, _urlParams, _postBody, null, customHeaders);" + NL + "    return result;" + NL + "  }" + NL + "" + NL + "  /**" + NL + "   * Patch attributes for a model instance and persist it into the data source." + NL + "   *" + NL + "   * @param {any} id aplicacao id" + NL + "   *" + NL + "   * @param {object} data Request data." + NL + "   *" + NL + "   *  - `data` ? `{object}` - An object of model property name/value pairs" + NL + "   *" + NL + "   * @returns {object} An empty reference that will be" + NL + "   *   populated with the actual data once the response is returned" + NL + "   *   from the server." + NL + "   *" + NL + "   * <em>" + NL + "   * (The remote method definition does not provide any description." + NL + "   * This usually means the response is a `Aplicacao` object.)" + NL + "   * </em>" + NL + "   */" + NL + "  public patchAttributes(id: any, data: any = {}, customHeaders?: Function): Observable<any> {" + NL + "    let _method: string = \"PATCH\";" + NL + "    let _url: string = LoopBackConfig.getPath() + \"/\" + LoopBackConfig.getApiVersion() +" + NL + "    \"/";
  protected final String TEXT_13 = "s/:id\";" + NL + "    let _routeParams: any = {" + NL + "      id: id" + NL + "    };" + NL + "    let _postBody: any = {" + NL + "      data: data" + NL + "    };" + NL + "    let _urlParams: any = {};" + NL + "    let result = this.request(_method, _url, _routeParams, _urlParams, _postBody, null, customHeaders);" + NL + "    return result;" + NL + "  }" + NL + "" + NL + "  /**" + NL + "   * The name of the model represented by this $resource," + NL + "   * i.e. `Aplicacao`." + NL + "   */" + NL + "  public getModelName() {" + NL + "    return \"";
  protected final String TEXT_14 = "\";" + NL + "  }" + NL + "  " + NL + "  obtemPrimeiro(filter: LoopBackFilter = {}, customHeaders?: Function) : Observable<";
  protected final String TEXT_15 = "> {" + NL + "    return of(";
  protected final String TEXT_16 = "[0]);" + NL + "  }" + NL + "  obtemLista(filter: LoopBackFilter = {}, customHeaders?: Function) : Observable<";
  protected final String TEXT_17 = "[]> {" + NL + "    return of(";
  protected final String TEXT_18 = ");" + NL + "  }" + NL + "  obtemElemento(filter: LoopBackFilter = {}, customHeaders?: Function) : Observable<";
  protected final String TEXT_19 = "> {" + NL + "    return of(";
  protected final String TEXT_20 = "[filter.where.id]);" + NL + "  }" + NL;
  protected final String TEXT_21 = NL + "\t";
  protected final String TEXT_22 = "(filter: LoopBackFilter = {}) : Observable<";
  protected final String TEXT_23 = "> {" + NL + "\t\treturn of (";
  protected final String TEXT_24 = ");" + NL + "\t}";
  protected final String TEXT_25 = NL;
  protected final String TEXT_26 = NL + "\tsubmit";
  protected final String TEXT_27 = "(item : ";
  protected final String TEXT_28 = " , customHeaders?: Function) : Observable<";
  protected final String TEXT_29 = "> {" + NL + "\t\tlet _method: string = \"POST\";" + NL + "\t\tlet _url: string = LoopBackConfig.getPath() + \"/\" + LoopBackConfig.getApiVersion() +" + NL + "    \t\t\"/";
  protected final String TEXT_30 = "s/submit";
  protected final String TEXT_31 = "\";" + NL + "    \tlet _routeParams: any = {};" + NL + "    \tlet _postBody: any = {" + NL + "      \t\tdata: item" + NL + "    \t};" + NL + "    \tlet _urlParams: any = {};" + NL + "    \tlet result = this.request(_method, _url, _routeParams, _urlParams, _postBody, null, customHeaders);" + NL + "    \treturn result;" + NL + "\t}";
  protected final String TEXT_32 = NL + "  " + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Recursos recursos = (Recursos) argument;  
ClasseWrapperAngular classe = (ClasseWrapperAngular) recursos.getClasse();
Configuracao conf = recursos.getConfiguracao();

    stringBuffer.append(TEXT_2);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( classe.getNomeParaConstante() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( classe.getNomeParaVariavel() );
    stringBuffer.append(TEXT_6);
    
Iterator<TelaAppWrapper> iterador0 = classe.getListaTelaApp().iterator();
while (iterador0.hasNext()) {
	TelaAppWrapper tela = iterador0.next();

    stringBuffer.append(TEXT_7);
    stringBuffer.append( tela.getMetodoCargaConstante() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( classe.getNomeParaVariavel() );
    stringBuffer.append(TEXT_9);
    
}

    stringBuffer.append(TEXT_10);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_11);
    stringBuffer.append( classe.getNomeParaVariavel() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append( classe.getNomeParaVariavel() );
    stringBuffer.append(TEXT_13);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_14);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_15);
    stringBuffer.append( classe.getNomeParaConstante() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( classe.getNomeParaConstante() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append( classe.getNomeParaConstante() );
    stringBuffer.append(TEXT_20);
    
Iterator<TelaAppWrapper> iterador = classe.getListaTelaApp().iterator();
while (iterador.hasNext()) {
	TelaAppWrapper tela = iterador.next();

    stringBuffer.append(TEXT_21);
    stringBuffer.append( tela.getMetodoCarga() );
    stringBuffer.append(TEXT_22);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append( tela.getMetodoCargaConstante() );
    stringBuffer.append(TEXT_24);
    
}

    stringBuffer.append(TEXT_25);
    
Iterator<TelaAppWrapper> itEdita = classe.getListaTelaPorTipo("EDITA").iterator();
while (itEdita.hasNext()) {
	TelaAppWrapper tela = itEdita.next();

    stringBuffer.append(TEXT_26);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_27);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_28);
    stringBuffer.append( classe.getNomeParaClasse() );
    stringBuffer.append(TEXT_29);
    stringBuffer.append( classe.getNomeModeloServer() );
    stringBuffer.append(TEXT_30);
    stringBuffer.append( tela.getNome() );
    stringBuffer.append(TEXT_31);
    
}

    stringBuffer.append(TEXT_32);
    return stringBuffer.toString();
  }
}
