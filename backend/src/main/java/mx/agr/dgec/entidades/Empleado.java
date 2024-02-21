package mx.agr.dgec.entidades;

import mx.agr.dgec.enums.MotivoBajaEnum;

import java.util.Date;

public class Empleado {
    private String idEmpleado;
    private Boolean activo;
    private Date fechaIngreso;
    private Date fechaTermino;
    private String correoElectronico;
    private String telefono;
    private String extensionTelefono;
    private int diasVacacionesDisponibles;
    private int diasVacacionesTomados;
    private MotivoBajaEnum motivoBaja;
    private TipoPlaza tipoPlaza;
    private Puesto puesto;
    private Region region;
    private Direccion direccion;
    private Subdireccion subdireccion;
}
