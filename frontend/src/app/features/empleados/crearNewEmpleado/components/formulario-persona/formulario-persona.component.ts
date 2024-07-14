import { Component, OnInit, inject, signal } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Registros } from 'src/app/generate/openapi';

@Component({
  selector: 'app-formulario-persona',
  templateUrl: './formulario-persona.component.html',
  styleUrls: ['./formulario-persona.component.sass'],
})
export class FormularioPersonaComponent implements OnInit {
  private fb = inject(FormBuilder);
  public generos = signal<Registros[] | undefined>(undefined);
  public estadosCiviles = signal<Registros[] | undefined>(undefined);

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

  public myForm: FormGroup = this.fb.group({
    nombre: ['', [Validators.required]],
    apellidoPaterno: ['', [Validators.required]],
    apellidoMaterno: [''],
    curp: ['', [Validators.required]],
    rfc: ['', [Validators.required]],
    numeroSeguroSocial: ['', [Validators.required, Validators.pattern('^[0-9]+$')]],
    fechaNacimiento: [new FormControl<Date | null>(null), [Validators.required]],
    genero: [new FormControl<Registros | null>(null), [Validators.required]],
    telefonoPersonal: ['', [Validators.required]],
    correoElectronicoPersonal: ['', [Validators.required, Validators.email]],
    estadoCivil: [new FormControl<Registros | null>(null), [Validators.required]],
    hijos: new FormControl(),
    contactoEmergenciaNombre: ['', [Validators.required]],
    contactoEmergenciaTelefono: ['', [Validators.required]],
  });

  onSave() {
    console.log(this.myForm.value);
  }
}
