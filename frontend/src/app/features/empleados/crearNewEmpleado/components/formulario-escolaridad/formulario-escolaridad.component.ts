import { Component, EventEmitter, inject, Input, Output, signal } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Registros } from 'src/app/generate/openapi';

@Component({
  selector: 'app-formulario-escolaridad',
  templateUrl: './formulario-escolaridad.component.html',
  styleUrls: ['./formulario-escolaridad.component.sass'],
})
export class FormularioEscolaridadComponent {
  private fb = inject(FormBuilder);

  @Output()
  formSubmit = new EventEmitter<void>();

  // * Datos que recibimos de NewEmpleadoPageComponent->StepsInteractiveComponent para poder utilizarlos en este componente
  @Input()
  public nivelesEscolaridades = signal<Registros[] | undefined>(undefined);
  @Input()
  public estadosNivelesEscolaridades = signal<Registros[] | undefined>(undefined);

  public formEscolaridad: FormGroup = this.fb.group({
    nivel: new FormControl<Registros | null>(null, [Validators.required]),
    carrera: [null, [Validators.required]],
    estadoNivel: new FormControl<Registros | null>(null, [Validators.required]),
    cedulaProfesional: [
      null,
      [Validators.minLength(7), Validators.maxLength(8), Validators.pattern('^[0-9]+$')],
    ],
  });

  isValidField(field: string) {
    return (
      this.formEscolaridad.controls[field].errors && this.formEscolaridad.controls[field].touched
    );
  }

  getErrorMessage(field: string) {
    if (!this.formEscolaridad.controls[field]) return; // Si no existe el campo en el formulario, no se muestra mensaje de error
    const errors = this.formEscolaridad.controls[field].errors || {}; // Si no hay errores, se asigna un objeto vacío

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
          return `Se requiere un tamaño mínimo de ${errors[key].requiredLength} caracteres`;
        case 'maxlength':
          return `Se requiere un tamaño máximo de ${errors[key].requiredLength} caracteres`;
      }
    }
    return; // Si no hay errores, no se muestra mensaje de error
  }

  onSubmit() {
    if (this.formEscolaridad.valid) this.formSubmit.emit();
    else this.formEscolaridad.markAllAsTouched();
  }
}
