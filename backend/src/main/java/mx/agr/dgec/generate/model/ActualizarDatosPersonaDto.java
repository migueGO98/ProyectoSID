package mx.agr.dgec.generate.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import mx.agr.dgec.generate.model.EstadoCivilEnumDto;
import mx.agr.dgec.generate.model.GeneroEnumDto;
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
 * ActualizarDatosPersonaDto
 */

@JsonTypeName("ActualizarDatosPersona")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
public class ActualizarDatosPersonaDto {

  private GeneroEnumDto genero;

  private String telefonoPersonal;

  private String correoElectronicoPersonal;

  private EstadoCivilEnumDto estadoCivil;

  private Boolean hijos = false;

  private String contactoEmergenciaNombre;

  private String contactoEmergenciaTelefono;

  public ActualizarDatosPersonaDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ActualizarDatosPersonaDto(GeneroEnumDto genero, String telefonoPersonal, String correoElectronicoPersonal, EstadoCivilEnumDto estadoCivil, Boolean hijos, String contactoEmergenciaNombre, String contactoEmergenciaTelefono) {
    this.genero = genero;
    this.telefonoPersonal = telefonoPersonal;
    this.correoElectronicoPersonal = correoElectronicoPersonal;
    this.estadoCivil = estadoCivil;
    this.hijos = hijos;
    this.contactoEmergenciaNombre = contactoEmergenciaNombre;
    this.contactoEmergenciaTelefono = contactoEmergenciaTelefono;
  }

  public ActualizarDatosPersonaDto genero(GeneroEnumDto genero) {
    this.genero = genero;
    return this;
  }

  /**
   * Get genero
   * @return genero
  */
  @NotNull @Valid 

  @Schema(name = "genero", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("genero")
  public GeneroEnumDto getGenero() {
    return genero;
  }

  public void setGenero(GeneroEnumDto genero) {
    this.genero = genero;
  }

  public ActualizarDatosPersonaDto telefonoPersonal(String telefonoPersonal) {
    this.telefonoPersonal = telefonoPersonal;
    return this;
  }

  /**
   * Get telefonoPersonal
   * @return telefonoPersonal
  */
  @NotNull @NotBlank @NumericOnly
@Size(min = 10, max = 10) 
  @Schema(name = "telefonoPersonal", example = "1234567890", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("telefonoPersonal")
  public String getTelefonoPersonal() {
    return telefonoPersonal;
  }

  public void setTelefonoPersonal(String telefonoPersonal) {
    this.telefonoPersonal = telefonoPersonal;
  }

  public ActualizarDatosPersonaDto correoElectronicoPersonal(String correoElectronicoPersonal) {
    this.correoElectronicoPersonal = correoElectronicoPersonal;
    return this;
  }

  /**
   * Get correoElectronicoPersonal
   * @return correoElectronicoPersonal
  */
  @NotNull @NotBlank
@jakarta.validation.constraints.Email 
  @Schema(name = "correoElectronicoPersonal", example = "user@example.com", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("correoElectronicoPersonal")
  public String getCorreoElectronicoPersonal() {
    return correoElectronicoPersonal;
  }

  public void setCorreoElectronicoPersonal(String correoElectronicoPersonal) {
    this.correoElectronicoPersonal = correoElectronicoPersonal;
  }

  public ActualizarDatosPersonaDto estadoCivil(EstadoCivilEnumDto estadoCivil) {
    this.estadoCivil = estadoCivil;
    return this;
  }

  /**
   * Get estadoCivil
   * @return estadoCivil
  */
  @NotNull @Valid 

  @Schema(name = "estadoCivil", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("estadoCivil")
  public EstadoCivilEnumDto getEstadoCivil() {
    return estadoCivil;
  }

  public void setEstadoCivil(EstadoCivilEnumDto estadoCivil) {
    this.estadoCivil = estadoCivil;
  }

  public ActualizarDatosPersonaDto hijos(Boolean hijos) {
    this.hijos = hijos;
    return this;
  }

  /**
   * Get hijos
   * @return hijos
  */
  @NotNull 

  @Schema(name = "hijos", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("hijos")
  public Boolean getHijos() {
    return hijos;
  }

  public void setHijos(Boolean hijos) {
    this.hijos = hijos;
  }

  public ActualizarDatosPersonaDto contactoEmergenciaNombre(String contactoEmergenciaNombre) {
    this.contactoEmergenciaNombre = contactoEmergenciaNombre;
    return this;
  }

  /**
   * Get contactoEmergenciaNombre
   * @return contactoEmergenciaNombre
  */
  @NotNull @NotBlank
@Pattern(regexp = "^[\\p{L}\\s'-ñÑÁÉÍÓÚáéíóú]+$") 
  @Schema(name = "contactoEmergenciaNombre", example = "Martina Estrada Martínez", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("contactoEmergenciaNombre")
  public String getContactoEmergenciaNombre() {
    return contactoEmergenciaNombre;
  }

  public void setContactoEmergenciaNombre(String contactoEmergenciaNombre) {
    this.contactoEmergenciaNombre = contactoEmergenciaNombre;
  }

  public ActualizarDatosPersonaDto contactoEmergenciaTelefono(String contactoEmergenciaTelefono) {
    this.contactoEmergenciaTelefono = contactoEmergenciaTelefono;
    return this;
  }

  /**
   * Get contactoEmergenciaTelefono
   * @return contactoEmergenciaTelefono
  */
  @NotNull @NotBlank @NumericOnly
@Size(min = 10, max = 10) 
  @Schema(name = "contactoEmergenciaTelefono", example = "9876543210", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("contactoEmergenciaTelefono")
  public String getContactoEmergenciaTelefono() {
    return contactoEmergenciaTelefono;
  }

  public void setContactoEmergenciaTelefono(String contactoEmergenciaTelefono) {
    this.contactoEmergenciaTelefono = contactoEmergenciaTelefono;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActualizarDatosPersonaDto actualizarDatosPersona = (ActualizarDatosPersonaDto) o;
    return Objects.equals(this.genero, actualizarDatosPersona.genero) &&
        Objects.equals(this.telefonoPersonal, actualizarDatosPersona.telefonoPersonal) &&
        Objects.equals(this.correoElectronicoPersonal, actualizarDatosPersona.correoElectronicoPersonal) &&
        Objects.equals(this.estadoCivil, actualizarDatosPersona.estadoCivil) &&
        Objects.equals(this.hijos, actualizarDatosPersona.hijos) &&
        Objects.equals(this.contactoEmergenciaNombre, actualizarDatosPersona.contactoEmergenciaNombre) &&
        Objects.equals(this.contactoEmergenciaTelefono, actualizarDatosPersona.contactoEmergenciaTelefono);
  }

  @Override
  public int hashCode() {
    return Objects.hash(genero, telefonoPersonal, correoElectronicoPersonal, estadoCivil, hijos, contactoEmergenciaNombre, contactoEmergenciaTelefono);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActualizarDatosPersonaDto {\n");
    sb.append("    genero: ").append(toIndentedString(genero)).append("\n");
    sb.append("    telefonoPersonal: ").append(toIndentedString(telefonoPersonal)).append("\n");
    sb.append("    correoElectronicoPersonal: ").append(toIndentedString(correoElectronicoPersonal)).append("\n");
    sb.append("    estadoCivil: ").append(toIndentedString(estadoCivil)).append("\n");
    sb.append("    hijos: ").append(toIndentedString(hijos)).append("\n");
    sb.append("    contactoEmergenciaNombre: ").append(toIndentedString(contactoEmergenciaNombre)).append("\n");
    sb.append("    contactoEmergenciaTelefono: ").append(toIndentedString(contactoEmergenciaTelefono)).append("\n");
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

