package mx.agr.dgec.mappers;

import mx.agr.dgec.enums.EstadoCivilEnum;
import mx.agr.dgec.enums.GenerosEnum;
import mx.agr.dgec.generate.model.EstadoCivilEnumDto;
import mx.agr.dgec.generate.model.GeneroEnumDto;
import mx.agr.dgec.generate.model.RegistrosDto;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface PersonaMapper {

    PersonaMapper INSTANCE = Mappers.getMapper(PersonaMapper.class);

    @ValueMapping(source = "CASADO", target = "CASADO")
    @ValueMapping(source = "CASADA", target = "CASADA")
    @ValueMapping(source = "SOLTERO", target = "SOLTERO")
    @ValueMapping(source = "SOLTERA", target = "SOLTERA")
    @ValueMapping(source = "VIUDO", target = "VIUDO")
    @ValueMapping(source = "VIUDA", target = "VIUDA")
    @ValueMapping(source = "SEPARADO", target = "SEPARADO")
    @ValueMapping(source = "SEPARADA", target = "SEPARADA")
    @ValueMapping(source = "DIVORCIADO", target = "DIVORCIADO")
    @ValueMapping(source = "DIVORCIADA", target = "DIVORCIADA")
    @ValueMapping(source = "UNION_LIBRE", target = "UNION_LIBRE")
    EstadoCivilEnum toEstadoCivilEnum(EstadoCivilEnumDto estadoCivil);

    @ValueMapping(source = "MASCULINO", target = "MASCULINO")
    @ValueMapping(source = "FEMENINO", target = "FEMENINO")
    @ValueMapping(source = "NO_BINARIO", target = "NO_BINARIO")
    @ValueMapping(source = "NO_DECIRLO", target = "NO_DECIRLO")
    GenerosEnum toGenerosEnum(GeneroEnumDto genero);

    default List<RegistrosDto> estadosCivilesEnumToRegistrosDto(List<EstadoCivilEnum> estadosCiviles){
        return estadosCiviles.stream().map(estadoCivil -> new RegistrosDto(estadoCivil.name(), estadoCivil.getEstadoCivil())).toList();
    }

    default List<RegistrosDto> generosEnumToRegistrosDto(List<GenerosEnum> generos){
        return generos.stream().map(genero -> new RegistrosDto(genero.name(), genero.getGenero())).toList();
    }
}
