package mx.agr.dgec.servicios;

import lombok.extern.slf4j.Slf4j;
import mx.agr.dgec.enums.MotivoBajaEnum;
import mx.agr.dgec.generate.model.*;
import mx.agr.dgec.mappers.EmpleadoMapper;
import mx.agr.dgec.repositorios.RepositorioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class ServicioEmpleados {

    @Autowired
    RepositorioEmpleado repositorioEmpleado;

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

    private static final float PROMEDIO_DIAS_POR_MES = 30.4375f;

    public EmpleadoDto crearNuevoEmpleado(NewEmpleadoDto nuevoEmpleadoDto) {
        // Validaciones de forma
        servicioPersonas.validarPersonaDto(nuevoEmpleadoDto.getPersona());
        final var idEmpleado = generarIdEmpleado(nuevoEmpleadoDto.getPersona().getRfc(), nuevoEmpleadoDto.getFechaIngreso());
        if (existeEmpleado(idEmpleado)) { // Regla de Negocio
            log.error("El empleado con ID {} ya existe", idEmpleado);
            throw new IllegalArgumentException("El empleado ya existe");
        }
        servicioDomicilios.validarDomicilioDto(nuevoEmpleadoDto.getDomicilio());
        servicioEscolaridades.validarEscolaridadesDto(nuevoEmpleadoDto.getEscolaridades());
        var tipoPlaza = servicioTiposPlazas.obtenerTipoPlaza(nuevoEmpleadoDto.getIdTipoPlaza());
        var region = servicioRegiones.obtenerRegion(nuevoEmpleadoDto.getIdRegion());
        var direccion = servicioDirecciones.obtenerDireccion(nuevoEmpleadoDto.getIdDireccion());
        var subdireccion = servicioSubdirecciones.obtenerSubdireccion(nuevoEmpleadoDto.getIdSubdireccion());
        var puesto = servicioPuestos.obtenerPuesto(nuevoEmpleadoDto.getIdPuesto());
        var roles = servicioRoles.obtenerRoles(nuevoEmpleadoDto.getRoles());

        // Validaciones de fondo (Reglas de Negocio)
        validarReglasNegocioNuevoEmpleado(nuevoEmpleadoDto.getFechaIngreso());

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

    private void validarReglasNegocioNuevoEmpleado(LocalDate fechaIngresoValue) {
        validarDiaFechaIngreso(fechaIngresoValue);
        validarNoHaPasado1MesFechaIngreso(fechaIngresoValue);
        validarNoHaPasado1MesFuturoFechaIngreso(fechaIngresoValue);
    }

    private boolean existeEmpleado(String idEmpleado){
        var empleado = repositorioEmpleado.findById(idEmpleado);
        return (empleado.isPresent());
    }

    private void validarDiaFechaIngreso(LocalDate fechaIngreso) {
        var diaIngreso = fechaIngreso.getDayOfMonth();
        if (diaIngreso != 1 && diaIngreso != 16) throw new IllegalArgumentException("El día de la fecha ingreso debe ser 01 ó 16");
    }

    private void validarNoHaPasado1MesFechaIngreso(LocalDate fechaIngreso) {
        var fechaPeriodoActual = obtenerFechaPeriodoActual(fechaIngreso);
        var diferenciaEnDias = (byte) ChronoUnit.DAYS.between(fechaIngreso, fechaPeriodoActual);
        float diferenciaEnMeses = diferenciaEnDias / PROMEDIO_DIAS_POR_MES;
        log.info("Diferencia en meses: {}", diferenciaEnMeses);
        if (diferenciaEnMeses > 1.0f) throw new IllegalArgumentException("La fecha de ingreso del nuevo empleado no debe pasar de 2 periodos quincenales anteriores del periodo quincenal actual");
    }

    private void validarNoHaPasado1MesFuturoFechaIngreso(LocalDate fechaIngreso) {
        var fechaPeriodoActual = obtenerFechaPeriodoActual(fechaIngreso);
        var diferenciaEnDias = (byte) ChronoUnit.DAYS.between(fechaPeriodoActual, fechaIngreso);
        float diferenciaEnMeses = diferenciaEnDias / PROMEDIO_DIAS_POR_MES;
        log.info("Diferencia en meses: {}", diferenciaEnMeses);
        if (diferenciaEnMeses > 1.2f) throw new IllegalArgumentException("La fecha de ingreso del nuevo empleado no debe pasar de 2 periodos quincenales posteriores del periodo quincenal actual");
    }

    private LocalDate obtenerFechaPeriodoActual(LocalDate fechaIngreso) {
        // Obtener si es el primer o segundo periodo quincenal
        LocalDate fechaActual = LocalDate.now();
        int primerDiaPeriodoActual = (fechaActual.getDayOfMonth() <= 15) ? 1 : 16;
        return LocalDate.of(fechaActual.getYear(), fechaActual.getMonth(), primerDiaPeriodoActual);
    }

}
