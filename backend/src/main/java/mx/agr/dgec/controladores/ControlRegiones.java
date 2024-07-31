package mx.agr.dgec.controladores;

import lombok.RequiredArgsConstructor;
import mx.agr.dgec.generate.api.RegionesApi;
import mx.agr.dgec.generate.model.DireccionDto;
import mx.agr.dgec.generate.model.RegionDto;
import mx.agr.dgec.servicios.ServicioRegiones;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControlRegiones implements RegionesApi {

    private final ServicioRegiones servicioRegiones;

    @Override
    public ResponseEntity<List<RegionDto>> recuperarRegiones() {
        var regionesDto = servicioRegiones.recuperarRegiones();
        return ResponseEntity.status(HttpStatus.OK).body(regionesDto);
    }

    @Override
    public ResponseEntity<List<DireccionDto>> recuperarDireccionesByRegion(String id) {
        /*TODO*/
        return null;
    }
}
