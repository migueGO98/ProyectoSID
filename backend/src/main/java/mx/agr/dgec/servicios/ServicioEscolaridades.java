package mx.agr.dgec.servicios;

import lombok.extern.slf4j.Slf4j;
import mx.agr.dgec.enums.EstadosNivelesEscolaridadesEnum;
import mx.agr.dgec.enums.NivelesEscolaridadesEnum;
import mx.agr.dgec.generate.model.RegistrosDto;
import mx.agr.dgec.mappers.EscolaridadMapper;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class ServicioEscolaridades {

    public List<RegistrosDto> recuperarNivelesEscolares() {
        final var niveles = Arrays.stream(NivelesEscolaridadesEnum.values()).toList();
        log.info("Se recuperaron los niveles escolares");
        return EscolaridadMapper.INSTANCE.nivelesEscolaridadesEnumToRegistrosDto(niveles);
    }

    public List<RegistrosDto> recuperarEstadosNivelesEscolares() {
        final var estadosNiveles = Arrays.stream(EstadosNivelesEscolaridadesEnum.values()).toList();
        log.info("Se recuperaron los estados de los niveles escolares");
        return EscolaridadMapper.INSTANCE.estadosNivelesEscolaridadesEnumToRegistrosDto(estadosNiveles);
    }
}
