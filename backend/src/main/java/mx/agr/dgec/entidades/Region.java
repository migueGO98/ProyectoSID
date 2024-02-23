package mx.agr.dgec.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class Region {
    private String idRegion;
    private String nombre;
    private List<Estado> estados;
    private List<Direccion> direcciones;
    private List<Empleado> empleados;
}
