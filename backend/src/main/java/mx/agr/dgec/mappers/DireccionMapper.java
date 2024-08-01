package mx.agr.dgec.mappers;

import mx.agr.dgec.entidades.Direccion;
import mx.agr.dgec.generate.model.DireccionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DireccionMapper {

    DireccionMapper INSTANCE = Mappers.getMapper(DireccionMapper.class);

    @Mapping(target = "descripcion", source = "nombre")
    DireccionDto direccionToDireccionDto(Direccion direccion);

    List<DireccionDto> listDireccionesToListDireccionesDto(List<Direccion> direcciones);

}
