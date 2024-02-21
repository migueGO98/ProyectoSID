package mx.agr.dgec.entidades;

import java.util.List;

public class Direccion {
    private String idDireccion;
    private String nombre;
    private Region region;
    private Estado estado;
    private List<Subdireccion> subdirecciones;
    private List<Empleado> empleados;
}
