package mx.agr.dgec.generate.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.LocalDate;
import mx.agr.dgec.generate.model.EstadoCivilEnumDto;
import mx.agr.dgec.generate.model.GeneroEnumDto;
import org.springframework.format.annotation.DateTimeFormat;
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
 * PersonaDto
 */

@JsonTypeName("Persona")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
public class PersonaDto {

  private String nombre;

  private String apellidoPaterno;

  private JsonNullable<@NotBlank
@Pattern(regexp = "^[\\p{L}\\s'-ñÑÁÉÍÓÚáéíóú]+$") String> apellidoMaterno = JsonNullable.<String>undefined();

  private String curp;

  private String rfc;

  private String numeroSeguroSocial;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate fechaNacimiento;

  private GeneroEnumDto genero;

  private String telefonoPersonal;

  private String correoElectronicoPersonal;

  private EstadoCivilEnumDto estadoCivil;

  private Boolean hijos = false;

  private String contactoEmergenciaNombre;

  private String contactoEmergenciaTelefono;

  public PersonaDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PersonaDto(String nombre, String apellidoPaterno, String apellidoMaterno, String curp, String rfc, String numeroSeguroSocial, LocalDate fechaNacimiento, GeneroEnumDto genero, String telefonoPersonal, String correoElectronicoPersonal, EstadoCivilEnumDto estadoCivil, Boolean hijos, String contactoEmergenciaNombre, String contactoEmergenciaTelefono) {
    this.nombre = nombre;
    this.apellidoPaterno = apellidoPaterno;
    this.apellidoMaterno = JsonNullable.of(apellidoMaterno);
    this.curp = curp;
    this.rfc = rfc;
    this.numeroSeguroSocial = numeroSeguroSocial;
    this.fechaNacimiento = fechaNacimiento;
    this.genero = genero;
    this.telefonoPersonal = telefonoPersonal;
    this.correoElectronicoPersonal = correoElectronicoPersonal;
    this.estadoCivil = estadoCivil;
    this.hijos = hijos;
    this.contactoEmergenciaNombre = contactoEmergenciaNombre;
    this.contactoEmergenciaTelefono = contactoEmergenciaTelefono;
  }

  public PersonaDto nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * Get nombre
   * @return nombre
  */
  @NotNull @NotBlank
@Pattern(regexp = "^[\\p{L}\\s'-ñÑÁÉÍÓÚáéíóú]+$") 
  @Schema(name = "nombre", example = "Fabian Carlos", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nombre")
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public PersonaDto apellidoPaterno(String apellidoPaterno) {
    this.apellidoPaterno = apellidoPaterno;
    return this;
  }

  /**
   * Get apellidoPaterno
   * @return apellidoPaterno
  */
  @NotNull @NotBlank
@Pattern(regexp = "^[\\p{L}\\s'-ñÑÁÉÍÓÚáéíóú]+$") 
  @Schema(name = "apellidoPaterno", example = "de la López", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("apellidoPaterno")
  public String getApellidoPaterno() {
    return apellidoPaterno;
  }

  public void setApellidoPaterno(String apellidoPaterno) {
    this.apellidoPaterno = apellidoPaterno;
  }

  public PersonaDto apellidoMaterno(String apellidoMaterno) {
    this.apellidoMaterno = JsonNullable.of(apellidoMaterno);
    return this;
  }

  /**
   * Get apellidoMaterno
   * @return apellidoMaterno
  */
  @NotNull @NotBlank
@Pattern(regexp = "^[\\p{L}\\s'-ñÑÁÉÍÓÚáéíóú]+$") 
  @Schema(name = "apellidoMaterno", example = "Estrada", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("apellidoMaterno")
  public JsonNullable<@NotBlank
@Pattern(regexp = "^[\\p{L}\\s'-ñÑÁÉÍÓÚáéíóú]+$") String> getApellidoMaterno() {
    return apellidoMaterno;
  }

  public void setApellidoMaterno(JsonNullable<String> apellidoMaterno) {
    this.apellidoMaterno = apellidoMaterno;
  }

  public PersonaDto curp(String curp) {
    this.curp = curp;
    return this;
  }

  /**
   * Get curp
   * @return curp
  */
  @NotNull @NotBlank
@Pattern(regexp = "^[a-zA-ZÑñ]{4}\\d{6}[a-zA-ZÑñ]{6}[a-zA-Z0-9Ññ]\\d$") @Size(min = 18, max = 18) 
  @Schema(name = "curp", example = "LOEF111111HDFASD01", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("curp")
  public String getCurp() {
    return curp;
  }

  public void setCurp(String curp) {
    this.curp = curp;
  }

  public PersonaDto rfc(String rfc) {
    this.rfc = rfc;
    return this;
  }

  /**
   * Get rfc
   * @return rfc
  */
  @NotNull @NotBlank
@Pattern(regexp = "^[A-Za-z&ñÑ]{4}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[A-Za-z0-9]{2}[0-9Aa]$") @Size(min = 13, max = 13) 
  @Schema(name = "rfc", example = "loef111111fg9", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("rfc")
  public String getRfc() {
    return rfc;
  }

  public void setRfc(String rfc) {
    this.rfc = rfc;
  }

  public PersonaDto numeroSeguroSocial(String numeroSeguroSocial) {
    this.numeroSeguroSocial = numeroSeguroSocial;
    return this;
  }

  /**
   * Get numeroSeguroSocial
   * @return numeroSeguroSocial
  */
  @NotNull @NotBlank @NumericOnly
@Size(min = 11, max = 11) 
  @Schema(name = "numeroSeguroSocial", example = "11111111111", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("numeroSeguroSocial")
  public String getNumeroSeguroSocial() {
    return numeroSeguroSocial;
  }

  public void setNumeroSeguroSocial(String numeroSeguroSocial) {
    this.numeroSeguroSocial = numeroSeguroSocial;
  }

  public PersonaDto fechaNacimiento(LocalDate fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
    return this;
  }

  /**
   * Get fechaNacimiento
   * @return fechaNacimiento
  */
  @NotNull @Valid 

  @Schema(name = "fechaNacimiento", example = "2000-01-01", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("fechaNacimiento")
  public LocalDate getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(LocalDate fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public PersonaDto genero(GeneroEnumDto genero) {
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

  public PersonaDto telefonoPersonal(String telefonoPersonal) {
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

  public PersonaDto correoElectronicoPersonal(String correoElectronicoPersonal) {
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

  public PersonaDto estadoCivil(EstadoCivilEnumDto estadoCivil) {
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

  public PersonaDto hijos(Boolean hijos) {
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

  public PersonaDto contactoEmergenciaNombre(String contactoEmergenciaNombre) {
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

  public PersonaDto contactoEmergenciaTelefono(String contactoEmergenciaTelefono) {
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
    PersonaDto persona = (PersonaDto) o;
    return Objects.equals(this.nombre, persona.nombre) &&
        Objects.equals(this.apellidoPaterno, persona.apellidoPaterno) &&
        Objects.equals(this.apellidoMaterno, persona.apellidoMaterno) &&
        Objects.equals(this.curp, persona.curp) &&
        Objects.equals(this.rfc, persona.rfc) &&
        Objects.equals(this.numeroSeguroSocial, persona.numeroSeguroSocial) &&
        Objects.equals(this.fechaNacimiento, persona.fechaNacimiento) &&
        Objects.equals(this.genero, persona.genero) &&
        Objects.equals(this.telefonoPersonal, persona.telefonoPersonal) &&
        Objects.equals(this.correoElectronicoPersonal, persona.correoElectronicoPersonal) &&
        Objects.equals(this.estadoCivil, persona.estadoCivil) &&
        Objects.equals(this.hijos, persona.hijos) &&
        Objects.equals(this.contactoEmergenciaNombre, persona.contactoEmergenciaNombre) &&
        Objects.equals(this.contactoEmergenciaTelefono, persona.contactoEmergenciaTelefono);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nombre, apellidoPaterno, apellidoMaterno, curp, rfc, numeroSeguroSocial, fechaNacimiento, genero, telefonoPersonal, correoElectronicoPersonal, estadoCivil, hijos, contactoEmergenciaNombre, contactoEmergenciaTelefono);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonaDto {\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    apellidoPaterno: ").append(toIndentedString(apellidoPaterno)).append("\n");
    sb.append("    apellidoMaterno: ").append(toIndentedString(apellidoMaterno)).append("\n");
    sb.append("    curp: ").append(toIndentedString(curp)).append("\n");
    sb.append("    rfc: ").append(toIndentedString(rfc)).append("\n");
    sb.append("    numeroSeguroSocial: ").append(toIndentedString(numeroSeguroSocial)).append("\n");
    sb.append("    fechaNacimiento: ").append(toIndentedString(fechaNacimiento)).append("\n");
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

