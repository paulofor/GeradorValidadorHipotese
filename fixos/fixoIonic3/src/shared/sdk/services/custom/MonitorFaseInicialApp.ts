/* tslint:disable */
import { Injectable, Inject, Optional } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { SDKModels } from './SDKModels';
import { BaseLoopBackApi } from '../core/base.service';
import { LoopBackConfig } from '../../lb.config';
import { LoopBackAuth } from '../core/auth.service';
import { LoopBackFilter,  } from '../../models/BaseModels';
import { ErrorHandler } from '../core/error.service';
import { Observable, Subject } from 'rxjs';
import { map } from 'rxjs/operators';
import { MonitorFaseInicialApp } from '../../models/MonitorFaseInicialApp';
import { SocketConnection } from '../../sockets/socket.connections';
import { PathValidador } from '../../../../app/const';
import { get } from '@ionic-native/core';


/**
 * Api services for the `MonitorFaseInicialApp` model.
 */
@Injectable()
export class MonitorFaseInicialAppApi extends BaseLoopBackApi {

  constructor(
    @Inject(HttpClient) protected http: HttpClient,
    @Inject(SocketConnection) protected connection: SocketConnection,
    @Inject(SDKModels) protected models: SDKModels,
    @Inject(LoopBackAuth) protected auth: LoopBackAuth,
    @Optional() @Inject(ErrorHandler) protected errorHandler: ErrorHandler
  ) {
    super(http,  connection,  models, auth, errorHandler);
  }

  /**
   * Patch an existing model instance or insert a new one into the data source.
   *
   * @param {object} data Request data.
   *
   *  - `data` – `{object}` - Model instance data
   *
   * @returns {object} An empty reference that will be
   *   populated with the actual data once the response is returned
   *   from the server.
   *
   * <em>
   * (The remote method definition does not provide any description.
   * This usually means the response is a `MonitorFaseInicialApp` object.)
   * </em>
   */
  public patchOrCreate(data: any = {}, customHeaders?: Function): Observable<any> {
    let _method: string = "PATCH";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/MonitorFaseInicialApps";
    let _routeParams: any = {};
    let _postBody: any = {
      data: data
    };
    let _urlParams: any = {};
    let result = this.request(_method, _url, _routeParams, _urlParams, _postBody, null, customHeaders);
    return result;
  }

  /**
   * Patch attributes for a model instance and persist it into the data source.
   *
   * @param {any} id MonitorFaseInicialApp id
   *
   * @param {object} data Request data.
   *
   *  - `data` – `{object}` - An object of model property name/value pairs
   *
   * @returns {object} An empty reference that will be
   *   populated with the actual data once the response is returned
   *   from the server.
   *
   * <em>
   * (The remote method definition does not provide any description.
   * This usually means the response is a `MonitorFaseInicialApp` object.)
   * </em>
   */
  public patchAttributes(id: any, data: any = {}, customHeaders?: Function): Observable<any> {
    let _method: string = "PATCH";
    let _url: string = LoopBackConfig.getPath() + "/" + LoopBackConfig.getApiVersion() +
    "/MonitorFaseInicialApps/:id";
    let _routeParams: any = {
      id: id
    };
    let _postBody: any = {
      data: data
    };
    let _urlParams: any = {};
    let result = this.request(_method, _url, _routeParams, _urlParams, _postBody, null, customHeaders);
    return result;
  }

  public Insere(IdAplicacao: any = {}, descricao: any = {}, objeto: any = {}, customHeaders?: Function): Observable<any> {
    let _method: string = "PUT";
    let _url: string = PathValidador + "/" + LoopBackConfig.getApiVersion() +
    "/MonitorFaseInicialApps/insere";
    let _routeParams: any = {};
    let _postBody: any = {};
    let _urlParams: any = {};
    if (typeof IdAplicacao !== 'undefined' && IdAplicacao !== null) _urlParams.IdAplicacao = IdAplicacao;
    if (typeof descricao !== 'undefined' && descricao !== null) _urlParams.descricao = descricao;
    if (typeof objeto !== 'undefined' && objeto !== null) _urlParams.objeto = objeto;
    let result = this.request(_method, _url, _routeParams, _urlParams, _postBody, null, customHeaders);
    return result;
  }

  public insere(data: any = {}, customHeaders?: Function): Observable<any> {
    alert('vai inserir');
    let _url = PathValidador + "/" + LoopBackConfig.getApiVersion() +  "/MonitorFaseInicialApps";
    alert('url' + _url);
    let _method = 'PUT';
    let result = this.request(_method, _url, {}, {}, data, null, customHeaders);
    alert('result' + JSON.stringify(result));
    console.log('retorno' , result);
    return result;
  }
 


  /**
   * The name of the model represented by this $resource,
   * i.e. `MonitorFaseInicialApp`.
   */
  public getModelName() {
    return "MonitorFaseInicialApp";
  }
}
