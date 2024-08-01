package mx.agr.dgec.mappers;

import mx.agr.dgec.entidades.Subdireccion;
import mx.agr.dgec.generate.model.SubdireccionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubdireccionMapper {

    SubdireccionMapper INSTANCE = Mappers.getMapper(SubdireccionMapper.class);

    @Mapping(target = "descripcion", source = "nombre")
    SubdireccionDto subdireccionToSubdireccionDto(Subdireccion subdireccion);

    List<SubdireccionDto> listSubdireccionesToListSubdireccionesDto(List<Subdireccion> subdirecciones);
}
