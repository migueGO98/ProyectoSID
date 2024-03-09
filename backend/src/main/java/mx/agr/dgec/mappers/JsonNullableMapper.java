package mx.agr.dgec.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.openapitools.jackson.nullable.JsonNullable;

@Mapper
public interface JsonNullableMapper {

    JsonNullableMapper INSTANCE = Mappers.getMapper(JsonNullableMapper.class);

    default String mapJsonNullableToGeneric(JsonNullable<String> campoDto) {
        return campoDto.orElse(null);
    }
}
