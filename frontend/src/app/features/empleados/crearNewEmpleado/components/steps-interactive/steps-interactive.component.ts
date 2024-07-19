import { Component, EventEmitter, Input, Output, signal } from '@angular/core';
import { Domicilio, Escolaridad, Persona, Registros } from 'src/app/generate/openapi';
import { DatosEmpleado } from 'src/app/interfaces/public.interface';

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

  @Input()
  public activeIndex = signal(0);

  // * Datos que se pasan a los componentes hijos para que puedan ser utilizados, estos datos son elegidos por el usuario
  @Input()
  public generos = signal<Registros[] | undefined>(undefined); // Para el formulario de persona
  @Input()
  public estadosCiviles = signal<Registros[] | undefined>(undefined); // Para el formulario de persona
  @Input()
  public nivelesEscolaridades = signal<Registros[] | undefined>(undefined); // Para el formulario de escolaridad
  @Input()
  public estadosNivelesEscolaridades = signal<Registros[] | undefined>(undefined); // Para el formulario de escolaridad
  @Input()
  public tiposPlazas = signal<Registros[] | undefined>(undefined); // Para el formulario de empleado
  @Input()
  public roles = signal<Registros[] | undefined>(undefined); // Para el formulario de empleado

  // * Datos que se pasan a los componentes hijos para que puedan ser utilizados
  @Input()
  public formPersona = signal<Persona | undefined>(undefined);

  // * Eventos que emiten los componentes hijos
  @Output()
  public emmitFormPersonaValues = new EventEmitter<Persona>();
  @Output()
  public formularioDomicilioNuevaPersona = new EventEmitter<Domicilio>();
  @Output()
  public formularioEscolaridades = new EventEmitter<Escolaridad[]>();
  @Output()
  public formularioDatosEmpleado = new EventEmitter<DatosEmpleado>();
  @Output()
  public confirmacionNuevoEmpleado = new EventEmitter<boolean>();

  onActiveIndexChange(event: number) {
    this.activeIndex.set(event);
  }

  emmitFormPersona(event: Persona) {
    this.emmitFormPersonaValues.emit(event);
  }

  emitirFormularioDomicilioNuevaPersona(event: Domicilio) {
    this.formularioDomicilioNuevaPersona.emit(event);
  }
}
