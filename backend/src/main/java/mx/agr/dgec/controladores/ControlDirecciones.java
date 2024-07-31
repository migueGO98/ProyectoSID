package mx.agr.dgec.controladores;

import lombok.RequiredArgsConstructor;
import mx.agr.dgec.generate.api.DireccionesApi;
import mx.agr.dgec.generate.model.SubdireccionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControlDirecciones implements DireccionesApi {
    @Override
    public ResponseEntity<List<SubdireccionDto>> recuperarSubdireccionesByDireccion(String id) {
        /*TODO*/
        return null;
    }
}
