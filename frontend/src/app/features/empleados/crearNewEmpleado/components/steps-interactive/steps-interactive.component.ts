import { Component, signal } from '@angular/core';
import { Persona } from 'src/app/generate/openapi';

@Component({
  selector: 'app-steps-interactive',
  templateUrl: './steps-interactive.component.html',
  styleUrls: ['./steps-interactive.component.sass'],
})
export class StepsInteractiveComponent {
  public persona = signal<Persona | undefined>(undefined);

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

  actualizarValoresPersona(event: Persona) {
    this.persona.set(event);
    console.log('Persona desde componente Stp', this.persona());
  }
}
