export * from './empleados.service';
import { EmpleadosService } from './empleados.service';
export * from './escolaridades.service';
import { EscolaridadesService } from './escolaridades.service';
export * from './personas.service';
import { PersonasService } from './personas.service';
export * from './roles.service';
import { RolesService } from './roles.service';
export * from './tiposPlazas.service';
import { TiposPlazasService } from './tiposPlazas.service';
export const APIS = [EmpleadosService, EscolaridadesService, PersonasService, RolesService, TiposPlazasService];
