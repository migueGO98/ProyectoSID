package mx.agr.dgec.servicios;

import lombok.extern.slf4j.Slf4j;
import mx.agr.dgec.enums.EstadoCivilEnum;
import mx.agr.dgec.enums.GenerosEnum;
import mx.agr.dgec.generate.model.RegistrosDto;
import mx.agr.dgec.mappers.PersonaMapper;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class ServicioPersonas {
    public List<RegistrosDto> recuperarEstadosCiviles() {
        var estadosCiviles = Arrays.stream(EstadoCivilEnum.values()).toList();
        log.info("Se recuperaron los estados civiles");
        return PersonaMapper.INSTANCE.estadosCivilesEnumToRegistrosDto(estadosCiviles);
    }

    public List<RegistrosDto> recuperarGeneros() {
        var generos = Arrays.stream(GenerosEnum.values()).toList();
        log.info("Se recuperaron los géneros");
        return PersonaMapper.INSTANCE.generosEnumToRegistrosDto(generos);
    }
}
