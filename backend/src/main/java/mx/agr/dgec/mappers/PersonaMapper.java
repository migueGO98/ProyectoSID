package mx.agr.dgec.mappers;

import mx.agr.dgec.enums.EstadoCivilEnum;
import mx.agr.dgec.enums.GenerosEnum;
import mx.agr.dgec.generate.model.EstadoCivilEnumDto;
import mx.agr.dgec.generate.model.GeneroEnumDto;
import mx.agr.dgec.generate.model.RegistrosDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;


@Mapper
public interface PersonaMapper {

    PersonaMapper INSTANCE = Mappers.getMapper(PersonaMapper.class);

    EstadoCivilEnum estadoCivilEnumDtoToEstadoCivilEnum(EstadoCivilEnumDto estadoCivil);

    GenerosEnum generosEnumDtoToGenerosEnum(GeneroEnumDto genero);

    default List<RegistrosDto> estadosCivilesEnumToRegistrosDto(List<EstadoCivilEnum> estadosCiviles){
        return estadosCiviles.stream().map(estadoCivil -> new RegistrosDto(estadoCivil.name(), estadoCivil.getEstadoCivil())).toList();
    }

    default List<RegistrosDto> generosEnumToRegistrosDto(List<GenerosEnum> generos){
        return generos.stream().map(genero -> new RegistrosDto(genero.name(), genero.getGenero())).toList();
    }
}
