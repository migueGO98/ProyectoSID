package mx.agr.dgec.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EstadoMapper {
    EstadoMapper INSTANCE = Mappers.getMapper(EstadoMapper.class);
}
