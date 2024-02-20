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
 * Estado que tiene una escolaridad
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public enum EstadoEscolaridadEnumDto {
  
  CREDITOS_CUBIERTOS("CREDITOS_CUBIERTOS"),
  
  CERTIFICADO("CERTIFICADO"),
  
  PASANTE("PASANTE"),
  
  TITULADO("TITULADO"),
  
  TRAMITE_TITULACION("TRAMITE_TITULACION"),
  
  TRUNCA("TRUNCA");

  private String value;

  EstadoEscolaridadEnumDto(String value) {
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
  public static EstadoEscolaridadEnumDto fromValue(String value) {
    for (EstadoEscolaridadEnumDto b : EstadoEscolaridadEnumDto.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

