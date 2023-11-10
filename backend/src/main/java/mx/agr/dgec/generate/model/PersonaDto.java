package mx.agr.dgec.generate.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDate;
import mx.agr.dgec.generate.model.DireccionDto;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Atributos de una persona
 */

@Schema(name = "PersonaDto", description = "Atributos de una persona")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class PersonaDto {

  private String nombre;

  private String apellidoPaterno;

  private String apellidoMaterno;

  private String curp;

  private String rfc;

  private String nss;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate fechaNacimiento;

  private Integer edad;

  private DireccionDto direccion;

  private String telefonoPersonal;

  private String correoElectronico;

  private Boolean cuentaConCredito;

  private String nombreCompletoEmergencia;

  private String telefonoEmergencia;

  private String observaciones;

  public PersonaDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PersonaDto(String nombre, String apellidoPaterno, String apellidoMaterno, String curp, String rfc, String nss, LocalDate fechaNacimiento, Integer edad, DireccionDto direccion, String telefonoPersonal, String correoElectronico, Boolean cuentaConCredito, String nombreCompletoEmergencia, String telefonoEmergencia, String observaciones) {
    this.nombre = nombre;
    this.apellidoPaterno = apellidoPaterno;
    this.apellidoMaterno = apellidoMaterno;
    this.curp = curp;
    this.rfc = rfc;
    this.nss = nss;
    this.fechaNacimiento = fechaNacimiento;
    this.edad = edad;
    this.direccion = direccion;
    this.telefonoPersonal = telefonoPersonal;
    this.correoElectronico = correoElectronico;
    this.cuentaConCredito = cuentaConCredito;
    this.nombreCompletoEmergencia = nombreCompletoEmergencia;
    this.telefonoEmergencia = telefonoEmergencia;
    this.observaciones = observaciones;
  }

  public PersonaDto nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * Nombre(s)
   * @return nombre
  */
  @NotNull 
  @Schema(name = "nombre", description = "Nombre(s)", requiredMode = Schema.RequiredMode.REQUIRED)
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
   * Apellido paterno
   * @return apellidoPaterno
  */
  @NotNull 
  @Schema(name = "apellidoPaterno", description = "Apellido paterno", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("apellidoPaterno")
  public String getApellidoPaterno() {
    return apellidoPaterno;
  }

  public void setApellidoPaterno(String apellidoPaterno) {
    this.apellidoPaterno = apellidoPaterno;
  }

  public PersonaDto apellidoMaterno(String apellidoMaterno) {
    this.apellidoMaterno = apellidoMaterno;
    return this;
  }

  /**
   * Apellido materno
   * @return apellidoMaterno
  */
  @NotNull 
  @Schema(name = "apellidoMaterno", description = "Apellido materno", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("apellidoMaterno")
  public String getApellidoMaterno() {
    return apellidoMaterno;
  }

  public void setApellidoMaterno(String apellidoMaterno) {
    this.apellidoMaterno = apellidoMaterno;
  }

  public PersonaDto curp(String curp) {
    this.curp = curp;
    return this;
  }

  /**
   * CURP de 18 dígitos
   * @return curp
  */
  @NotNull @Size(min = 18, max = 18) 
  @Schema(name = "curp", description = "CURP de 18 dígitos", requiredMode = Schema.RequiredMode.REQUIRED)
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
   * RFC de 13 dígitos
   * @return rfc
  */
  @NotNull @Size(min = 13, max = 13) 
  @Schema(name = "rfc", description = "RFC de 13 dígitos", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("rfc")
  public String getRfc() {
    return rfc;
  }

  public void setRfc(String rfc) {
    this.rfc = rfc;
  }

  public PersonaDto nss(String nss) {
    this.nss = nss;
    return this;
  }

  /**
   * Número de seguro social de 11 dígitos
   * @return nss
  */
  @NotNull @Size(min = 11, max = 11) 
  @Schema(name = "nss", description = "Número de seguro social de 11 dígitos", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nss")
  public String getNss() {
    return nss;
  }

  public void setNss(String nss) {
    this.nss = nss;
  }

  public PersonaDto fechaNacimiento(LocalDate fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
    return this;
  }

  /**
   * Fecha de nacimiento
   * @return fechaNacimiento
  */
  @NotNull @Valid 
  @Schema(name = "fechaNacimiento", description = "Fecha de nacimiento", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("fechaNacimiento")
  public LocalDate getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(LocalDate fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public PersonaDto edad(Integer edad) {
    this.edad = edad;
    return this;
  }

  /**
   * Edad actual
   * @return edad
  */
  @NotNull 
  @Schema(name = "edad", description = "Edad actual", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("edad")
  public Integer getEdad() {
    return edad;
  }

  public void setEdad(Integer edad) {
    this.edad = edad;
  }

  public PersonaDto direccion(DireccionDto direccion) {
    this.direccion = direccion;
    return this;
  }

  /**
   * Dirección postal del hogar
   * @return direccion
  */
  @NotNull @Valid 
  @Schema(name = "direccion", description = "Dirección postal del hogar", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("direccion")
  public DireccionDto getDireccion() {
    return direccion;
  }

  public void setDireccion(DireccionDto direccion) {
    this.direccion = direccion;
  }

  public PersonaDto telefonoPersonal(String telefonoPersonal) {
    this.telefonoPersonal = telefonoPersonal;
    return this;
  }

  /**
   * Télefono celular a 10 dígitos
   * @return telefonoPersonal
  */
  @NotNull @Size(min = 10, max = 10) 
  @Schema(name = "telefonoPersonal", description = "Télefono celular a 10 dígitos", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("telefonoPersonal")
  public String getTelefonoPersonal() {
    return telefonoPersonal;
  }

  public void setTelefonoPersonal(String telefonoPersonal) {
    this.telefonoPersonal = telefonoPersonal;
  }

  public PersonaDto correoElectronico(String correoElectronico) {
    this.correoElectronico = correoElectronico;
    return this;
  }

  /**
   * Correo eléctronico personal
   * @return correoElectronico
  */
  @NotNull @jakarta.validation.constraints.Email
  @Schema(name = "correoElectronico", description = "Correo eléctronico personal", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("correoElectronico")
  public String getCorreoElectronico() {
    return correoElectronico;
  }

  public void setCorreoElectronico(String correoElectronico) {
    this.correoElectronico = correoElectronico;
  }

  public PersonaDto cuentaConCredito(Boolean cuentaConCredito) {
    this.cuentaConCredito = cuentaConCredito;
    return this;
  }

  /**
   * Saber si cuenta o no con algún crédito
   * @return cuentaConCredito
  */
  @NotNull 
  @Schema(name = "cuentaConCredito", description = "Saber si cuenta o no con algún crédito", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("cuentaConCredito")
  public Boolean getCuentaConCredito() {
    return cuentaConCredito;
  }

  public void setCuentaConCredito(Boolean cuentaConCredito) {
    this.cuentaConCredito = cuentaConCredito;
  }

  public PersonaDto nombreCompletoEmergencia(String nombreCompletoEmergencia) {
    this.nombreCompletoEmergencia = nombreCompletoEmergencia;
    return this;
  }

  /**
   * Nombre completo de una persona de contacto en caso de alguna emergencia
   * @return nombreCompletoEmergencia
  */
  @NotNull 
  @Schema(name = "nombreCompletoEmergencia", description = "Nombre completo de una persona de contacto en caso de alguna emergencia", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nombreCompletoEmergencia")
  public String getNombreCompletoEmergencia() {
    return nombreCompletoEmergencia;
  }

  public void setNombreCompletoEmergencia(String nombreCompletoEmergencia) {
    this.nombreCompletoEmergencia = nombreCompletoEmergencia;
  }

  public PersonaDto telefonoEmergencia(String telefonoEmergencia) {
    this.telefonoEmergencia = telefonoEmergencia;
    return this;
  }

  /**
   * Número de telefono de la persona de contacto en caso de alguna emergencia a 10 dígitos
   * @return telefonoEmergencia
  */
  @NotNull @Size(min = 10, max = 10) 
  @Schema(name = "telefonoEmergencia", description = "Número de telefono de la persona de contacto en caso de alguna emergencia a 10 dígitos", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("telefonoEmergencia")
  public String getTelefonoEmergencia() {
    return telefonoEmergencia;
  }

  public void setTelefonoEmergencia(String telefonoEmergencia) {
    this.telefonoEmergencia = telefonoEmergencia;
  }

  public PersonaDto observaciones(String observaciones) {
    this.observaciones = observaciones;
    return this;
  }

  /**
   * Alguna observación de la persona
   * @return observaciones
  */
  @NotNull 
  @Schema(name = "observaciones", description = "Alguna observación de la persona", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("observaciones")
  public String getObservaciones() {
    return observaciones;
  }

  public void setObservaciones(String observaciones) {
    this.observaciones = observaciones;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonaDto personaDto = (PersonaDto) o;
    return Objects.equals(this.nombre, personaDto.nombre) &&
        Objects.equals(this.apellidoPaterno, personaDto.apellidoPaterno) &&
        Objects.equals(this.apellidoMaterno, personaDto.apellidoMaterno) &&
        Objects.equals(this.curp, personaDto.curp) &&
        Objects.equals(this.rfc, personaDto.rfc) &&
        Objects.equals(this.nss, personaDto.nss) &&
        Objects.equals(this.fechaNacimiento, personaDto.fechaNacimiento) &&
        Objects.equals(this.edad, personaDto.edad) &&
        Objects.equals(this.direccion, personaDto.direccion) &&
        Objects.equals(this.telefonoPersonal, personaDto.telefonoPersonal) &&
        Objects.equals(this.correoElectronico, personaDto.correoElectronico) &&
        Objects.equals(this.cuentaConCredito, personaDto.cuentaConCredito) &&
        Objects.equals(this.nombreCompletoEmergencia, personaDto.nombreCompletoEmergencia) &&
        Objects.equals(this.telefonoEmergencia, personaDto.telefonoEmergencia) &&
        Objects.equals(this.observaciones, personaDto.observaciones);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nombre, apellidoPaterno, apellidoMaterno, curp, rfc, nss, fechaNacimiento, edad, direccion, telefonoPersonal, correoElectronico, cuentaConCredito, nombreCompletoEmergencia, telefonoEmergencia, observaciones);
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
    sb.append("    nss: ").append(toIndentedString(nss)).append("\n");
    sb.append("    fechaNacimiento: ").append(toIndentedString(fechaNacimiento)).append("\n");
    sb.append("    edad: ").append(toIndentedString(edad)).append("\n");
    sb.append("    direccion: ").append(toIndentedString(direccion)).append("\n");
    sb.append("    telefonoPersonal: ").append(toIndentedString(telefonoPersonal)).append("\n");
    sb.append("    correoElectronico: ").append(toIndentedString(correoElectronico)).append("\n");
    sb.append("    cuentaConCredito: ").append(toIndentedString(cuentaConCredito)).append("\n");
    sb.append("    nombreCompletoEmergencia: ").append(toIndentedString(nombreCompletoEmergencia)).append("\n");
    sb.append("    telefonoEmergencia: ").append(toIndentedString(telefonoEmergencia)).append("\n");
    sb.append("    observaciones: ").append(toIndentedString(observaciones)).append("\n");
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

