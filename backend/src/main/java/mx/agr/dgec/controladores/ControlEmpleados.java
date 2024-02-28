package mx.agr.dgec.controladores;

import mx.agr.dgec.generate.api.EmpleadosApi;
import mx.agr.dgec.generate.model.EmpleadoDto;
import mx.agr.dgec.generate.model.NewEmpleadoDto;
import mx.agr.dgec.generate.model.RegistrosDto;
import mx.agr.dgec.servicios.ServicioEmpleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ControlEmpleados implements EmpleadosApi {

    @Autowired
    private ServicioEmpleados servicioEmpleados;

    @Override
    public ResponseEntity<EmpleadoDto> crearEmpleado(NewEmpleadoDto newEmpleadoDto) {
        var empleado = servicioEmpleados.crearNuevoEmpleado(newEmpleadoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(empleado);
    }

    @Override
    public ResponseEntity<List<RegistrosDto>> recuperarMotivosBaja() {
        var motivosBaja = servicioEmpleados.recuperarMotivosBaja();
        return ResponseEntity.status(HttpStatus.OK).body(motivosBaja);
    }
}
