import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-confirmacion-new-empleado',
  templateUrl: './confirmacion-new-empleado.component.html',
  styleUrls: ['./confirmacion-new-empleado.component.sass'],
})
export class ConfirmacionNewEmpleadoComponent {
  @Output()
  public activeIndex = new EventEmitter<number>();

  previousStep() {
    this.activeIndex.emit(3);
  }
}
