import { Component, EventEmitter, Input, Output, inject, signal } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Registros } from 'src/app/generate/openapi';

@Component({
  selector: 'app-formulario-persona',
  templateUrl: './formulario-persona.component.html',
  styleUrls: ['./formulario-persona.component.sass'],
})
export class FormularioPersonaComponent {
  private fb = inject(FormBuilder);

  @Output()
  formSubmit = new EventEmitter<void>();

  // * Datos que recibimos de NewEmpleadoPageComponent->StepsInteractiveComponent para poder utilizarlos en este componente
  @Input()
  public generos = signal<Registros[] | undefined>(undefined);
  @Input()
  public estadosCiviles = signal<Registros[] | undefined>(undefined);

  public formPersona: FormGroup = this.fb.group({
    nombre: [null, [Validators.required]],
    apellidoPaterno: [null, [Validators.required]],
    apellidoMaterno: [null],
    curp: [null, [Validators.required, Validators.minLength(18), Validators.maxLength(18)]],
    rfc: [null, [Validators.required, Validators.minLength(11), Validators.maxLength(11)]],
    numeroSeguroSocial: [
      null,
      [
        Validators.required,
        Validators.minLength(11),
        Validators.maxLength(11),
        Validators.pattern('^[0-9]+$'),
      ],
    ],
    fechaNacimiento: new FormControl<Date | null>(null, [Validators.required]),
    genero: new FormControl<Registros | null>(null, [Validators.required]),
    telefonoPersonal: [null, [Validators.required]],
    correoElectronicoPersonal: [null, [Validators.required, Validators.email]],
    estadoCivil: new FormControl<Registros | null>(null, [Validators.required]),
    hijos: new FormControl(null, [Validators.required]),
    contactoEmergenciaNombre: [null, [Validators.required]],
    contactoEmergenciaTelefono: [null, [Validators.required]],
  });

  isValidField(field: string) {
    return this.formPersona.controls[field].errors && this.formPersona.controls[field].touched;
  }

  getErrorMessage(field: string) {
    if (!this.formPersona.controls[field]) return; // Si no existe el campo en el formulario, no se muestra mensaje de error
    const errors = this.formPersona.controls[field].errors || {}; // Si no hay errores, se asigna un objeto vacío

    // Se recorren los errores
    for (const key of Object.keys(errors)) {
      switch (key) {
        case 'required':
          return 'Este campo es requerido';
        case 'email':
          return 'Correo electrónico inválido';
        case 'pattern':
          return 'Solo se permiten números';
        case 'minlength':
          return `Se requiere ${errors[key].requiredLength} caracteres`;
        case 'maxlength':
          return `Se requiere ${errors[key].requiredLength} caracteres`;
      }
    }
    return; // Si no hay errores, no se muestra mensaje de error
  }

  onSubmit() {
    if (this.formPersona.valid) this.formSubmit.emit();
    else this.formPersona.markAllAsTouched();
  }
}
