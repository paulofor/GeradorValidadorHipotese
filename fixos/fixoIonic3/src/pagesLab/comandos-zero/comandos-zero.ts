import { IonicPage } from "ionic-angular";
import { Component } from "@angular/core";
import { ComandosZeroPageBase } from "./comandos-zero-base";


/**
 * Generated class for the GeradorDigicom
 *
 */

@IonicPage()
@Component({
  selector: 'page-comandos-zero',
  templateUrl: 'comandos-zero.html',
})
export class ComandosZeroPage extends ComandosZeroPageBase {





  protected getNomeAplicacao(): string {
    return "Treino 365";
  }


  executaConsulta() {
    console.log('ExecutaConsulta');
  }
  existeConsulta() {
    return false;
  }

  executaDiaTreino() {
    console.log('executaDiaTreino');
  }
  existeDiaTreino() {
    return false;
  }

  executaSerie() {
    console.log('executaSerie');
  }
  existeSerie() {
    return false;
  }




}
