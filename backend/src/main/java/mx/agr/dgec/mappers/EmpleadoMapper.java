package mx.agr.dgec.mappers;

import mx.agr.dgec.entidades.Empleado;
import mx.agr.dgec.enums.MotivoBajaEnum;
import mx.agr.dgec.generate.model.EmpleadoDto;
import mx.agr.dgec.generate.model.NewEmpleadoDto;
import mx.agr.dgec.generate.model.RegistrosDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpleadoMapper {
    EmpleadoMapper INSTANCE = Mappers.getMapper(EmpleadoMapper.class);

    default Empleado toEmpleado(String idEmpleado, NewEmpleadoDto newEmpleadoDto, Boolean activo,
                                LocalDate fechaBaja, String correoElectronico, String telefono,
                                String extensionTelefono, int diasVacacionesDisponibles,
                                int diasVacacionesTomados, MotivoBajaEnum motivoBaja
    ) {
        var personaDto = newEmpleadoDto.getPersona();
        var domicilioDto = newEmpleadoDto.getDomicilio();
        var escolaridadDto = newEmpleadoDto.getEscolaridad();

        return Empleado.builder()
                .idEmpleado(idEmpleado)
                .nombre(personaDto.getNombre())
                .apellidoPaterno(personaDto.getApellidoPaterno())
                .apellidoMaterno(personaDto.getApellidoMaterno())
                .curp(personaDto.getCurp())
                .rfc(personaDto.getRfc())
                .numeroSeguroSocial(personaDto.getNumeroSeguroSocial())
                .fechaNacimiento(personaDto.getFechaNacimiento())
                .genero(PersonaMapper.INSTANCE.toGenerosEnum(personaDto.getGenero()))
                .telefonoPersonal(personaDto.getTelefonoPersonal())
                .correoElectronicoPersonal(personaDto.getCorreoElectronicoPersonal())
                .estadoCivil(PersonaMapper.INSTANCE.toEstadoCivilEnum(personaDto.getEstadoCivil()))
                .hijos(personaDto.getHijos())
                .contactoEmergenciaNombre(personaDto.getContactoEmergenciaNombre())
                .contactoEmergenciaTelefono(personaDto.getContactoEmergenciaTelefono())
                .domicilio(DomicilioMapper.INSTANCE.toDomicilio(idEmpleado, domicilioDto))
                .escolaridades(EscolaridadMapper.INSTANCE.toEscolaridad(idEmpleado, escolaridadDto))
                .activo(activo)
                .fechaIngreso(newEmpleadoDto.getFechaIngreso())
                .fechaBaja(fechaBaja)
                .correoElectronico(correoElectronico)
                .telefono(telefono)
                .extensionTelefono(extensionTelefono)
                .diasVacacionesDisponibles(diasVacacionesDisponibles)
                .diasVacacionesTomados(diasVacacionesTomados)
                .motivoBaja(motivoBaja)
                .idTipoPlaza(newEmpleadoDto.getIdTipoPlaza().getValue())
                .idPuesto(newEmpleadoDto.getIdPuesto())
                .idRegion(newEmpleadoDto.getIdRegion())
                .idDireccion(newEmpleadoDto.getIdDireccion())
                .idSubdireccion(newEmpleadoDto.getIdSubdireccion())
                .build();
    }

    @Mapping(target = "nombreCompleto", source = "nombreCompletoEmpleado")
    EmpleadoDto toEmpleadoDto(String nombreCompletoEmpleado, Empleado empleado);

    default List<RegistrosDto> motivosBajaEnumtoRegistrosDto(List<MotivoBajaEnum> motivosBaja){
        return motivosBaja.stream().map(motivo -> new RegistrosDto(motivo.name(), motivo.getMotivoBaja())).toList();
    }
}
