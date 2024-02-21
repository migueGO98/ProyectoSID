package mx.agr.dgec.entidades;

import mx.agr.dgec.enums.TipoPlazaEnum;

import java.util.List;

public class Puesto {
    private String idPuesto;
    private String nombre;
    private float salarioBruto;
    private TipoPlaza tipoPlaza;
    private List<Empleado> empleados;
}
