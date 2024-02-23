package mx.agr.dgec.servicios;

import mx.agr.dgec.generate.model.EmpleadoDto;
import mx.agr.dgec.generate.model.NewEmpleadoDto;
import mx.agr.dgec.mappers.DomicilioMapper;
import mx.agr.dgec.mappers.EscolaridadMapper;
import org.mapstruct.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class ServicioEmpleados {

    private static final Logger log = LoggerFactory.getLogger(ServicioEmpleados.class);


    public EmpleadoDto crearNuevoEmpleado(NewEmpleadoDto nuevoEmpleado) {

        var idEmpleado = generarIdEmpleado(nuevoEmpleado.getPersona().getRfc(), nuevoEmpleado.getFechaIngreso());
        var domicilio = DomicilioMapper.INSTANCE.toDomicilio(idEmpleado, nuevoEmpleado.getDomicilio());
        var escolaridad = EscolaridadMapper.INSTANCE.toEscolaridad(idEmpleado, nuevoEmpleado.getEscolaridad());

        log.info("Creando nuevo empleado con id: " + idEmpleado + " y domicilio: " + domicilio.toString());
        log.info("Creando nuevo empleado con id: " + idEmpleado + " y escolaridad: " + escolaridad.toString());
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
