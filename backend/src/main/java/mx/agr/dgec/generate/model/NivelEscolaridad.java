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
 * Tipos de escolaridades que puede tener una persona
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public enum NivelEscolaridad {
  
  BACHILLERATO("Bachillerato"),
  
  TECNICO("Tecnico"),
  
  LICENCIATURA("Licenciatura"),
  
  MAESTRIA("Maestria"),
  
  DOCTORADO("Doctorado"),
  
  ESPECIALIDAD("Especialidad"),
  
  DIPLOMADO("Diplomado");

  private String value;

  NivelEscolaridad(String value) {
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
  public static NivelEscolaridad fromValue(String value) {
    for (NivelEscolaridad b : NivelEscolaridad.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

