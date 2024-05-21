package mx.agr.dgec.controladores;

import lombok.RequiredArgsConstructor;
import mx.agr.dgec.generate.api.EscolaridadesApi;
import mx.agr.dgec.generate.model.RegistrosDto;
import mx.agr.dgec.servicios.ServicioEscolaridades;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControlEscolaridades implements EscolaridadesApi {

    private final ServicioEscolaridades servicioEscolaridades;

    @Override
    public ResponseEntity<List<RegistrosDto>> recuperarNivelesEscolares() {
        var niveles = servicioEscolaridades.recuperarNivelesEscolares();
        return ResponseEntity.status(HttpStatus.OK).body(niveles);
    }

    @Override
    public ResponseEntity<List<RegistrosDto>> recuperarEstadosNivelesEscolares() {
        var estadosNiveles = servicioEscolaridades.recuperarEstadosNivelesEscolares();
        return ResponseEntity.status(HttpStatus.OK).body(estadosNiveles);
    }
}
