import { Component, EventEmitter, Input, Output, signal } from '@angular/core';
import { Registros } from 'src/app/generate/openapi';

@Component({
  selector: 'app-formulario-escolaridad',
  templateUrl: './formulario-escolaridad.component.html',
  styleUrls: ['./formulario-escolaridad.component.sass'],
})
export class FormularioEscolaridadComponent {
  @Input()
  public nivelesEscolaridades = signal<Registros[] | undefined>(undefined);
  @Input()
  public estadosNivelesEscolaridades = signal<Registros[] | undefined>(undefined);

  @Output()
  public activeIndex = new EventEmitter<number>();

  nextStep() {
    this.activeIndex.emit(3);
  }

  previousStep() {
    this.activeIndex.emit(1);
  }
}
