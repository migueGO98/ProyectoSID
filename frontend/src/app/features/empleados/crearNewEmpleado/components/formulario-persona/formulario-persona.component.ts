import { DatePipe } from '@angular/common';
import { Component, EventEmitter, OnInit, Output, inject, signal } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Persona, Registros } from 'src/app/generate/openapi';

@Component({
  selector: 'app-formulario-persona',
  templateUrl: './formulario-persona.component.html',
  styleUrls: ['./formulario-persona.component.sass'],
})
export class FormularioPersonaComponent implements OnInit {
  private datePipe = inject(DatePipe);
  private fb = inject(FormBuilder);

  public generos = signal<Registros[] | undefined>(undefined);
  public estadosCiviles = signal<Registros[] | undefined>(undefined);

  @Output()
  public personaForm = new EventEmitter<Persona>();

  ngOnInit(): void {
    this.generos.set([
      {
        id: 'MASCULINO',
        descripcion: 'Masculino',
      },
      {
        id: 'FEMENINO',
        descripcion: 'Femenino',
      },
    ]);

    this.estadosCiviles.set([
      {
        id: 'CASADO',
        descripcion: 'Casado',
      },
      {
        id: 'CASADA',
        descripcion: 'Casada',
      },
    ]);
  }

  public formularioPersona: FormGroup = this.fb.group({
    nombre: ['Migue', [Validators.required]],
    apellidoPaterno: ['G', [Validators.required]],
    apellidoMaterno: ['O'],
    curp: ['ASDF585858ASDFRT11', [Validators.required]],
    rfc: ['ASDF585858ASD', [Validators.required]],
    numeroSeguroSocial: ['12345678998', [Validators.required, Validators.pattern('^[0-9]+$')]],
    fechaNacimiento: new FormControl<Date | null>(null, [Validators.required]),
    genero: new FormControl<Registros | null>(null, [Validators.required]),
    telefonoPersonal: ['5512345678', [Validators.required]],
    correoElectronicoPersonal: ['m@m.com', [Validators.required, Validators.email]],
    estadoCivil: new FormControl<Registros | null>(null, [Validators.required]),
    hijos: new FormControl('true', [Validators.required]),
    contactoEmergenciaNombre: ['Catalina', [Validators.required]],
    contactoEmergenciaTelefono: ['5569696969', [Validators.required]],
  });

  onSaveDatosPersona() {
    //if (this.formularioPersona.invalid) return;

    const formValues = this.formularioPersona.value;

    const fechaNacimientoFormateada = this.datePipe.transform(
      formValues.fechaNacimiento,
      'yyyy-MM-dd'
    );
    if (fechaNacimientoFormateada === null) return;

    this.personaForm.emit({
      nombre: formValues.nombre,
      apellidoPaterno: formValues.apellidoPaterno,
      apellidoMaterno: formValues.apellidoMaterno,
      curp: formValues.curp,
      rfc: formValues.rfc,
      numeroSeguroSocial: formValues.numeroSeguroSocial,
      fechaNacimiento: fechaNacimientoFormateada,
      genero: formValues.genero,
      telefonoPersonal: formValues.telefonoPersonal,
      correoElectronicoPersonal: formValues.correoElectronicoPersonal,
      estadoCivil: formValues.estadoCivil,
      hijos: formValues.hijos,
      contactoEmergenciaNombre: formValues.contactoEmergenciaNombre,
      contactoEmergenciaTelefono: formValues.contactoEmergenciaTelefono,
    });
  }
}
