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
 * DomicilioDto
 */

@JsonTypeName("Domicilio")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
public class DomicilioDto {

  private String calle;

  private String codigoPostal;

  private String colonia;

  private String municipio;

  private String ciudad;

  private String estado;

  public DomicilioDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DomicilioDto(String calle, String codigoPostal, String colonia, String municipio, String ciudad, String estado) {
    this.calle = calle;
    this.codigoPostal = codigoPostal;
    this.colonia = colonia;
    this.municipio = municipio;
    this.ciudad = ciudad;
    this.estado = estado;
  }

  public DomicilioDto calle(String calle) {
    this.calle = calle;
    return this;
  }

  /**
   * Get calle
   * @return calle
  */
  @NotNull @NotBlank @NotEmpty
@Pattern(regexp = "^[\\p{L}\\s'-ñÑÁÉÍÓÚáéíóú]+$") 
  @Schema(name = "calle", example = "Izta No 40", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("calle")
  public String getCalle() {
    return calle;
  }

  public void setCalle(String calle) {
    this.calle = calle;
  }

  public DomicilioDto codigoPostal(String codigoPostal) {
    this.codigoPostal = codigoPostal;
    return this;
  }

  /**
   * Get codigoPostal
   * @return codigoPostal
  */
  @NotNull @NotBlank @NotEmpty @NumericOnly
@Size(min = 5, max = 5) 
  @Schema(name = "codigoPostal", example = "01111", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("codigoPostal")
  public String getCodigoPostal() {
    return codigoPostal;
  }

  public void setCodigoPostal(String codigoPostal) {
    this.codigoPostal = codigoPostal;
  }

  public DomicilioDto colonia(String colonia) {
    this.colonia = colonia;
    return this;
  }

  /**
   * Get colonia
   * @return colonia
  */
  @NotNull @NotBlank @NotEmpty
@Pattern(regexp = "^[\\p{L}\\s'-ñÑÁÉÍÓÚáéíóú]+$") 
  @Schema(name = "colonia", example = "Prolongación de Noñora", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("colonia")
  public String getColonia() {
    return colonia;
  }

  public void setColonia(String colonia) {
    this.colonia = colonia;
  }

  public DomicilioDto municipio(String municipio) {
    this.municipio = municipio;
    return this;
  }

  /**
   * Get municipio
   * @return municipio
  */
  @NotNull @NotBlank @NotEmpty
@Pattern(regexp = "^[\\p{L}\\s'-ñÑÁÉÍÓÚáéíóú]+$") 
  @Schema(name = "municipio", example = "Gustavo A. Madero", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("municipio")
  public String getMunicipio() {
    return municipio;
  }

  public void setMunicipio(String municipio) {
    this.municipio = municipio;
  }

  public DomicilioDto ciudad(String ciudad) {
    this.ciudad = ciudad;
    return this;
  }

  /**
   * Get ciudad
   * @return ciudad
  */
  @NotNull @NotBlank @NotEmpty
@Pattern(regexp = "^[\\p{L}\\s'-ñÑÁÉÍÓÚáéíóú]+$") 
  @Schema(name = "ciudad", example = "Ciudad de México", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("ciudad")
  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public DomicilioDto estado(String estado) {
    this.estado = estado;
    return this;
  }

  /**
   * Get estado
   * @return estado
  */
  @NotNull @NotBlank @NotEmpty
@Pattern(regexp = "^[\\p{L}\\s'-ñÑÁÉÍÓÚáéíóú]+$") 
  @Schema(name = "estado", example = "Ciudad de México", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("estado")
  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DomicilioDto domicilio = (DomicilioDto) o;
    return Objects.equals(this.calle, domicilio.calle) &&
        Objects.equals(this.codigoPostal, domicilio.codigoPostal) &&
        Objects.equals(this.colonia, domicilio.colonia) &&
        Objects.equals(this.municipio, domicilio.municipio) &&
        Objects.equals(this.ciudad, domicilio.ciudad) &&
        Objects.equals(this.estado, domicilio.estado);
  }

  @Override
  public int hashCode() {
    return Objects.hash(calle, codigoPostal, colonia, municipio, ciudad, estado);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DomicilioDto {\n");
    sb.append("    calle: ").append(toIndentedString(calle)).append("\n");
    sb.append("    codigoPostal: ").append(toIndentedString(codigoPostal)).append("\n");
    sb.append("    colonia: ").append(toIndentedString(colonia)).append("\n");
    sb.append("    municipio: ").append(toIndentedString(municipio)).append("\n");
    sb.append("    ciudad: ").append(toIndentedString(ciudad)).append("\n");
    sb.append("    estado: ").append(toIndentedString(estado)).append("\n");
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

