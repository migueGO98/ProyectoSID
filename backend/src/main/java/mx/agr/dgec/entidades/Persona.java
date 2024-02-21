package mx.agr.dgec.entidades;

import mx.agr.dgec.enums.EstadoCivilEnum;
import mx.agr.dgec.enums.GenerosEnum;

import java.util.Date;
import java.util.List;

public abstract class Persona {
    private String idEmpleado;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String curp;
    private String rfc;
    private String numeroSeguroSocial;
    private Date fechaNacimiento;
    private int edad;
    private GenerosEnum genero;
    private String telefonoPersonal;
    private String correoElectronicoPersonal;
    private EstadoCivilEnum estadoCivil;
    private Boolean hijos;
    private String contactoEmergenciaNombre;
    private String contactoEmergenciaTelefono;
    private Domicilio domicilio;
    private List<Escolaridad> escolaridades;
}
