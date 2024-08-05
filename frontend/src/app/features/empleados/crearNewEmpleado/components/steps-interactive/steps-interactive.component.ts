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
import { FormGroup } from '@angular/forms';
import {
  Domicilio,
  Escolaridad,
  NewEmpleado,
  Persona,
  Region,
  Registros,
  Rol,
} from 'src/app/generate/openapi';
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
  @Input()
  public regiones = signal<Region[] | undefined>(undefined); // Para el formulario de empleado

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

  goToPreviousStep() {
    this.stepper.previous();
  }

  crearNuevoEmpleado() {
    const persona = this.recuperarPersona();
    const domicilio = this.recuperarDomicilio();
    const escolaridad = this.recuperarEscolaridad();
    const empleado = this.formEmpleado.value;
    const nuevoEmpleado: NewEmpleado = {
      persona,
      domicilio,
      escolaridades: [escolaridad],
      fechaIngreso: empleado.fechaIngreso,
      correoElectronicoInstitucional: empleado.correoElectronicoInstitucional,
      idTipoPlaza: empleado.idTipoPlaza,
      idRegion: empleado.idRegion,
      idDireccion: empleado.idDireccion,
      idSubdireccion: empleado.idSubdireccion,
      idPuesto: empleado.idPuesto,
      idRoles: empleado.idRoles,
    };
    console.log('El nuevo empleado es: ', nuevoEmpleado);
    this.nuevoEmpleado.emit(nuevoEmpleado);
  }

  private recuperarPersona(): Persona {
    const persona = this.formPersona.value;
    return {
      nombre: persona.nombre,
      apellidoPaterno: persona.apellidoPaterno,
      apellidoMaterno: persona.apellidoMaterno,
      curp: persona.curp,
      rfc: persona.rfc,
      numeroSeguroSocial: persona.numeroSeguroSocial,
      fechaNacimiento: persona.fechaNacimiento,
      genero: persona.genero,
      telefonoPersonal: persona.telefonoPersonal,
      correoElectronicoPersonal: persona.correoElectronicoPersonal,
      estadoCivil: persona.estadoCivil,
      hijos: persona.hijos,
      contactoEmergenciaNombre: persona.contactoEmergenciaNombre,
      contactoEmergenciaTelefono: persona.contactoEmergenciaTelefono,
    };
  }

  private recuperarDomicilio(): Domicilio {
    const domicilio = this.formDomicilio.value;
    return {
      calle: domicilio.calle,
      codigoPostal: domicilio.codigoPostal,
      colonia: domicilio.colonia,
      municipio: domicilio.municipio,
      ciudad: domicilio.ciudad,
      estado: domicilio.estado,
    };
  }

  private recuperarEscolaridad(): Escolaridad {
    const escolaridad = this.formEscolaridad.value;
    return {
      nivel: escolaridad.nivel,
      carrera: escolaridad.carrera,
      estadoNivel: escolaridad.estadoNivel,
      cedulaProfesional: escolaridad.cedulaProfesional,
    };
  }
}
