package mx.agr.dgec.controladores;

import lombok.RequiredArgsConstructor;
import mx.agr.dgec.generate.api.DireccionesApi;
import mx.agr.dgec.generate.model.SubdireccionDto;
import mx.agr.dgec.servicios.ServicioDirecciones;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControlDirecciones implements DireccionesApi {

    private final ServicioDirecciones servicioDirecciones;

    @Override
    public ResponseEntity<List<SubdireccionDto>> recuperarSubdireccionesByDireccion(String id) {
        var subdirecciones = servicioDirecciones.recuperarSubdireccionesByDireccion(id);
        if(subdirecciones.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.status(HttpStatus.OK).body(subdirecciones);
    }
}
