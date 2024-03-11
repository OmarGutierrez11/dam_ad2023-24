import { Component } from '@angular/core';
import { Location } from '@angular/common';
@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent {
  enviando: boolean;
  mensaje: string;
  detalles!: string;

  constructor(private _location: Location) {
    this.enviando = false;
    this.mensaje = '';
  }

  /** Método que envia el mensaje y vuelve al componente anterior */
  enviarMensaje() {
    this.enviando = true;
    this.detalles = 'Enviando mensaje...';

    setTimeout(() => {
      this.enviando = false;
      this.volverAtras();
    }, 2000);

  }

  /** Método que navega hacia atrás a la página anteriormente visitada */
  volverAtras() {
    this._location.back();
  }

}



