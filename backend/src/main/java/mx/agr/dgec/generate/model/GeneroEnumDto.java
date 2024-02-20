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
 * Valores permitidos para el género de una persona.
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public enum GeneroEnumDto {
  
  MASCULINO("MASCULINO"),
  
  FEMENINO("FEMENINO"),
  
  NO_BINARIO("NO_BINARIO"),
  
  DESCONOCIDO("DESCONOCIDO");

  private String value;

  GeneroEnumDto(String value) {
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
  public static GeneroEnumDto fromValue(String value) {
    for (GeneroEnumDto b : GeneroEnumDto.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

