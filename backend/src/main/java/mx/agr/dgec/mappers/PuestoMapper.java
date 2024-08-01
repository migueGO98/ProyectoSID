package mx.agr.dgec.mappers;

import mx.agr.dgec.entidades.Puesto;
import mx.agr.dgec.generate.model.PuestoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PuestoMapper {

    PuestoMapper INSTANCE = Mappers.getMapper(PuestoMapper.class);

    @Mapping(target = "descripcion", source = "nombre")
    PuestoDto puestoToPuestoDto(Puesto puesto);

    List<PuestoDto> listPuestosToListPuestosDto(List<Puesto> puestos);
}
