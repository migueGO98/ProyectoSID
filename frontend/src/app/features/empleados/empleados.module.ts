import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { CalendarModule } from 'primeng/calendar';
import { InputTextModule } from 'primeng/inputtext';
import { DropdownModule } from 'primeng/dropdown';
import { InputMaskModule } from 'primeng/inputmask';
import { RadioButtonModule } from 'primeng/radiobutton';
import { StepsModule } from 'primeng/steps';
import { ToastModule } from 'primeng/toast';

import { NewEmpleadoPageComponent } from './crearNewEmpleado/pages/new-empleado-page/new-empleado-page.component';
import { FormularioPersonaComponent } from './crearNewEmpleado/components/formulario-persona/formulario-persona.component';
import { FormularioDomicilioComponent } from './crearNewEmpleado/components/formulario-domicilio/formulario-domicilio.component';
import { FormularioEscolaridadComponent } from './crearNewEmpleado/components/formulario-escolaridad/formulario-escolaridad.component';
import { FormularioEmpleadoComponent } from './crearNewEmpleado/components/formulario-empleado/formulario-empleado.component';
import { StepsInteractiveComponent } from './crearNewEmpleado/components/steps-interactive/steps-interactive.component';
import { ConfirmacionNewEmpleadoComponent } from './crearNewEmpleado/components/confirmacion-new-empleado/confirmacion-new-empleado.component';

@NgModule({
  declarations: [
    ConfirmacionNewEmpleadoComponent,
    FormularioDomicilioComponent,
    FormularioEmpleadoComponent,
    FormularioEscolaridadComponent,
    FormularioPersonaComponent,
    NewEmpleadoPageComponent,
    StepsInteractiveComponent,
  ],
  imports: [
    CalendarModule,
    CommonModule,
    DropdownModule,
    FormsModule,
    InputMaskModule,
    InputTextModule,
    RadioButtonModule,
    ReactiveFormsModule,
    StepsModule,
    ToastModule,
  ],
  exports: [NewEmpleadoPageComponent],
})
export class EmpleadosModule {}
