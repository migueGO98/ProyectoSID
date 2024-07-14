import { Component, signal } from '@angular/core';

@Component({
  selector: 'app-steps-interactive',
  templateUrl: './steps-interactive.component.html',
  styleUrls: ['./steps-interactive.component.sass'],
})
export class StepsInteractiveComponent {
  public items = signal([
    { label: 'Datos Generales' },
    { label: 'Domicilio' },
    { label: 'Escolaridad' },
    { label: 'Empleado' },
    { label: 'Confirmacion' },
  ]);
  public activeIndex = signal(0);

  onActiveIndexChange(event: number) {
    this.activeIndex.set(event);
  }
}
