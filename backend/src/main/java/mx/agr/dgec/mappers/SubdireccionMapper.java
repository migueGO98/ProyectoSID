package mx.agr.dgec.mappers;

import mx.agr.dgec.entidades.Subdireccion;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubdireccionMapper {

    SubdireccionMapper INSTANCE = Mappers.getMapper(SubdireccionMapper.class);

    default String subdireccionToIdSubdireccion(Subdireccion subdireccion) {
        return subdireccion.getIdSubdireccion();
    }
}
