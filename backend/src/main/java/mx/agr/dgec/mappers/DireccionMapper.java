package mx.agr.dgec.mappers;

import mx.agr.dgec.entidades.Direccion;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DireccionMapper {

    DireccionMapper INSTANCE = Mappers.getMapper(DireccionMapper.class);

    default String direccionToIdDireccion(Direccion direccion){
        return direccion.getIdDireccion();
    }
}
