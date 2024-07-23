package mx.agr.dgec.generate.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
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
 * PuestoDto
 */

@JsonTypeName("Puesto")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
public class PuestoDto {

  private String idPuesto;

  private String descripcion;

  public PuestoDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PuestoDto(String idPuesto, String descripcion) {
    this.idPuesto = idPuesto;
    this.descripcion = descripcion;
  }

  public PuestoDto idPuesto(String idPuesto) {
    this.idPuesto = idPuesto;
    return this;
  }

  /**
   * Get idPuesto
   * @return idPuesto
  */
  @NotNull 

  @Schema(name = "idPuesto", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("idPuesto")
  public String getIdPuesto() {
    return idPuesto;
  }

  public void setIdPuesto(String idPuesto) {
    this.idPuesto = idPuesto;
  }

  public PuestoDto descripcion(String descripcion) {
    this.descripcion = descripcion;
    return this;
  }

  /**
   * Get descripcion
   * @return descripcion
  */
  @NotNull 

  @Schema(name = "descripcion", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("descripcion")
  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PuestoDto puesto = (PuestoDto) o;
    return Objects.equals(this.idPuesto, puesto.idPuesto) &&
        Objects.equals(this.descripcion, puesto.descripcion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idPuesto, descripcion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PuestoDto {\n");
    sb.append("    idPuesto: ").append(toIndentedString(idPuesto)).append("\n");
    sb.append("    descripcion: ").append(toIndentedString(descripcion)).append("\n");
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

