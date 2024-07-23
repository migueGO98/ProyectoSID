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
 * DireccionDto
 */

@JsonTypeName("Direccion")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
public class DireccionDto {

  private String idDireccion;

  private String descripcion;

  public DireccionDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DireccionDto(String idDireccion, String descripcion) {
    this.idDireccion = idDireccion;
    this.descripcion = descripcion;
  }

  public DireccionDto idDireccion(String idDireccion) {
    this.idDireccion = idDireccion;
    return this;
  }

  /**
   * Get idDireccion
   * @return idDireccion
  */
  @NotNull 

  @Schema(name = "idDireccion", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("idDireccion")
  public String getIdDireccion() {
    return idDireccion;
  }

  public void setIdDireccion(String idDireccion) {
    this.idDireccion = idDireccion;
  }

  public DireccionDto descripcion(String descripcion) {
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
    DireccionDto direccion = (DireccionDto) o;
    return Objects.equals(this.idDireccion, direccion.idDireccion) &&
        Objects.equals(this.descripcion, direccion.descripcion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idDireccion, descripcion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DireccionDto {\n");
    sb.append("    idDireccion: ").append(toIndentedString(idDireccion)).append("\n");
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

