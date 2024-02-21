package mx.agr.dgec.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmpleadoMapper {
    EmpleadoMapper INSTANCE = Mappers.getMapper(EmpleadoMapper.class);
}
