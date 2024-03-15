package mx.agr.dgec.servicios;

import lombok.extern.slf4j.Slf4j;
import mx.agr.dgec.enums.MotivoBajaEnum;
import mx.agr.dgec.generate.model.*;
import mx.agr.dgec.mappers.EmpleadoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class ServicioEmpleados {

    @Autowired
    ServicioEscolaridades servicioEscolaridades;

    @Autowired
    ServicioRoles servicioRoles;

    @Autowired
    ServicioRegiones servicioRegiones;

    @Autowired
    ServicioDirecciones servicioDirecciones;

    @Autowired
    ServicioSubdirecciones servicioSubdirecciones;

    @Autowired
    ServicioTiposPlazas servicioTiposPlazas;

    @Autowired
    ServicioDomicilios servicioDomicilios;

    @Autowired
    ServicioPuestos servicioPuestos;

    @Autowired
    ServicioPersonas servicioPersonas;

    public EmpleadoDto crearNuevoEmpleado(NewEmpleadoDto nuevoEmpleadoDto) {
        // Validaciones de forma
        servicioPersonas.validarPersonaDto(nuevoEmpleadoDto.getPersona());
        servicioDomicilios.validarDomicilioDto(nuevoEmpleadoDto.getDomicilio());
        servicioEscolaridades.validarEscolaridadesDto(nuevoEmpleadoDto.getEscolaridades());
        var tipoPlaza = servicioTiposPlazas.obtenerTipoPlaza(nuevoEmpleadoDto.getIdTipoPlaza());
        var region = servicioRegiones.obtenerRegion(nuevoEmpleadoDto.getIdRegion());
        var direccion = servicioDirecciones.obtenerDireccion(nuevoEmpleadoDto.getIdDireccion());
        var subdireccion = servicioSubdirecciones.obtenerSubdireccion(nuevoEmpleadoDto.getIdSubdireccion());
        var puesto = servicioPuestos.obtenerPuesto(nuevoEmpleadoDto.getIdPuesto());
        var roles = servicioRoles.obtenerRoles(nuevoEmpleadoDto.getRoles());

        final var idEmpleado = generarIdEmpleado(nuevoEmpleadoDto.getPersona().getRfc(), nuevoEmpleadoDto.getFechaIngreso());
        // Validar que el empleado no exista en la base de datos

        // Las asignaciones true y null son por Reglas de Negocio
        final var nuevoEmpleado = EmpleadoMapper.INSTANCE.newEmpleadoDtoToEmpleado(idEmpleado, nuevoEmpleadoDto, true,null,
               null, null,null, 0,0, null,
                tipoPlaza, region, direccion, subdireccion, puesto, roles);

        nuevoEmpleado.calcularEdad();

        log.info("Nuevo Empleado: {}", nuevoEmpleado);

        String nombreCompleto;

        if (nuevoEmpleado.getApellidoMaterno() == null)
            nombreCompleto = String.format("%s %s", nuevoEmpleado.getNombre(), nuevoEmpleado.getApellidoPaterno());
        else
            nombreCompleto = String.format("%s %s %s", nuevoEmpleado.getNombre(), nuevoEmpleado.getApellidoPaterno(), nuevoEmpleado.getApellidoMaterno());

        log.info("Empleado creado: {} con ID {}", nombreCompleto.toUpperCase(), idEmpleado);
        return EmpleadoMapper.INSTANCE.empleadoToEmpleadoDto(nombreCompleto, nuevoEmpleado);
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
