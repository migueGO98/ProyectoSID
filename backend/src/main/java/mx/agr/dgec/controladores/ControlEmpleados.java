package mx.agr.dgec.controladores;

import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import mx.agr.dgec.enums.MetodosHttpEnum;
import mx.agr.dgec.generate.api.EmpleadosApi;
import mx.agr.dgec.generate.model.EmpleadoDto;
import mx.agr.dgec.generate.model.NewEmpleadoDto;
import mx.agr.dgec.generate.model.RegistrosDto;
import mx.agr.dgec.seguridad.DynamicRolesAllowed;
import mx.agr.dgec.servicios.ServicioEmpleados;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControlEmpleados implements EmpleadosApi {

    private final ServicioEmpleados servicioEmpleados;

    @Override
    @DynamicRolesAllowed(metodoHttp = MetodosHttpEnum.POST, rutaEndpoint = "/api/empleados")
    public ResponseEntity<EmpleadoDto> crearEmpleado(NewEmpleadoDto newEmpleadoDto) {
        var empleado = servicioEmpleados.crearNuevoEmpleado(newEmpleadoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(empleado);
    }

    @Override
    @DynamicRolesAllowed(metodoHttp = MetodosHttpEnum.GET, rutaEndpoint = "/api/empleados")
    public ResponseEntity<List<EmpleadoDto>> recuperarEmpleados() {
        var empleados = servicioEmpleados.recuperarEmpleados();
        return ResponseEntity.status(HttpStatus.OK).body(empleados);
    }

    @Override
    @DynamicRolesAllowed(metodoHttp = MetodosHttpEnum.GET, rutaEndpoint = "/api/empleados/{id}")
    public ResponseEntity<List<RegistrosDto>> recuperarMotivosBaja() {
        var motivosBaja = servicioEmpleados.recuperarMotivosBaja();
        return ResponseEntity.status(HttpStatus.OK).body(motivosBaja);
    }
}
