package mx.agr.dgec.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class Direccion {
    private String idDireccion;
    private String nombre;
    private Region region;
    private Estado estado;
    private List<Subdireccion> subdirecciones;
    private List<Empleado> empleados;
}
