package mx.agr.dgec.servicios;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.agr.dgec.enums.MotivoBajaEnum;
import mx.agr.dgec.exceptions.ElementoYaExisteException;
import mx.agr.dgec.exceptions.ReglaNegocioException;
import mx.agr.dgec.generate.model.*;
import mx.agr.dgec.mappers.EmpleadoMapper;
import mx.agr.dgec.repositorios.RepositorioEmpleado;
import mx.agr.dgec.servicios.externos.ServicioAzureGraph;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ServicioEmpleados {

    private final RepositorioEmpleado repositorioEmpleado;
    private final ServicioRoles servicioRoles;
    private final ServicioRegiones servicioRegiones;
    private final ServicioDirecciones servicioDirecciones;
    private final ServicioSubdirecciones servicioSubdirecciones;
    private final ServicioTiposPlazas servicioTiposPlazas;
    private final ServicioPuestos servicioPuestos;
    private final ServicioAzureGraph servicioAzureGraph;

    private static final float PROMEDIO_DIAS_POR_MES = 30.4375f;



    public List<RegistrosDto> recuperarMotivosBaja() {
        var motivosBaja = Arrays.stream(MotivoBajaEnum.values()).toList();
        log.info("Se recuperaron los motivos de baja");
        return EmpleadoMapper.INSTANCE.motivosBajaEnumtoRegistrosDto(motivosBaja);
    }

    public EmpleadoDto crearNuevoEmpleado(NewEmpleadoDto nuevoEmpleadoDto) {
        // Validaciones de forma (recuperar entidades)
        var tipoPlaza = servicioTiposPlazas.obtenerTipoPlaza(nuevoEmpleadoDto.getIdTipoPlaza());
        var region = servicioRegiones.obtenerRegion(nuevoEmpleadoDto.getIdRegion());
        var direccion = servicioDirecciones.obtenerDireccion(nuevoEmpleadoDto.getIdDireccion());
        var subdireccion = servicioSubdirecciones.obtenerSubdireccion(nuevoEmpleadoDto.getIdSubdireccion());
        var puesto = servicioPuestos.obtenerPuesto(nuevoEmpleadoDto.getIdPuesto());
        var roles = servicioRoles.obtenerRoles(nuevoEmpleadoDto.getIdRoles());

        // Generar ID de empleado, Regla de Negocio
        var fechaIngresoValue = nuevoEmpleadoDto.getFechaIngreso();
        final var idEmpleado = generarIdEmpleado(nuevoEmpleadoDto.getPersona().getRfc(), fechaIngresoValue);

        // Validaciones de fondo (Reglas de Negocio)
        if (existeEmpleado(idEmpleado)) {
            log.info("El empleado con ID {} ya existe", idEmpleado);
            throw new ElementoYaExisteException("El empleado ya existe");
        }

        servicioTiposPlazas.validarPuestoPertenezcaToTipoPlaza(tipoPlaza, puesto);
        servicioRegiones.validarDireccionPertenezcaToRegion(region, direccion);
        servicioDirecciones.validarSubdireccionPertenezcaToDireccion(direccion, subdireccion);
        validarDiaFechaIngreso(fechaIngresoValue);
        validarNoHaPasado1MesFechaIngreso(fechaIngresoValue);
        validarNoPasaDe1MesFuturoFechaIngreso(fechaIngresoValue);

        var estadoActivo = obtenerEstadoNuevoEmpleado(nuevoEmpleadoDto.getFechaIngreso());
        // Las asignaciones null son por Reglas de Negocio
        final var nuevoEmpleado = EmpleadoMapper.INSTANCE.newEmpleadoDtoToEmpleado(idEmpleado, nuevoEmpleadoDto, estadoActivo,null,
                null,null, 0,0, null,
                tipoPlaza, region, direccion, subdireccion, puesto, roles);

        nuevoEmpleado.calcularEdad();
        nuevoEmpleado.formatearDatos();
        nuevoEmpleado.concatenarNombreAndApellidos();

        // Crear usuario en Azure AD B2C
        servicioAzureGraph.crearUsuario(nuevoEmpleado);

        // Guardar en BD
        final var empleado = repositorioEmpleado.save(nuevoEmpleado);
        log.info("Empleado creado: {} con ID {} en la BD de Postgre", empleado.getNombreCompleto().toUpperCase(), idEmpleado);

        return EmpleadoMapper.INSTANCE.empleadoToEmpleadoDto(empleado);
    }

    public List<EmpleadoDto> recuperarEmpleados() {
        final var empleados = repositorioEmpleado.findAll();
        log.info("Se recuperaron todos los empleados");
        return EmpleadoMapper.INSTANCE.listEmpleadosToListEmpleadosDto(empleados);
    }


    /**
     * Los siguientes metodos son utilizados por otros servicios
     * o el mismo servicio, los metodos de arriba son utilizados por los controladores
     * para realizar las operaciones de los endpoints
     */

    private String generarIdEmpleado(String rfc, LocalDate fechaIngreso) {
        var rfcInicio = rfc.substring(0, 4);
        var anioIngreso = fechaIngreso.getYear();
        var mesIngreso = fechaIngreso.getMonthValue();
        var diaIngreso = fechaIngreso.getDayOfMonth();
        var periodoQuincenalIngreso = (diaIngreso <= 15) ? 1 : 2;

        return (rfcInicio + periodoQuincenalIngreso + String.format("%02d", mesIngreso) + anioIngreso).toUpperCase();
    }

    private boolean existeEmpleado(String idEmpleado){
        var empleado = repositorioEmpleado.findById(idEmpleado);
        return (empleado.isPresent());
    }

    private void validarDiaFechaIngreso(LocalDate fechaIngreso) {
        var diaIngreso = fechaIngreso.getDayOfMonth();
        if (diaIngreso != 1 && diaIngreso != 16) throw new ReglaNegocioException("El día de la fecha ingreso debe ser 01 ó 16");
    }

    private void validarNoHaPasado1MesFechaIngreso(LocalDate fechaIngreso) {
        var fechaPeriodoActual = obtenerFechaPeriodoActual();
        var diferenciaEnDias = ChronoUnit.DAYS.between(fechaIngreso, fechaPeriodoActual);
        float diferenciaEnMeses = diferenciaEnDias / PROMEDIO_DIAS_POR_MES;
        if (diferenciaEnMeses > 1.03f) throw new ReglaNegocioException("La fecha de ingreso del nuevo empleado no debe pasar de 2 periodos quincenales anteriores del periodo quincenal actual");
    }

    private void validarNoPasaDe1MesFuturoFechaIngreso(LocalDate fechaIngreso) {
        var fechaPeriodoActual = obtenerFechaPeriodoActual();
        var diferenciaEnDias = ChronoUnit.DAYS.between(fechaPeriodoActual, fechaIngreso);
        float diferenciaEnMeses = diferenciaEnDias / PROMEDIO_DIAS_POR_MES;
        if (diferenciaEnMeses > 1.2f) throw new ReglaNegocioException("La fecha de ingreso del nuevo empleado no debe pasar de 2 periodos quincenales posteriores del periodo quincenal actual");
    }

    private LocalDate obtenerFechaPeriodoActual() {
        // Obtener si es el primer o segundo periodo quincenal
        LocalDate fechaActual = LocalDate.now();
        int primerDiaPeriodoActual = (fechaActual.getDayOfMonth() <= 15) ? 1 : 16;
        return LocalDate.of(fechaActual.getYear(), fechaActual.getMonth(), primerDiaPeriodoActual);
    }

    private boolean obtenerEstadoNuevoEmpleado(LocalDate fechaIngreso) {
        // Si la fecha de ingreso es igual o anterior a la fecha actual, el empleado está activo, de lo contrario, está inactivo
        return !fechaIngreso.isAfter(LocalDate.now());
    }
}
