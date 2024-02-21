package mx.agr.dgec.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PuestoMapper {
    PuestoMapper INSTANCE = Mappers.getMapper(PuestoMapper.class);
}
