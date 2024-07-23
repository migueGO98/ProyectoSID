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
 * SubdireccionDto
 */

@JsonTypeName("Subdireccion")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
public class SubdireccionDto {

  private String idSubdireccion;

  private String descripcion;

  public SubdireccionDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SubdireccionDto(String idSubdireccion, String descripcion) {
    this.idSubdireccion = idSubdireccion;
    this.descripcion = descripcion;
  }

  public SubdireccionDto idSubdireccion(String idSubdireccion) {
    this.idSubdireccion = idSubdireccion;
    return this;
  }

  /**
   * Get idSubdireccion
   * @return idSubdireccion
  */
  @NotNull 

  @Schema(name = "idSubdireccion", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("idSubdireccion")
  public String getIdSubdireccion() {
    return idSubdireccion;
  }

  public void setIdSubdireccion(String idSubdireccion) {
    this.idSubdireccion = idSubdireccion;
  }

  public SubdireccionDto descripcion(String descripcion) {
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
    SubdireccionDto subdireccion = (SubdireccionDto) o;
    return Objects.equals(this.idSubdireccion, subdireccion.idSubdireccion) &&
        Objects.equals(this.descripcion, subdireccion.descripcion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idSubdireccion, descripcion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubdireccionDto {\n");
    sb.append("    idSubdireccion: ").append(toIndentedString(idSubdireccion)).append("\n");
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

