import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-confirmacion-new-empleado',
  templateUrl: './confirmacion-new-empleado.component.html',
  styleUrls: ['./confirmacion-new-empleado.component.sass'],
})
export class ConfirmacionNewEmpleadoComponent {
  @Output()
  confirmarNewEmpleado = new EventEmitter<void>();

  confirmarNuevoEmpleado() {
    this.confirmarNewEmpleado.emit();
  }
}
