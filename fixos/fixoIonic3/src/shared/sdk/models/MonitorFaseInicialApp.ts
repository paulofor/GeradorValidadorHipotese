
/* tslint:disable */

declare var Object: any;
export interface MonitorFaseInicialAppInterface {
  "descricao"?: string;
  "dataHora"?: Date;
  "objeto"?: string;
  "id"?: number;
}

export class MonitorFaseInicialApp implements MonitorFaseInicialAppInterface {
  "descricao": string;
  "dataHora": Date;
  "objeto": string;
  "id": number;
  constructor(data?: MonitorFaseInicialAppInterface) {
    Object.assign(this, data);
  }
  /**
   * The name of the model represented by this $resource,
   * i.e. `MonitorFaseInicialApp`.
   */
  public static getModelName() {
    return "MonitorFaseInicialApp";
  }
  /**
  * @method factory
  * @author Jonathan Casarrubias
  * @license MIT
  * This method creates an instance of MonitorFaseInicialApp for dynamic purposes.
  **/
  public static factory(data: MonitorFaseInicialAppInterface): MonitorFaseInicialApp{
    return new MonitorFaseInicialApp(data);
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
      name: 'MonitorFaseInicialApp',
      plural: 'MonitorFaseInicialApps',
      path: 'MonitorFaseInicialApps',
      idName: 'id',
      properties: {
        "descricao": {
          name: 'descricao',
          type: 'string'
        },
        "dataHora": {
          name: 'dataHora',
          type: 'Date'
        },
        "objeto": {
          name: 'objeto',
          type: 'string'
        },
        "id": {
          name: 'id',
          type: 'number'
        },
      },
      relations: {
      }
    }
  }
}

