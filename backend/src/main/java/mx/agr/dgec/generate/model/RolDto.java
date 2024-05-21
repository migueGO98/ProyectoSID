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
 * RolDto
 */

@JsonTypeName("Rol")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
public class RolDto {

  private String idRol;

  private String descripcion;

  public RolDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public RolDto(String idRol, String descripcion) {
    this.idRol = idRol;
    this.descripcion = descripcion;
  }

  public RolDto idRol(String idRol) {
    this.idRol = idRol;
    return this;
  }

  /**
   * Get idRol
   * @return idRol
  */
  @NotNull 

  @Schema(name = "idRol", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("idRol")
  public String getIdRol() {
    return idRol;
  }

  public void setIdRol(String idRol) {
    this.idRol = idRol;
  }

  public RolDto descripcion(String descripcion) {
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
    RolDto rol = (RolDto) o;
    return Objects.equals(this.idRol, rol.idRol) &&
        Objects.equals(this.descripcion, rol.descripcion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idRol, descripcion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RolDto {\n");
    sb.append("    idRol: ").append(toIndentedString(idRol)).append("\n");
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

