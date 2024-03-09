package mx.agr.dgec.mappers;

import mx.agr.dgec.entidades.Domicilio;
import mx.agr.dgec.generate.model.DomicilioDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DomicilioMapper {
    DomicilioMapper INSTANCE = Mappers.getMapper(DomicilioMapper.class);

    Domicilio domicilioDtoToDomicilio(String idEmpleado, DomicilioDto domicilioDto);
}
