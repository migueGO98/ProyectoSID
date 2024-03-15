package mx.agr.dgec.servicios;

import lombok.extern.slf4j.Slf4j;
import mx.agr.dgec.enums.EstadoCivilEnum;
import mx.agr.dgec.enums.GeneroEnum;
import mx.agr.dgec.generate.model.PersonaDto;
import mx.agr.dgec.generate.model.RegistrosDto;
import mx.agr.dgec.mappers.PersonaMapper;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Service
@Slf4j
public class ServicioPersonas {
    public List<RegistrosDto> recuperarEstadosCiviles() {
        var estadosCiviles = Arrays.stream(EstadoCivilEnum.values()).toList();
        log.info("Se recuperaron los estados civiles");
        return PersonaMapper.INSTANCE.estadosCivilesEnumToRegistrosDto(estadosCiviles);
    }

    public List<RegistrosDto> recuperarGeneros() {
        var generos = Arrays.stream(GeneroEnum.values()).toList();
        log.info("Se recuperaron los géneros");
        return PersonaMapper.INSTANCE.generosEnumToRegistrosDto(generos);
    }

    public GeneroEnum recuperarGenero(String genero) {
        return Stream.of(GeneroEnum.values())
                .filter(g -> g.name().equals(genero))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("El valor " + genero + " no es un género válido."));
    }

    public EstadoCivilEnum recuperarEstadoCivil(String estadoCivil) {
        return Stream.of(EstadoCivilEnum.values())
                .filter(e -> e.name().equals(estadoCivil))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("El valor " + estadoCivil + " no es un estado civil válido."));
    }

    public void validarPersonaDto(PersonaDto personaDto) {
        if (personaDto.getNombre().isBlank()) throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        if (personaDto.getApellidoPaterno().isBlank()) throw new IllegalArgumentException("El apellido paterno no puede ser nulo o vacío");
        if (personaDto.getApellidoMaterno().isPresent() && (personaDto.getApellidoMaterno().get().isBlank())) {
            throw new IllegalArgumentException("El apellido materno no puede ser vacío");
        }
        if (personaDto.getCurp().isBlank()) throw new IllegalArgumentException("El CURP no puede ser vacío");
        if (personaDto.getRfc().isBlank()) throw new IllegalArgumentException("El RFC no puede ser vacío");
        if (personaDto.getNumeroSeguroSocial().isBlank()) throw new IllegalArgumentException("El número de seguro social no puede ser vacío");
        if (personaDto.getFechaNacimiento() == null) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede vacío");
        }
        if (personaDto.getTelefonoPersonal().isBlank()) throw new IllegalArgumentException("El teléfono personal no puede ser vacío");
        if (personaDto.getCorreoElectronicoPersonal().isBlank()) throw new IllegalArgumentException("El correo electrónico no puede ser vacío");
        if (personaDto.getContactoEmergenciaNombre().isBlank()) throw new IllegalArgumentException("El nombre del contacto de emergencia no puede ser vacío");
        if (personaDto.getContactoEmergenciaTelefono().isBlank()) throw new IllegalArgumentException("El teléfono del contacto de emergencia no puede ser vacío");
    }
}
