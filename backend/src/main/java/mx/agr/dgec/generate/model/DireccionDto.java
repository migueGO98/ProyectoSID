package mx.agr.dgec.generate.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Dirección postal de la persona
 */

@Schema(name = "DireccionDto", description = "Dirección postal de la persona")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class DireccionDto {

  private String calle;

  private String codigoPostal;

  private String colonia;

  private String municipio;

  private String estado;

  private String ciudad;

  public DireccionDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DireccionDto(String calle, String codigoPostal, String colonia, String municipio, String estado, String ciudad) {
    this.calle = calle;
    this.codigoPostal = codigoPostal;
    this.colonia = colonia;
    this.municipio = municipio;
    this.estado = estado;
    this.ciudad = ciudad;
  }

  public DireccionDto calle(String calle) {
    this.calle = calle;
    return this;
  }

  /**
   * Get calle
   * @return calle
  */
  @NotNull 
  @Schema(name = "calle", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("calle")
  public String getCalle() {
    return calle;
  }

  public void setCalle(String calle) {
    this.calle = calle;
  }

  public DireccionDto codigoPostal(String codigoPostal) {
    this.codigoPostal = codigoPostal;
    return this;
  }

  /**
   * Get codigoPostal
   * @return codigoPostal
  */
  @NotNull @Size(min = 5, max = 5) 
  @Schema(name = "codigoPostal", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("codigoPostal")
  public String getCodigoPostal() {
    return codigoPostal;
  }

  public void setCodigoPostal(String codigoPostal) {
    this.codigoPostal = codigoPostal;
  }

  public DireccionDto colonia(String colonia) {
    this.colonia = colonia;
    return this;
  }

  /**
   * Get colonia
   * @return colonia
  */
  @NotNull 
  @Schema(name = "colonia", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("colonia")
  public String getColonia() {
    return colonia;
  }

  public void setColonia(String colonia) {
    this.colonia = colonia;
  }

  public DireccionDto municipio(String municipio) {
    this.municipio = municipio;
    return this;
  }

  /**
   * Get municipio
   * @return municipio
  */
  @NotNull 
  @Schema(name = "municipio", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("municipio")
  public String getMunicipio() {
    return municipio;
  }

  public void setMunicipio(String municipio) {
    this.municipio = municipio;
  }

  public DireccionDto estado(String estado) {
    this.estado = estado;
    return this;
  }

  /**
   * Get estado
   * @return estado
  */
  @NotNull 
  @Schema(name = "estado", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("estado")
  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public DireccionDto ciudad(String ciudad) {
    this.ciudad = ciudad;
    return this;
  }

  /**
   * Get ciudad
   * @return ciudad
  */
  @NotNull 
  @Schema(name = "ciudad", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("ciudad")
  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DireccionDto direccionDto = (DireccionDto) o;
    return Objects.equals(this.calle, direccionDto.calle) &&
        Objects.equals(this.codigoPostal, direccionDto.codigoPostal) &&
        Objects.equals(this.colonia, direccionDto.colonia) &&
        Objects.equals(this.municipio, direccionDto.municipio) &&
        Objects.equals(this.estado, direccionDto.estado) &&
        Objects.equals(this.ciudad, direccionDto.ciudad);
  }

  @Override
  public int hashCode() {
    return Objects.hash(calle, codigoPostal, colonia, municipio, estado, ciudad);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DireccionDto {\n");
    sb.append("    calle: ").append(toIndentedString(calle)).append("\n");
    sb.append("    codigoPostal: ").append(toIndentedString(codigoPostal)).append("\n");
    sb.append("    colonia: ").append(toIndentedString(colonia)).append("\n");
    sb.append("    municipio: ").append(toIndentedString(municipio)).append("\n");
    sb.append("    estado: ").append(toIndentedString(estado)).append("\n");
    sb.append("    ciudad: ").append(toIndentedString(ciudad)).append("\n");
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

