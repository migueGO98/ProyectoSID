package mx.agr.dgec.mappers;

import mx.agr.dgec.entidades.*;
import mx.agr.dgec.enums.MotivoBajaEnum;
import mx.agr.dgec.generate.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Mapper(uses = {PersonaMapper.class, DomicilioMapper.class, JsonNullableMapper.class, EscolaridadMapper.class, RolMapper.class,
                RegionMapper.class, DireccionMapper.class, SubdireccionMapper.class, TipoPlazaMapper.class, PuestoMapper.class
})
public interface EmpleadoMapper {

    EmpleadoMapper INSTANCE = Mappers.getMapper(EmpleadoMapper.class);

    @SuppressWarnings("java:S107") // Buscar una mejor solución
    @Mapping(target = "idPersona", source = "idEmpleado")
    @Mapping(target = "idEmpleado", source = "idEmpleado")
    @Mapping(target = "nombre", source = "newEmpleadoDto.persona.nombre")
    @Mapping(target = "apellidoPaterno", source = "newEmpleadoDto.persona.apellidoPaterno")
    @Mapping(target = "apellidoMaterno", source = "newEmpleadoDto.persona.apellidoMaterno")
    @Mapping(target = "curp", source = "newEmpleadoDto.persona.curp")
    @Mapping(target = "rfc", source = "newEmpleadoDto.persona.rfc")
    @Mapping(target = "numeroSeguroSocial", source = "newEmpleadoDto.persona.numeroSeguroSocial")
    @Mapping(target = "fechaNacimiento", source = "newEmpleadoDto.persona.fechaNacimiento")
    @Mapping(target = "genero", source = "newEmpleadoDto.persona.genero")
    @Mapping(target = "telefonoPersonal", source = "newEmpleadoDto.persona.telefonoPersonal")
    @Mapping(target = "correoElectronicoPersonal", source = "newEmpleadoDto.persona.correoElectronicoPersonal")
    @Mapping(target = "estadoCivil", source = "newEmpleadoDto.persona.estadoCivil")
    @Mapping(target = "hijos", source = "newEmpleadoDto.persona.hijos")
    @Mapping(target = "contactoEmergenciaNombre", source = "newEmpleadoDto.persona.contactoEmergenciaNombre")
    @Mapping(target = "contactoEmergenciaTelefono", source = "newEmpleadoDto.persona.contactoEmergenciaTelefono")
    @Mapping(target = "domicilio", expression = "java(domicilioDtoToDomicilio(idEmpleado, newEmpleadoDto.getDomicilio()))")
    @Mapping(target = "escolaridades", expression = "java(listEscolaridadDtoToListEscolaridad(idEmpleado, newEmpleadoDto.getEscolaridades()))")
    @Mapping(target = "region", source = "region")
    @Mapping(target = "direccion", source = "direccion")
    @Mapping(target = "roles", source = "rolesSet")
    @Mapping(target = "subdireccion", source = "subdireccion")
    @Mapping(target = "tipoPlaza", source = "tipoPlaza")
    @Mapping(target = "puesto", source = "puesto")
    Empleado newEmpleadoDtoToEmpleado(String idEmpleado, NewEmpleadoDto newEmpleadoDto, Boolean activo, LocalDate fechaBaja,
                                      String correoElectronico, String telefono, String extensionTelefono, int diasVacacionesDisponibles,
                                      int diasVacacionesTomados, MotivoBajaEnum motivoBaja, TipoPlaza tipoPlaza, Region region,
                                      Direccion direccion, Subdireccion subdireccion, Puesto puesto, Set<Rol> rolesSet);

    // Sí se usa en el metodo de newEmpleadoDtoToEmpleado
    @SuppressWarnings("unused")
    default Domicilio domicilioDtoToDomicilio(String idEmpleado, DomicilioDto domicilioDto) {
        return DomicilioMapper.INSTANCE.domicilioDtoToDomicilio(idEmpleado, domicilioDto);
    }

    // Sí se usa en el metodo de newEmpleadoDtoToEmpleado
    @SuppressWarnings("unused")
    default List<Escolaridad> listEscolaridadDtoToListEscolaridad(String idEmpleado, List<EscolaridadDto> escolaridadesDto) {
        return EscolaridadMapper.INSTANCE.listEscolaridadDtoToListEscolaridad(idEmpleado, escolaridadesDto);
    }

    @Mapping(target = "nombreCompleto", source = "empleado.nombreCompleto")
    @Mapping(target = "region", source = "empleado.region.nombre")
    @Mapping(target = "direccion", source = "empleado.direccion.nombre")
    @Mapping(target = "subdireccion", source = "empleado.subdireccion.nombre")
    @Mapping(target = "tipoPlaza", source = "empleado.tipoPlaza.nombre")
    @Mapping(target = "puesto", source = "empleado.puesto.nombre")
    EmpleadoDto empleadoToEmpleadoDto(Empleado empleado);

    List<EmpleadoDto> listEmpleadosToListEmpleadosDto(List<Empleado> empleados);

    default List<RegistrosDto> motivosBajaEnumtoRegistrosDto(List<MotivoBajaEnum> motivosBaja) {
        return motivosBaja.stream().map(motivo -> new RegistrosDto(motivo.name(), motivo.getMotivoBaja())).toList();
    }
}
