package mx.agr.dgec.controladores;

import mx.agr.dgec.generate.api.EscolaridadesApi;
import mx.agr.dgec.generate.model.RegistrosDto;
import mx.agr.dgec.servicios.ServicioEscolaridades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ControlEscolaridades implements EscolaridadesApi {

    @Autowired
    private ServicioEscolaridades servicioEscolaridades;

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
