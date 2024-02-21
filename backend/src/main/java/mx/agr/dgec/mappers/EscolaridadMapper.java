package mx.agr.dgec.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EscolaridadMapper {
    EscolaridadMapper INSTANCE = Mappers.getMapper(EscolaridadMapper.class);
}
