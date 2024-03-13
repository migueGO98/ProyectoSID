package mx.agr.dgec.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.openapitools.jackson.nullable.JsonNullable;

@Mapper
public interface JsonNullableMapper {

    JsonNullableMapper INSTANCE = Mappers.getMapper(JsonNullableMapper.class);

    default <T> T mapJsonNullableToGeneric(JsonNullable<T> campoDto) {
        return campoDto.orElse(null);
    }

}
