package mx.agr.dgec.mappers;

import mx.agr.dgec.entidades.Empleado;
import mx.agr.dgec.enums.MotivoBajaEnum;
import mx.agr.dgec.generate.model.NewEmpleadoDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;

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
                .edad(personaDto.getEdad())
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
                .build();
    }
}
