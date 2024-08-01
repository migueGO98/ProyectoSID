package mx.agr.dgec.mappers;

import mx.agr.dgec.entidades.Region;
import mx.agr.dgec.generate.model.RegionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RegionMapper {

    RegionMapper INSTANCE = Mappers.getMapper(RegionMapper.class);

    @Mapping(source = "nombre", target = "descripcion")
    RegionDto regionToRegionDto(Region region);

    List<RegionDto> listRegionesToListRegionesDto(List<Region> regiones);
}
