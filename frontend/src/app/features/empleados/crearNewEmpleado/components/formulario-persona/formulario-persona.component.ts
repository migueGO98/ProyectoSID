import {
  Component,
  EventEmitter,
  Input,
  OnChanges,
  Output,
  SimpleChanges,
  inject,
  signal,
} from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Persona, Registros } from 'src/app/generate/openapi';

@Component({
  selector: 'app-formulario-persona',
  templateUrl: './formulario-persona.component.html',
  styleUrls: ['./formulario-persona.component.sass'],
})
export class FormularioPersonaComponent implements OnChanges {
  private fb = inject(FormBuilder);

  // * Datos que recibimos de NewEmpleadoPageComponent->StepsInteractiveComponent para poder utilizarlos en este componente
  @Input()
  public generos = signal<Registros[] | undefined>(undefined);
  @Input()
  public estadosCiviles = signal<Registros[] | undefined>(undefined);

  @Output() // * Evento para cambiar de paso en el stepper desde el componente
  public activeIndex = new EventEmitter<number>();

  @Input() // * Comunicacion bidireccional con el componente StepsInteractiveComponent
  public inputFormPersona = signal<Persona | undefined>(undefined);
  @Output()
  public emmitFormPersona = new EventEmitter<Persona>();

  // * Sirve para volver a llenar el formulario en caso de que se haya cambiado de paso y se regrese
  ngOnChanges(changes: SimpleChanges): void {
    if (changes['inputFormPersona'] && this.inputFormPersona()) {
      this.formPersona.value(this.inputFormPersona());
    }
  }

  public formPersona: FormGroup = this.fb.group({
    nombre: [null, [Validators.required]],
    apellidoPaterno: [null, [Validators.required]],
    apellidoMaterno: [null],
    curp: [null, [Validators.required]],
    rfc: [null, [Validators.required]],
    numeroSeguroSocial: [null, [Validators.required, Validators.pattern('^[0-9]+$')]],
    fechaNacimiento: new FormControl<Date | null>(null, [Validators.required]),
    genero: new FormControl<Registros | null>(null, [Validators.required]),
    telefonoPersonal: [null, [Validators.required]],
    correoElectronicoPersonal: [null, [Validators.required, Validators.email]],
    estadoCivil: new FormControl<Registros | null>(null, [Validators.required]),
    hijos: new FormControl(null, [Validators.required]),
    contactoEmergenciaNombre: [null, [Validators.required]],
    contactoEmergenciaTelefono: [null, [Validators.required]],
  });

  onSaveDatosPersona() {
    //if (this.formularioPersona.invalid) return;

    const formValues = this.formPersona.value;

    this.emmitFormPersona.emit({
      nombre: formValues.nombre,
      apellidoPaterno: formValues.apellidoPaterno,
      apellidoMaterno: formValues.apellidoMaterno,
      curp: formValues.curp,
      rfc: formValues.rfc,
      numeroSeguroSocial: formValues.numeroSeguroSocial,
      fechaNacimiento: formValues.fechaNacimiento,
      genero: formValues.genero,
      telefonoPersonal: formValues.telefonoPersonal,
      correoElectronicoPersonal: formValues.correoElectronicoPersonal,
      estadoCivil: formValues.estadoCivil,
      hijos: formValues.hijos,
      contactoEmergenciaNombre: formValues.contactoEmergenciaNombre,
      contactoEmergenciaTelefono: formValues.contactoEmergenciaTelefono,
    });

    this.nextStep();
  }

  nextStep() {
    this.activeIndex.emit(1);
  }
}
