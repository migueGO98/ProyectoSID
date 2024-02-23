package mx.agr.dgec.mappers;

import mx.agr.dgec.enums.TipoPlazaEnum;
import mx.agr.dgec.generate.model.TipoPlazaEnumDto;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TipoPlazaMapper {
    TipoPlazaMapper INSTANCE = Mappers.getMapper(TipoPlazaMapper.class);

    @ValueMapping(source = "SP", target = "SP")
    @ValueMapping(source = "EE", target = "EE")
    @ValueMapping(source = "INCA", target = "INCA")
    TipoPlazaEnum toTipoPlazaEnum(TipoPlazaEnumDto tipoPlazaEnumDto);

    @ValueMapping(source = "SP", target = "SP")
    @ValueMapping(source = "EE", target = "EE")
    @ValueMapping(source = "INCA", target = "INCA")
    TipoPlazaEnumDto toTipoPlazaEnumDto(TipoPlazaEnum tipoPlazaEnum);

}
