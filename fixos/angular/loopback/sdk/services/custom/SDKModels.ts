/* tslint:disable */
import { Injectable } from '@angular/core';
import { User } from '../../models/User';
import { Projeto } from '../../models/Projeto';
import { ProjetoCanvas } from '../../models/ProjetoCanvas';
import { ProjetoMySql } from '../../models/ProjetoMySql';
import { ProjetoCanvasMySql } from '../../models/ProjetoCanvasMySql';
import { MvpCanvasMySql } from '../../models/MvpCanvasMySql';
import { GanhoDorCanvasMySql } from '../../models/GanhoDorCanvasMySql';
import { PaginaValidacaoWeb } from '../../models/PaginaValidacaoWeb';
import { ItemValidacaoPagina } from '../../models/ItemValidacaoPagina';
import { RegistroInteresse } from '../../models/RegistroInteresse';
import { ProjetoExemplo } from '../../models/ProjetoExemplo';
import { Receita } from '../../models/Receita';
import { Container } from '../../models/Container';
import { Visitante } from '../../models/Visitante';
import { AnuncioAds } from '../../models/AnuncioAds';
import { CampanhaAds } from '../../models/CampanhaAds';
import { PalavraChaveAds } from '../../models/PalavraChaveAds';
import { Aplicacao } from '../../models/Aplicacao';
import { Atributo_entidade } from '../../models/Atributo_entidade';
import { Entidade } from '../../models/Entidade';
import { ModeloCampanhaAds } from '../../models/ModeloCampanhaAds';
import { Relacionamento_entidade } from '../../models/Relacionamento_entidade';

export interface Models { [name: string]: any }

@Injectable()
export class SDKModels {

  private models: Models = {
    User: User,
    Projeto: Projeto,
    ProjetoCanvas: ProjetoCanvas,
    ProjetoMySql: ProjetoMySql,
    ProjetoCanvasMySql: ProjetoCanvasMySql,
    MvpCanvasMySql: MvpCanvasMySql,
    GanhoDorCanvasMySql: GanhoDorCanvasMySql,
    PaginaValidacaoWeb: PaginaValidacaoWeb,
    ItemValidacaoPagina: ItemValidacaoPagina,
    RegistroInteresse: RegistroInteresse,
    ProjetoExemplo: ProjetoExemplo,
    Receita: Receita,
    Container: Container,
    Visitante: Visitante,
    AnuncioAds: AnuncioAds,
    CampanhaAds: CampanhaAds,
    PalavraChaveAds: PalavraChaveAds,
    Aplicacao: Aplicacao,
    Atributo_entidade: Atributo_entidade,
    Entidade: Entidade,
    ModeloCampanhaAds: ModeloCampanhaAds,
    Relacionamento_entidade: Relacionamento_entidade,
    
  };

  public get(modelName: string): any {
    return this.models[modelName];
  }

  public getAll(): Models {
    return this.models;
  }

  public getModelNames(): string[] {
    return Object.keys(this.models);
  }
}
