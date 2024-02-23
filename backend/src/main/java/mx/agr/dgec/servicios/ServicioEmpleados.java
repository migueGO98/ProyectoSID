package mx.agr.dgec.servicios;

import mx.agr.dgec.enums.MotivoBajaEnum;
import mx.agr.dgec.generate.model.EmpleadoDto;
import mx.agr.dgec.generate.model.NewEmpleadoDto;
import mx.agr.dgec.mappers.EmpleadoMapper;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class ServicioEmpleados {

    public EmpleadoDto crearNuevoEmpleado(NewEmpleadoDto nuevoEmpleado) {

        var idEmpleado = generarIdEmpleado(nuevoEmpleado.getPersona().getRfc(), nuevoEmpleado.getFechaIngreso());

        // Las asignaciones de activo, fechaBaja, correoElectronico, telefono, extensionTelefono, diasVacacionesDisponibles,
        // diasVacacionesTomados y motivoBaja son por Reglas de Negocio
        var empleado = EmpleadoMapper.INSTANCE.toEmpleado(idEmpleado, nuevoEmpleado, true,
                null, null, null,
                null, 0,
                0, null);

        System.out.println("Empleado creado: " + empleado);
        return null;
    }

    private String generarIdEmpleado(String rfc, LocalDate fechaIngreso) {
        var rfcInicio = rfc.substring(0, 4);
        var anioIngreso = fechaIngreso.getYear();
        var mesIngreso = fechaIngreso.getMonthValue();
        var diaIngreso = fechaIngreso.getDayOfMonth();
        // RN
        var periodoQuincenalIngreso = (diaIngreso <= 15) ? 1 : 2;

        return rfcInicio + periodoQuincenalIngreso + String.format("%02d", mesIngreso) + anioIngreso;
    }
}
