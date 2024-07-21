import {
  AfterViewInit,
  ChangeDetectorRef,
  Component,
  EventEmitter,
  inject,
  Input,
  Output,
  signal,
  ViewChild,
} from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Domicilio, Escolaridad, NewEmpleado, Persona, Registros, Rol } from 'src/app/generate/openapi';
import { DatosEmpleado } from 'src/app/interfaces/public.interface';
import { FormularioPersonaComponent } from '../formulario-persona/formulario-persona.component';
import { MatStepper } from '@angular/material/stepper';
import { FormularioDomicilioComponent } from '../formulario-domicilio/formulario-domicilio.component';
import { FormularioEscolaridadComponent } from '../formulario-escolaridad/formulario-escolaridad.component';
import { FormularioEmpleadoComponent } from '../formulario-empleado/formulario-empleado.component';
import { ConfirmacionNewEmpleadoComponent } from '../confirmacion-new-empleado/confirmacion-new-empleado.component';

@Component({
  selector: 'app-steps-interactive',
  templateUrl: './steps-interactive.component.html',
  styleUrls: ['./steps-interactive.component.sass'],
})
export class StepsInteractiveComponent implements AfterViewInit {
  private cdr = inject(ChangeDetectorRef);
  @ViewChild('stepper')
  stepper!: MatStepper;
  @ViewChild('formPersonaComponent')
  formPersonaComponent!: FormularioPersonaComponent;
  @ViewChild('formDomicilioComponent')
  formDomicilioComponent!: FormularioDomicilioComponent;
  @ViewChild('formEscolaridadComponent')
  formEscolaridadComponent!: FormularioEscolaridadComponent;
  @ViewChild('formEmpleadoComponent')
  formEmpleadoComponent!: FormularioEmpleadoComponent;
  @ViewChild('formConfirmacionComponent')
  formConfirmacionComponent!: ConfirmacionNewEmpleadoComponent;

  // * Datos NECESARIOS que utilizan los componente hijos
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
  public roles = signal<Rol[] | undefined>(undefined); // Para el formulario de empleado

  @Output()
  public nuevoEmpleado = new EventEmitter<NewEmpleado>();

  public formPersona!: FormGroup;
  public formDomicilio!: FormGroup;
  public formEscolaridad!: FormGroup;
  public formEmpleado!: FormGroup;

  ngAfterViewInit() {
    this.formPersona = this.formPersonaComponent.formPersona;
    this.formDomicilio = this.formDomicilioComponent.formDomicilio;
    this.formEscolaridad = this.formEscolaridadComponent.formEscolaridad;
    this.formEmpleado = this.formEmpleadoComponent.formEmpleado;
    this.cdr.detectChanges();
  }

  goToNextStep() {
    this.stepper.next();
  }
}
