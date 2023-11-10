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
 * Estados que puede tener la escolaridad
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public enum EstadoNivelEscolaridad {
  
  SIN_TITULO("Sin titulo"),
  
  PASANTE("Pasante"),
  
  CREDITOS_COMPLETOS("Creditos completos"),
  
  CERTIFICADO("Certificado"),
  
  TRAMITE("Tramite"),
  
  TITULADO("Titulado");

  private String value;

  EstadoNivelEscolaridad(String value) {
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
  public static EstadoNivelEscolaridad fromValue(String value) {
    for (EstadoNivelEscolaridad b : EstadoNivelEscolaridad.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

