import { Component, EventEmitter, inject, Input, OnInit, Output, signal } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Direccion, Puesto, Region, Registros, Rol, Subdireccion } from 'src/app/generate/openapi';

@Component({
  selector: 'app-formulario-empleado',
  templateUrl: './formulario-empleado.component.html',
  styleUrls: ['./formulario-empleado.component.sass'],
})
export class FormularioEmpleadoComponent implements OnInit {
  private fb = inject(FormBuilder);

  @Output()
  formSubmit = new EventEmitter<void>();

  // * Datos que recibimos de NewEmpleadoPageComponent->StepsInteractiveComponent para poder utilizarlos en este componente
  @Input()
  public tiposPlazas = signal<Registros[] | undefined>(undefined);
  @Input()
  public puestos = signal<Puesto[] | undefined>(undefined);
  @Input()
  public regiones = signal<Region[] | undefined>(undefined);
  @Input()
  public direcciones = signal<Direccion[] | undefined>(undefined);
  @Input()
  public subdirecciones = signal<Subdireccion[] | undefined>(undefined);
  @Input()
  public roles = signal<Rol[] | undefined>(undefined);

  minDate!: Date;
  maxDate!: Date;
  disabledDates: Date[] = [];

  public formEmpleado: FormGroup = this.fb.group({
    fechaIngreso: new FormControl<Date | null>(null, [Validators.required]),
    correoElectronicoInstitucional: [null, [Validators.required, Validators.email]],
    idTipoPlaza: new FormControl<Registros | null>(null, [Validators.required]),
    idRegion: new FormControl<Registros | null>(null, [Validators.required]),
    idDireccion: new FormControl<Registros | null>(null, [Validators.required]),
    idSubdireccion: new FormControl<Registros | null>(null, [Validators.required]),
    idPuesto: new FormControl<Registros | null>(null, [Validators.required]),
    idRoles: new FormControl<Rol | null>(null, [Validators.required]),
  });

  ngOnInit() {
    const today = new Date();

    this.minDate = new Date();
    this.minDate.setMonth(today.getMonth() - 1);

    this.maxDate = new Date();
    this.maxDate.setMonth(today.getMonth() + 1);

    this.generateDisabledDates();
  }

  generateDisabledDates() {
    const currentDate = new Date(this.minDate);
    while (currentDate <= this.maxDate) {
      const day = currentDate.getDate();
      if (day !== 1 && day !== 16) {
        this.disabledDates.push(new Date(currentDate));
      }
      currentDate.setDate(currentDate.getDate() + 1);
    }
  }

  isValidField(field: string) {
    return this.formEmpleado.controls[field].errors && this.formEmpleado.controls[field].touched;
  }

  getErrorMessage(field: string) {
    if (!this.formEmpleado.controls[field]) return; // Si no existe el campo en el formulario, no se muestra mensaje de error
    const errors = this.formEmpleado.controls[field].errors || {}; // Si no hay errores, se asigna un objeto vacío

    // Se recorren los errores
    for (const key of Object.keys(errors)) {
      switch (key) {
        case 'required':
          return 'Este campo es requerido';
        case 'email':
          return 'Correo electrónico inválido';
      }
    }
    return; // Si no hay errores, no se muestra mensaje de error
  }

  onSubmit() {
    console.log(this.formEmpleado.value);

    if (this.formEmpleado.valid) this.formSubmit.emit();
    else this.formEmpleado.markAllAsTouched();
  }
}
