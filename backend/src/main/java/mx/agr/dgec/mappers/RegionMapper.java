package mx.agr.dgec.mappers;

import mx.agr.dgec.entidades.Region;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegionMapper {

    RegionMapper INSTANCE = Mappers.getMapper(RegionMapper.class);

    default String regionToIdRegion(Region region){
        return region.getIdRegion();
    }
}
