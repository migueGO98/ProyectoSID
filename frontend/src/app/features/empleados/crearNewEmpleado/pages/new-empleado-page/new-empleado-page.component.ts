import { Component, inject, OnDestroy, OnInit, signal } from '@angular/core';
import { Subscription } from 'rxjs';
import {
  DireccionesService,
  Domicilio,
  Empleado,
  EmpleadosService,
  Escolaridad,
  EscolaridadesService,
  NewEmpleado,
  Persona,
  PersonasService,
  Region,
  RegionesService,
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
  private regionService = inject(RegionesService);
  private direccionesService = inject(DireccionesService);
  private rolesService = inject(RolesService);
  public subscripcionGenero$!: Subscription;
  public subscripcionEstadosCiviles$!: Subscription;
  public subscripcionNivelesEscolaridades$!: Subscription;
  public subscripcionEstadosNivelesEscolaridades$!: Subscription;
  public subscripcionTiposPlazas$!: Subscription;
  public subscripcionRoles$!: Subscription;
  public subscripcionNuevoEmpleado$!: Subscription;
  public subscripcionRegiones$!: Subscription;
  public subscripcionDirecciones$!: Subscription;

  // * Signal para pasar datos **NECESARIOS** a los componentes hijos, se solicitan en el ngOnInit
  public generos = signal<Registros[] | undefined>(undefined);
  public estadosCiviles = signal<Registros[] | undefined>(undefined);
  public nivelesEscolaridades = signal<Registros[] | undefined>(undefined);
  public estadosNivelesEscolaridades = signal<Registros[] | undefined>(undefined);
  public tiposPlazas = signal<Registros[] | undefined>(undefined);
  public roles = signal<Rol[] | undefined>(undefined);
  public regiones = signal<Region[] | undefined>(undefined);

  // * Signal necesarias de la página para poder enviar datos a la API
  public nuevoEmpleado = signal<NewEmpleado | undefined>(undefined);
  public formPersona = signal<Persona | undefined>(undefined);
  public formDomicilio = signal<Domicilio | undefined>(undefined);
  public formEscolaridad = signal<Escolaridad[] | undefined>(undefined);
  public formDatosEmpleado = signal<DatosEmpleado | undefined>(undefined); // Esta interfaz solo es del frontend, se hace para no tener que pasar tantos datos a la vez

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
      error: e => console.error(e),
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

    this.subscripcionRegiones$ = this.regionService.recuperarRegiones().subscribe({
      next: value => this.regiones.set(value),
      // eslint-disable-next-line @typescript-eslint/no-explicit-any, no-console
      error: e => console.error(e.error),
    });
  }

  crearNuevoEmpleado(nuevoEmpleado: NewEmpleado) {
    this.subscripcionNuevoEmpleado$ = this.empleadosService.crearEmpleado(nuevoEmpleado).subscribe({
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
    this.subscripcionNuevoEmpleado$.unsubscribe();
    this.subscripcionRegiones$.unsubscribe();
  }
}
