package mx.agr.dgec.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class TipoPlaza {
    private String idTipoPlaza;
    private String nombre;
    private List<Empleado> Empleados;
    private List<Puesto> puestos;
}
