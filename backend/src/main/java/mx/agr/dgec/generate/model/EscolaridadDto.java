package mx.agr.dgec.generate.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import mx.agr.dgec.generate.model.EstadosNivelesEscolaridadesEnumDto;
import mx.agr.dgec.generate.model.NivelesEscolaridadesEnumDto;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import mx.agr.dgec.validators.annotation.*;
import mx.agr.dgec.validators.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * EscolaridadDto
 */

@JsonTypeName("Escolaridad")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
public class EscolaridadDto {

  private NivelesEscolaridadesEnumDto nivel;

  private String carrera;

  private EstadosNivelesEscolaridadesEnumDto estadoNivel;

  private JsonNullable<@NotBlank @NotEmpty @NumericOnly
@Size(min = 7, max = 8) String> cedulaProfesional = JsonNullable.<String>undefined();

  public EscolaridadDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public EscolaridadDto(NivelesEscolaridadesEnumDto nivel, String carrera, EstadosNivelesEscolaridadesEnumDto estadoNivel, String cedulaProfesional) {
    this.nivel = nivel;
    this.carrera = carrera;
    this.estadoNivel = estadoNivel;
    this.cedulaProfesional = JsonNullable.of(cedulaProfesional);
  }

  public EscolaridadDto nivel(NivelesEscolaridadesEnumDto nivel) {
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
  public NivelesEscolaridadesEnumDto getNivel() {
    return nivel;
  }

  public void setNivel(NivelesEscolaridadesEnumDto nivel) {
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
  @NotNull @NotNull @NotBlank @NotEmpty
@Pattern(regexp = "^[\\p{L}\\s'-ñÑÁÉÍÓÚáéíóú]+$") 
  @Schema(name = "carrera", example = "Licenciatura en Computación", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("carrera")
  public String getCarrera() {
    return carrera;
  }

  public void setCarrera(String carrera) {
    this.carrera = carrera;
  }

  public EscolaridadDto estadoNivel(EstadosNivelesEscolaridadesEnumDto estadoNivel) {
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
  public EstadosNivelesEscolaridadesEnumDto getEstadoNivel() {
    return estadoNivel;
  }

  public void setEstadoNivel(EstadosNivelesEscolaridadesEnumDto estadoNivel) {
    this.estadoNivel = estadoNivel;
  }

  public EscolaridadDto cedulaProfesional(String cedulaProfesional) {
    this.cedulaProfesional = JsonNullable.of(cedulaProfesional);
    return this;
  }

  /**
   * Get cedulaProfesional
   * @return cedulaProfesional
  */
  @NotNull @NotBlank @NotEmpty @NumericOnly
@Size(min = 7, max = 8) 
  @Schema(name = "cedulaProfesional", example = "12345678", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("cedulaProfesional")
  public JsonNullable<@NotBlank @NotEmpty @NumericOnly
@Size(min = 7, max = 8) String> getCedulaProfesional() {
    return cedulaProfesional;
  }

  public void setCedulaProfesional(JsonNullable<String> cedulaProfesional) {
    this.cedulaProfesional = cedulaProfesional;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EscolaridadDto escolaridad = (EscolaridadDto) o;
    return Objects.equals(this.nivel, escolaridad.nivel) &&
        Objects.equals(this.carrera, escolaridad.carrera) &&
        Objects.equals(this.estadoNivel, escolaridad.estadoNivel) &&
        Objects.equals(this.cedulaProfesional, escolaridad.cedulaProfesional);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nivel, carrera, estadoNivel, cedulaProfesional);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EscolaridadDto {\n");
    sb.append("    nivel: ").append(toIndentedString(nivel)).append("\n");
    sb.append("    carrera: ").append(toIndentedString(carrera)).append("\n");
    sb.append("    estadoNivel: ").append(toIndentedString(estadoNivel)).append("\n");
    sb.append("    cedulaProfesional: ").append(toIndentedString(cedulaProfesional)).append("\n");
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

