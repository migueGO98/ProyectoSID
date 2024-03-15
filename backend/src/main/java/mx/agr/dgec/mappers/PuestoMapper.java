package mx.agr.dgec.mappers;

import mx.agr.dgec.entidades.Puesto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PuestoMapper {

    PuestoMapper INSTANCE = Mappers.getMapper(PuestoMapper.class);

    default String puestoToIdPuesto(Puesto puesto) {
        return puesto.getIdPuesto();
    }
}
