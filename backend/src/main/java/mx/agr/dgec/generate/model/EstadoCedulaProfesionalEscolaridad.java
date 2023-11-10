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
 * Estados que puede tener la cédula profesional
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public enum EstadoCedulaProfesionalEscolaridad {
  
  N_A("N/A"),
  
  SIN_CEDULA("Sin cedula"),
  
  TRAMITE("Tramite"),
  
  CON_CEDULA("Con cedula");

  private String value;

  EstadoCedulaProfesionalEscolaridad(String value) {
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
  public static EstadoCedulaProfesionalEscolaridad fromValue(String value) {
    for (EstadoCedulaProfesionalEscolaridad b : EstadoCedulaProfesionalEscolaridad.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

