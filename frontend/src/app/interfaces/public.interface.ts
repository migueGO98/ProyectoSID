export interface Estado {
  name: string;
  code: string;
}

export interface DatosEmpleado {
  fechaIngreso: string;
  correoElectronicoInstitucional: string;
  idTipoPlaza: string;
  idRegion: string;
  idDireccion: string;
  idSubdireccion: string;
  idPuesto: string;
  idRoles: Array<string>;
}
