import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { CalendarModule } from 'primeng/calendar';
import { InputTextModule } from 'primeng/inputtext';
import { DropdownModule } from 'primeng/dropdown';
import { InputMaskModule } from 'primeng/inputmask';
import { RadioButtonModule } from 'primeng/radiobutton';

import { FormularioComponent } from './components/formulario/formulario.component';
import { NewEmpleadoPageComponent } from './pages/new-empleado-page/new-empleado-page.component';

@NgModule({
  declarations: [FormularioComponent, NewEmpleadoPageComponent],
  imports: [
    CalendarModule,
    CommonModule,
    DropdownModule,
    FormsModule,
    InputMaskModule,
    InputTextModule,
    RadioButtonModule,
    ReactiveFormsModule,
  ],
  exports: [NewEmpleadoPageComponent],
})
export class NewEmpleadoModule {}
