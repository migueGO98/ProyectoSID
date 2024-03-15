package mx.agr.dgec.controladores;

import mx.agr.dgec.generate.api.TiposPlazasApi;
import mx.agr.dgec.generate.model.RegistrosDto;
import mx.agr.dgec.servicios.ServicioTiposPlazas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ControlTiposPlazas implements TiposPlazasApi {

    @Autowired
    private ServicioTiposPlazas servicioTiposPlazas;

    @Override
    public ResponseEntity<List<RegistrosDto>> recuperarTiposPlazas() {
        var tiposPlazas = servicioTiposPlazas.recuperarTiposPlazas();
        return ResponseEntity.status(HttpStatus.OK).body(tiposPlazas);
    }
}
