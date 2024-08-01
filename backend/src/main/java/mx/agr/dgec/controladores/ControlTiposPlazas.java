package mx.agr.dgec.controladores;

import lombok.RequiredArgsConstructor;
import mx.agr.dgec.generate.api.TiposPlazasApi;
import mx.agr.dgec.generate.model.PuestoDto;
import mx.agr.dgec.generate.model.RegistrosDto;
import mx.agr.dgec.servicios.ServicioTiposPlazas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControlTiposPlazas implements TiposPlazasApi {

    private final ServicioTiposPlazas servicioTiposPlazas;

    @Override
    public ResponseEntity<List<RegistrosDto>> recuperarTiposPlazas() {
        var tiposPlazas = servicioTiposPlazas.recuperarTiposPlazas();
        return ResponseEntity.status(HttpStatus.OK).body(tiposPlazas);
    }

    @Override
    public ResponseEntity<List<PuestoDto>> recuperarPuestosByTipoPlaza(String id) {
        var puestos = servicioTiposPlazas.recuperarPuestosByTipoPlaza(id);
        if (puestos.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.status(HttpStatus.OK).body(puestos);
    }
}
