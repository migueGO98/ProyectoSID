package mx.agr.dgec.entidades.primary_key;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.agr.dgec.enums.NivelesEscolaridadesEnum;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EscolaridadPK implements Serializable {
    private String idPersona;
    private NivelesEscolaridadesEnum nivel;
    private String carrera;
}
