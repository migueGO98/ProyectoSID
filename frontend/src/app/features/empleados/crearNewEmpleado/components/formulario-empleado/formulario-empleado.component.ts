import { Component, EventEmitter, Input, Output, signal } from '@angular/core';
import { Registros } from 'src/app/generate/openapi';

@Component({
  selector: 'app-formulario-empleado',
  templateUrl: './formulario-empleado.component.html',
  styleUrls: ['./formulario-empleado.component.sass'],
})
export class FormularioEmpleadoComponent {
  @Input()
  public tiposPlazas = signal<Registros[] | undefined>(undefined);
  @Input()
  public roles = signal<Registros[] | undefined>(undefined);

  @Output()
  public activeIndex = new EventEmitter<number>();

  nextStep() {
    this.activeIndex.emit(4);
  }

  previousStep() {
    this.activeIndex.emit(2);
  }
}
