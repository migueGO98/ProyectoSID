package mx.agr.dgec.controladores;

import lombok.RequiredArgsConstructor;
import mx.agr.dgec.generate.api.PersonasApi;
import mx.agr.dgec.generate.model.RegistrosDto;
import mx.agr.dgec.servicios.ServicioPersonas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControlPersonas implements PersonasApi {

    private final ServicioPersonas servicioPersonas;

    @Override
    public ResponseEntity<List<RegistrosDto>> recuperarEstadosCiviles() {
        var estadosCiviles = servicioPersonas.recuperarEstadosCiviles();
        return ResponseEntity.status(HttpStatus.OK).body(estadosCiviles);
    }

    @Override
    public ResponseEntity<List<RegistrosDto>> recuperarGeneros() {
        var generos = servicioPersonas.recuperarGeneros();
        return ResponseEntity.status(HttpStatus.OK).body(generos);
    }
}
