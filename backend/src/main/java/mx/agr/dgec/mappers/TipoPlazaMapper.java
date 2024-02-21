package mx.agr.dgec.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TipoPlazaMapper {
    TipoPlazaMapper INSTANCE = Mappers.getMapper(TipoPlazaMapper.class);
}
