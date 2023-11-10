package mx.agr.dgec.generate.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import mx.agr.dgec.generate.model.EstadoCedulaProfesionalEscolaridad;
import mx.agr.dgec.generate.model.EstadoNivelEscolaridad;
import mx.agr.dgec.generate.model.NivelEscolaridad;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Escolaridades que tiene una persona
 */

@Schema(name = "EscolaridadDto", description = "Escolaridades que tiene una persona")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class EscolaridadDto {

  private NivelEscolaridad nivel;

  private String carrera;

  private EstadoNivelEscolaridad estadoNivel;

  private EstadoCedulaProfesionalEscolaridad estadoCedulaProfesional;

  private String numeroCedulaProfesional;

  public EscolaridadDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public EscolaridadDto(NivelEscolaridad nivel, String carrera, EstadoNivelEscolaridad estadoNivel, EstadoCedulaProfesionalEscolaridad estadoCedulaProfesional, String numeroCedulaProfesional) {
    this.nivel = nivel;
    this.carrera = carrera;
    this.estadoNivel = estadoNivel;
    this.estadoCedulaProfesional = estadoCedulaProfesional;
    this.numeroCedulaProfesional = numeroCedulaProfesional;
  }

  public EscolaridadDto nivel(NivelEscolaridad nivel) {
    this.nivel = nivel;
    return this;
  }

  /**
   * Get nivel
   * @return nivel
  */
  @NotNull @Valid 
  @Schema(name = "nivel", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nivel")
  public NivelEscolaridad getNivel() {
    return nivel;
  }

  public void setNivel(NivelEscolaridad nivel) {
    this.nivel = nivel;
  }

  public EscolaridadDto carrera(String carrera) {
    this.carrera = carrera;
    return this;
  }

  /**
   * Get carrera
   * @return carrera
  */
  @NotNull 
  @Schema(name = "carrera", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("carrera")
  public String getCarrera() {
    return carrera;
  }

  public void setCarrera(String carrera) {
    this.carrera = carrera;
  }

  public EscolaridadDto estadoNivel(EstadoNivelEscolaridad estadoNivel) {
    this.estadoNivel = estadoNivel;
    return this;
  }

  /**
   * Get estadoNivel
   * @return estadoNivel
  */
  @NotNull @Valid 
  @Schema(name = "estadoNivel", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("estadoNivel")
  public EstadoNivelEscolaridad getEstadoNivel() {
    return estadoNivel;
  }

  public void setEstadoNivel(EstadoNivelEscolaridad estadoNivel) {
    this.estadoNivel = estadoNivel;
  }

  public EscolaridadDto estadoCedulaProfesional(EstadoCedulaProfesionalEscolaridad estadoCedulaProfesional) {
    this.estadoCedulaProfesional = estadoCedulaProfesional;
    return this;
  }

  /**
   * Get estadoCedulaProfesional
   * @return estadoCedulaProfesional
  */
  @NotNull @Valid 
  @Schema(name = "estadoCedulaProfesional", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("estadoCedulaProfesional")
  public EstadoCedulaProfesionalEscolaridad getEstadoCedulaProfesional() {
    return estadoCedulaProfesional;
  }

  public void setEstadoCedulaProfesional(EstadoCedulaProfesionalEscolaridad estadoCedulaProfesional) {
    this.estadoCedulaProfesional = estadoCedulaProfesional;
  }

  public EscolaridadDto numeroCedulaProfesional(String numeroCedulaProfesional) {
    this.numeroCedulaProfesional = numeroCedulaProfesional;
    return this;
  }

  /**
   * Get numeroCedulaProfesional
   * @return numeroCedulaProfesional
  */
  @NotNull @Size(min = 7, max = 8) 
  @Schema(name = "numeroCedulaProfesional", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("numeroCedulaProfesional")
  public String getNumeroCedulaProfesional() {
    return numeroCedulaProfesional;
  }

  public void setNumeroCedulaProfesional(String numeroCedulaProfesional) {
    this.numeroCedulaProfesional = numeroCedulaProfesional;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EscolaridadDto escolaridadDto = (EscolaridadDto) o;
    return Objects.equals(this.nivel, escolaridadDto.nivel) &&
        Objects.equals(this.carrera, escolaridadDto.carrera) &&
        Objects.equals(this.estadoNivel, escolaridadDto.estadoNivel) &&
        Objects.equals(this.estadoCedulaProfesional, escolaridadDto.estadoCedulaProfesional) &&
        Objects.equals(this.numeroCedulaProfesional, escolaridadDto.numeroCedulaProfesional);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nivel, carrera, estadoNivel, estadoCedulaProfesional, numeroCedulaProfesional);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EscolaridadDto {\n");
    sb.append("    nivel: ").append(toIndentedString(nivel)).append("\n");
    sb.append("    carrera: ").append(toIndentedString(carrera)).append("\n");
    sb.append("    estadoNivel: ").append(toIndentedString(estadoNivel)).append("\n");
    sb.append("    estadoCedulaProfesional: ").append(toIndentedString(estadoCedulaProfesional)).append("\n");
    sb.append("    numeroCedulaProfesional: ").append(toIndentedString(numeroCedulaProfesional)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

