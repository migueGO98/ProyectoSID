package mx.agr.dgec.servicios;

import lombok.extern.slf4j.Slf4j;
import mx.agr.dgec.entidades.Escolaridad;
import mx.agr.dgec.enums.EstadosNivelesEscolaridadesEnum;
import mx.agr.dgec.enums.NivelesEscolaridadesEnum;
import mx.agr.dgec.generate.model.EscolaridadDto;
import mx.agr.dgec.generate.model.RegistrosDto;
import mx.agr.dgec.mappers.EscolaridadMapper;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class ServicioEscolaridades {

    public List<RegistrosDto> recuperarNivelesEscolares() {
        var niveles = Arrays.stream(NivelesEscolaridadesEnum.values()).toList();
        log.info("Se recuperaron los niveles escolares");
        return EscolaridadMapper.INSTANCE.nivelesEscolaridadesEnumToRegistrosDto(niveles);
    }

    public List<RegistrosDto> recuperarEstadosNivelesEscolares() {
        var estadosNiveles = Arrays.stream(EstadosNivelesEscolaridadesEnum.values()).toList();
        log.info("Se recuperaron los estados de los niveles escolares");
        return EscolaridadMapper.INSTANCE.estadosNivelesEscolaridadesEnumToRegistrosDto(estadosNiveles);
    }

    public void validarEscolaridadesDto (List<EscolaridadDto> escolaridadesDto) {
        Objects.requireNonNull(escolaridadesDto, "La escolaridad no puede ser nula");
        if(escolaridadesDto.isEmpty()) throw new IllegalArgumentException("La escolaridad no puede estar vacía");

        escolaridadesDto.forEach(e -> {
            if(e == null) throw new IllegalArgumentException("El argumento escolaridades no puede tener valores nulos");
            var carrera = e.getCarrera();
            if(carrera == null) throw new IllegalArgumentException("El argumento escolaridades.carrera no puede tener valores nulos");
            if(carrera.isBlank()) throw new IllegalArgumentException("El argumento escolaridades.carrera no puede tener valores vacíos");
        });
    }
}
