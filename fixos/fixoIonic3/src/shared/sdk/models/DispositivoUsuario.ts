/* tslint:disable */
import {
} from '../index';

declare var Object: any;
export interface DispositivoUsuarioInterface {
  "tokenFcm"?: string;
  "dataHoraCriacao"?: Date;
  "id"?: number;
  "dataUltimoAcesso"?: Date;
  "dataChamada"?: Date;
  "temMudanca"?: number;
  "ativo"?: number;
  "codigoDispositivo"? : number;
  "microSd"? : number
  "campanhaAdsId"? : number
}

export class DispositivoUsuario implements DispositivoUsuarioInterface {
  "tokenFcm": string;
  "dataHoraCriacao": Date;
  "id": number;
  "dataUltimoAcesso": Date;
  "dataChamada": Date;
  "temMudanca": number;
  "ativo": number;
  "codigoDispositivo" : number;
  "microSd" : number;
  constructor(data?: DispositivoUsuarioInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `DispositivoUsuario`.
   */
  public static getModelName() {
    return "DispositivoUsuario";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of Visitante for dynamic purposes.
  **/
  public static factory(data: DispositivoUsuarioInterface): DispositivoUsuario{
    return new DispositivoUsuario(data);
  }
  /**
  * @method getModelDefinition
  * @author Julien Ledun
  * @license MIT
  * This method returns an object that represents some of the model
  * definitions.
  **/
  public static getModelDefinition() {
    return {
      name: 'DispositivoUsuario',
      plural: 'DispositivoUsuarios',
      path: 'DispositivoUsuarios',
      idName: 'id',
      properties: {
        "tokenFcm": {
          name: 'tokenFcm',
          type: 'string'
        },
        "dataHoraCriacao": {
          name: 'dataHoraCriacao',
          type: 'Date'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
        "dataUltimoAcesso": {
          name: 'dataUltimoAcesso',
          type: 'Date'
        },
        "dataChamada": {
          name: 'dataChamada',
          type: 'Date'
        },
        "temMudanca": {
          name: 'temMudanca',
          type: 'number'
        },
        "ativo": {
          name: 'ativo',
          type: 'number'
        },
        "codigoDispositivo": {
          name: 'codigoDispositivo',
          type: 'string'
        },
        "microSd": {
          name: 'microSd',
          type: 'number'
        },
        "campanhaAdsId": {
          name: 'campanhaAdsId',
          type: 'number'
        },
      },
      relations: {
      }
    }
  }
}
