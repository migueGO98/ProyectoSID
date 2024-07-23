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
 * RegionDto
 */

@JsonTypeName("Region")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
public class RegionDto {

  private String idRegion;

  private String descripcion;

  public RegionDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public RegionDto(String idRegion, String descripcion) {
    this.idRegion = idRegion;
    this.descripcion = descripcion;
  }

  public RegionDto idRegion(String idRegion) {
    this.idRegion = idRegion;
    return this;
  }

  /**
   * Get idRegion
   * @return idRegion
  */
  @NotNull 

  @Schema(name = "idRegion", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("idRegion")
  public String getIdRegion() {
    return idRegion;
  }

  public void setIdRegion(String idRegion) {
    this.idRegion = idRegion;
  }

  public RegionDto descripcion(String descripcion) {
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
    RegionDto region = (RegionDto) o;
    return Objects.equals(this.idRegion, region.idRegion) &&
        Objects.equals(this.descripcion, region.descripcion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idRegion, descripcion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegionDto {\n");
    sb.append("    idRegion: ").append(toIndentedString(idRegion)).append("\n");
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

