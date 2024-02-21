package mx.agr.dgec.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegionMapper {
    RegionMapper INSTANCE = Mappers.getMapper(RegionMapper.class);
}
