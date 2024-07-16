import { Component, inject, OnInit, signal } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

import { Estado } from 'src/app/interfaces/public.interface';

@Component({
  selector: 'app-formulario-domicilio',
  templateUrl: './formulario-domicilio.component.html',
  styleUrls: ['./formulario-domicilio.component.sass'],
})
export class FormularioDomicilioComponent implements OnInit {
  private fb = inject(FormBuilder);

  public estados = signal<Estado[] | undefined>(undefined);

  ngOnInit(): void {
    this.estados.set([
      { name: 'Aguascalientes', code: 'AGS' },
      { name: 'Baja California', code: 'BC' },
      { name: 'Baja California Sur', code: 'BCS' },
      { name: 'Campeche', code: 'CAMP' },
      { name: 'Chiapas', code: 'CHIS' },
      { name: 'Chihuahua', code: 'CHIH' },
      { name: 'Ciudad de México', code: 'CDMX' },
      { name: 'Coahuila', code: 'COAH' },
      { name: 'Colima', code: 'COL' },
      { name: 'Durango', code: 'DGO' },
      { name: 'Estado de México', code: 'MEX' },
      { name: 'Guanajuato', code: 'GTO' },
      { name: 'Guerrero', code: 'GRO' },
      { name: 'Hidalgo', code: 'HGO' },
      { name: 'Jalisco', code: 'JAL' },
      { name: 'Michoacán', code: 'MICH' },
      { name: 'Morelos', code: 'MOR' },
      { name: 'Nayarit', code: 'NAY' },
      { name: 'Nuevo León', code: 'NL' },
      { name: 'Oaxaca', code: 'OAX' },
      { name: 'Puebla', code: 'PUE' },
      { name: 'Querétaro', code: 'QRO' },
      { name: 'Quintana Roo', code: 'QROO' },
      { name: 'San Luis Potosí', code: 'SLP' },
      { name: 'Sinaloa', code: 'SIN' },
      { name: 'Sonora', code: 'SON' },
      { name: 'Tabasco', code: 'TAB' },
      { name: 'Tamaulipas', code: 'TAMPS' },
      { name: 'Tlaxcala', code: 'TLAX' },
      { name: 'Veracruz', code: 'VER' },
      { name: 'Yucatán', code: 'YUC' },
      { name: 'Zacatecas', code: 'ZAC' },
    ]);
  }

  public formDomicilio: FormGroup = this.fb.group({
    calle: ['', [Validators.required]],
    codigoPostal: ['', [Validators.required]],
    colonia: ['', [Validators.required]],
    municipio: ['', [Validators.required]],
    ciudad: ['', [Validators.required]],
    estado: [new FormControl<Estado | null>(null), [Validators.required]],
  });

  onSave() {
    console.log(this.formDomicilio.value);
  }
}
