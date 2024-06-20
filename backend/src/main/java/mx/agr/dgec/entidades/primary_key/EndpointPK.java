package mx.agr.dgec.entidades.primary_key;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.agr.dgec.enums.MetodosHttpEnum;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EndpointPK implements Serializable {
    private MetodosHttpEnum metodoHttp;
    private String rutaEndpoint;
}
