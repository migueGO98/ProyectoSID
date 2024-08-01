package mx.agr.dgec.mappers;

import mx.agr.dgec.entidades.Subdireccion;
import mx.agr.dgec.entidades.TipoPlaza;
import mx.agr.dgec.generate.model.RegistrosDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface TipoPlazaMapper {

    TipoPlazaMapper INSTANCE = Mappers.getMapper(TipoPlazaMapper.class);

    default List<RegistrosDto> tiposPlazasToRegistrosDto(List<TipoPlaza> tiposPlazas){
        return tiposPlazas.stream().map(tipoPlaza -> new RegistrosDto(tipoPlaza.getIdTipoPlaza(), tipoPlaza.getNombre())).toList();
    }

}
