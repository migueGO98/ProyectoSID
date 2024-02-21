package mx.agr.dgec.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DireccionMapper {
    DireccionMapper INSTANCE = Mappers.getMapper(DireccionMapper.class);
}
