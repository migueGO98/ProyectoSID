package mx.agr.dgec.mappers;

import mx.agr.dgec.entidades.Escolaridad;
import mx.agr.dgec.generate.model.EscolaridadDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface EscolaridadMapper {
    EscolaridadMapper INSTANCE = Mappers.getMapper(EscolaridadMapper.class);
}
