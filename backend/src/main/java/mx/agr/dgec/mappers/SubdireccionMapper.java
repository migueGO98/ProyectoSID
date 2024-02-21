package mx.agr.dgec.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubdireccionMapper {
    SubdireccionMapper INSTANCE = Mappers.getMapper(SubdireccionMapper.class);
}
