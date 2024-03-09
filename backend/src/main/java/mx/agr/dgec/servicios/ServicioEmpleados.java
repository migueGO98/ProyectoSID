package mx.agr.dgec.servicios;

import lombok.extern.slf4j.Slf4j;
import mx.agr.dgec.enums.MotivoBajaEnum;
import mx.agr.dgec.generate.model.*;
import mx.agr.dgec.mappers.EmpleadoMapper;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class ServicioEmpleados {

    public EmpleadoDto crearNuevoEmpleado(NewEmpleadoDto nuevoEmpleadoDto) {
        final var idEmpleado = generarIdEmpleado(nuevoEmpleadoDto.getPersona().getRfc(), nuevoEmpleadoDto.getFechaIngreso());

        // Validar que el empleado no exista en la base de datos

        // Las asignaciones true y null son por Reglas de Negocio
        final var nuevoEmpleado = EmpleadoMapper.INSTANCE.newEmpleadoDtoToEmpleado(idEmpleado, nuevoEmpleadoDto, true,null,
               null, null,null, 0,0, null);
        nuevoEmpleado.calcularEdad();

        log.info("NewEmpleadoDto: {}", nuevoEmpleado);

        var nombreCompleto = String.format("%s %s %s", nuevoEmpleado.getNombre(), nuevoEmpleado.getApellidoPaterno(), nuevoEmpleado.getApellidoMaterno());

        log.info("Empleado creado: {} con ID {}", nombreCompleto.toUpperCase(), idEmpleado);
        return EmpleadoMapper.INSTANCE.toEmpleadoDto(nombreCompleto, nuevoEmpleado);
    }

    private String generarIdEmpleado(String rfc, LocalDate fechaIngreso) {
        var rfcInicio = rfc.substring(0, 4);
        var anioIngreso = fechaIngreso.getYear();
        var mesIngreso = fechaIngreso.getMonthValue();
        var diaIngreso = fechaIngreso.getDayOfMonth();
        var periodoQuincenalIngreso = (diaIngreso <= 15) ? 1 : 2;

        return rfcInicio + periodoQuincenalIngreso + String.format("%02d", mesIngreso) + anioIngreso;
    }

    public List<RegistrosDto> recuperarMotivosBaja() {
        var motivosBaja = Arrays.stream(MotivoBajaEnum.values()).toList();
        log.info("Se recuperaron los motivos de baja");
        return EmpleadoMapper.INSTANCE.motivosBajaEnumtoRegistrosDto(motivosBaja);
    }
}
