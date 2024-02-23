package mx.agr.dgec.generate.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets EstadoCivilEnum
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public enum EstadoCivilEnumDto {
  
  CASADO("CASADO"),
  
  CASADA("CASADA"),
  
  SOLTERO("SOLTERO"),
  
  SOLTERA("SOLTERA"),
  
  VIUDO("VIUDO"),
  
  VIUDA("VIUDA"),
  
  SEPARADO("SEPARADO"),
  
  SEPARADA("SEPARADA"),
  
  DIVORCIADO("DIVORCIADO"),
  
  DIVORCIADA("DIVORCIADA"),
  
  UNION_LIBRE("UNION_LIBRE");

  private String value;

  EstadoCivilEnumDto(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static EstadoCivilEnumDto fromValue(String value) {
    for (EstadoCivilEnumDto b : EstadoCivilEnumDto.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

