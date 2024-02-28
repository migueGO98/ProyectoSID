package mx.agr.dgec.servicios;

import lombok.extern.slf4j.Slf4j;
import mx.agr.dgec.generate.model.EmpleadoDto;
import mx.agr.dgec.generate.model.NewEmpleadoDto;
import mx.agr.dgec.mappers.EmpleadoMapper;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
@Slf4j
public class ServicioEmpleados {

    public EmpleadoDto crearNuevoEmpleado(NewEmpleadoDto nuevoEmpleado) {

        final var idEmpleado = generarIdEmpleado(nuevoEmpleado.getPersona().getRfc(), nuevoEmpleado.getFechaIngreso());
        // Validar que el empleado no exista en la base de datos

        // Las asignaciones true y null son por Reglas de Negocio
        final var empleado = EmpleadoMapper.INSTANCE.toEmpleado(idEmpleado, nuevoEmpleado, true,null,
                null, null,null, 0,0, null);
        empleado.calcularEdad();
        var nombreCompleto = String.format("%s %s %s", empleado.getNombre(), empleado.getApellidoPaterno(), empleado.getApellidoMaterno());

        log.info("Empleado creado: " + nombreCompleto.toUpperCase() + " con ID: " + idEmpleado + "y su edad es: " + empleado.getEdad() + " años");

        return EmpleadoMapper.INSTANCE.toEmpleadoDto(nombreCompleto, empleado);
    }

    private String generarIdEmpleado(String rfc, LocalDate fechaIngreso) {
        var rfcInicio = rfc.substring(0, 4);
        var anioIngreso = fechaIngreso.getYear();
        var mesIngreso = fechaIngreso.getMonthValue();
        var diaIngreso = fechaIngreso.getDayOfMonth();
        var periodoQuincenalIngreso = (diaIngreso <= 15) ? 1 : 2;

        return rfcInicio + periodoQuincenalIngreso + String.format("%02d", mesIngreso) + anioIngreso;
    }
}
