package mx.agr.dgec.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class Puesto {
    private String idPuesto;
    private String nombre;
    private float salarioBruto;
    private String idTipoPlaza;
    private List<Empleado> empleados;
}
