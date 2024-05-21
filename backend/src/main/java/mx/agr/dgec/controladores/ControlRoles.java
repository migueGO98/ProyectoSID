package mx.agr.dgec.controladores;

import lombok.RequiredArgsConstructor;
import mx.agr.dgec.generate.api.RolesApi;
import mx.agr.dgec.generate.model.RolDto;
import mx.agr.dgec.servicios.ServicioRoles;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControlRoles implements RolesApi {

    private final ServicioRoles servicioRoles;

    @Override
    public ResponseEntity<List<RolDto>> recuperarRoles() {
        var roles = servicioRoles.recuperarRoles();
        return ResponseEntity.status(HttpStatus.OK).body(roles);
    }
}
