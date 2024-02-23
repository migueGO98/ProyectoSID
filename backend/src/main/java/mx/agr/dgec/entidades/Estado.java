package mx.agr.dgec.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class Estado {
    private String idEstado;
    private String nombre;
    private List<Region> regiones;
    private List<Direccion> direcciones;
    private List<Subdireccion> subdirecciones;
}
