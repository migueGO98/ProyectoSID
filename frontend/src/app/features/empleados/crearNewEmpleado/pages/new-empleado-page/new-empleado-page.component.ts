import { Component, inject, OnDestroy, OnInit, signal } from '@angular/core';
import { Subscription } from 'rxjs';
import {
  Domicilio,
  Empleado,
  EmpleadosService,
  Escolaridad,
  EscolaridadesService,
  NewEmpleado,
  Persona,
  PersonasService,
  Registros,
  Rol,
  RolesService,
  TiposPlazasService,
} from 'src/app/generate/openapi';
import { DatosEmpleado } from 'src/app/interfaces/public.interface';

@Component({
  selector: 'app-new-empleado-page',
  templateUrl: './new-empleado-page.component.html',
  styleUrls: ['./new-empleado-page.component.sass'],
})
export class NewEmpleadoPageComponent implements OnInit, OnDestroy {
  // * Inyección de dependencias y subscripciones a servicios
  private personasService = inject(PersonasService);
  private empleadosService = inject(EmpleadosService);
  private escolaridadesService = inject(EscolaridadesService);
  private tiposPlazasService = inject(TiposPlazasService);
  private rolesService = inject(RolesService);
  public subscripcionGenero$!: Subscription;
  public subscripcionEstadosCiviles$!: Subscription;
  public subscripcionNivelesEscolaridades$!: Subscription;
  public subscripcionEstadosNivelesEscolaridades$!: Subscription;
  public subscripcionTiposPlazas$!: Subscription;
  public subscripcionRoles$!: Subscription;

  // * Signal para pasar datos **NECESARIOS** a los componentes hijos, se solicitan en el ngOnInit
  public generos = signal<Registros[] | undefined>(undefined);
  public estadosCiviles = signal<Registros[] | undefined>(undefined);
  public nivelesEscolaridades = signal<Registros[] | undefined>(undefined);
  public estadosNivelesEscolaridades = signal<Registros[] | undefined>(undefined);
  public tiposPlazas = signal<Registros[] | undefined>(undefined);
  public roles = signal<Rol[] | undefined>(undefined);

  // * Signal necesarias de la página para poder enviar datos a la API
  public nuevoEmpleado = signal<NewEmpleado | undefined>(undefined);
  public formPersona = signal<Persona | undefined>(undefined);
  public formularioDomicilio = signal<Domicilio | undefined>(undefined);
  public formularioEscolaridad = signal<Escolaridad[] | undefined>(undefined);
  public formularioDatosEmpleado = signal<DatosEmpleado | undefined>(undefined); // Esta interfaz solo es del frontend, se hace para no tener que pasar tantos datos a la vez

  // * Respuestas de la API
  public empleado = signal<Empleado | undefined>(undefined);

  ngOnInit(): void {
    this.subscripcionGenero$ = this.personasService.recuperarGeneros().subscribe({
      next: value => this.generos.set(value),
      // eslint-disable-next-line no-console
      error: e => console.error(e.error),
    });

    this.subscripcionEstadosCiviles$ = this.personasService.recuperarEstadosCiviles().subscribe({
      next: value => this.estadosCiviles.set(value),
      // eslint-disable-next-line @typescript-eslint/no-explicit-any, no-console
      error: e => console.error(e.error),
    });

    this.subscripcionNivelesEscolaridades$ = this.escolaridadesService
      .recuperarNivelesEscolares()
      .subscribe({
        next: value => this.nivelesEscolaridades.set(value),
        // eslint-disable-next-line @typescript-eslint/no-explicit-any, no-console
        error: e => console.error(e.error),
      });

    this.subscripcionEstadosNivelesEscolaridades$ = this.escolaridadesService
      .recuperarEstadosNivelesEscolares()
      .subscribe({
        next: value => this.estadosNivelesEscolaridades.set(value),
        // eslint-disable-next-line @typescript-eslint/no-explicit-any, no-console
        error: e => console.error(e.error),
      });

    this.subscripcionTiposPlazas$ = this.tiposPlazasService.recuperarTiposPlazas().subscribe({
      next: value => this.tiposPlazas.set(value),
      // eslint-disable-next-line @typescript-eslint/no-explicit-any, no-console
      error: e => console.error(e.error),
    });

    this.subscripcionRoles$ = this.rolesService.recuperarRoles().subscribe({
      next: value => this.roles.set(value),
      // eslint-disable-next-line @typescript-eslint/no-explicit-any, no-console
      error: e => console.error(e.error),
    });
  }

  obtenerValoresFormularioPersona(event: Persona) {
    this.formPersona.set(event);
  }

  obtenerValoresFormularioDomicilio(event: Domicilio) {
    this.formularioDomicilio.set(event);
  }

  obtenerValoresFormularioEscolaridad(event: Escolaridad[]) {
    this.formularioEscolaridad.set(event);
  }

  obtenerValoresFormularioDatosEmpleado(event: DatosEmpleado) {
    this.formularioDatosEmpleado.set(event);
  }

  crearNuevoEmpleado() {
    const datosEmpleado = this.formularioDatosEmpleado() as DatosEmpleado;
    this.nuevoEmpleado.set({
      persona: this.formPersona() as Persona,
      domicilio: this.formularioDomicilio() as Domicilio,
      escolaridades: this.formularioEscolaridad() as Escolaridad[],
      fechaIngreso: datosEmpleado.fechaIngreso,
      correoElectronicoInstitucional: datosEmpleado.correoElectronicoInstitucional,
      idTipoPlaza: datosEmpleado.idTipoPlaza,
      idRegion: datosEmpleado.idRegion,
      idDireccion: datosEmpleado.idDireccion,
      idSubdireccion: datosEmpleado.idSubdireccion,
      idPuesto: datosEmpleado.idPuesto,
      idRoles: datosEmpleado.idRoles,
    });

    this.empleadosService.crearEmpleado(this.nuevoEmpleado() as NewEmpleado).subscribe({
      next: empleadoResponse => this.empleado.set(empleadoResponse),
      // eslint-disable-next-line @typescript-eslint/no-explicit-any, no-console
      error: e => console.error(e.error),
    });
  }

  // Unsubscribe para evitar fugas de memoria en las subscripciones a observables
  ngOnDestroy(): void {
    this.subscripcionGenero$.unsubscribe();
    this.subscripcionEstadosCiviles$.unsubscribe();
    this.subscripcionNivelesEscolaridades$.unsubscribe();
    this.subscripcionEstadosNivelesEscolaridades$.unsubscribe();
    this.subscripcionTiposPlazas$.unsubscribe();
    this.subscripcionRoles$.unsubscribe();
  }
}
