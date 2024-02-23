package mx.agr.dgec.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Domicilio {
    private String idEmpleado;
    private String calle;
    private String codigoPostal;
    private String colonia;
    private String municipio;
    private String ciudad;
    private String estado;
}
