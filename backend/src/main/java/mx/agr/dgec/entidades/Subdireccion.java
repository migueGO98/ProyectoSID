package mx.agr.dgec.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class Subdireccion {
    private String idSubdireccion;
    private String nombre;
    private Direccion direccion;
    private Estado estado;
    private List<Empleado> empleados;
}
