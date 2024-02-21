package mx.agr.dgec.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DomicilioMapper {
    DomicilioMapper INSTANCE = Mappers.getMapper(DomicilioMapper.class);
}
