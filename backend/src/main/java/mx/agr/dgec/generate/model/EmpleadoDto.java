package mx.agr.dgec.generate.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * EmpleadoDto
 */

@JsonTypeName("Empleado")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class EmpleadoDto {

  private String idEmpleado;

  private Boolean activo;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate fechaIngreso;

  private String correoElectronico;

  private String telefono;

  private String extensionTelefono;

  private String idTipoPlaza;

  private String idPuesto;

  private String idDireccion;

  private String idSubdireccion;

  public EmpleadoDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public EmpleadoDto(String idEmpleado, Boolean activo, LocalDate fechaIngreso, String correoElectronico, String telefono, String extensionTelefono, String idTipoPlaza, String idPuesto, String idDireccion, String idSubdireccion) {
    this.idEmpleado = idEmpleado;
    this.activo = activo;
    this.fechaIngreso = fechaIngreso;
    this.correoElectronico = correoElectronico;
    this.telefono = telefono;
    this.extensionTelefono = extensionTelefono;
    this.idTipoPlaza = idTipoPlaza;
    this.idPuesto = idPuesto;
    this.idDireccion = idDireccion;
    this.idSubdireccion = idSubdireccion;
  }

  public EmpleadoDto idEmpleado(String idEmpleado) {
    this.idEmpleado = idEmpleado;
    return this;
  }

  /**
   * Get idEmpleado
   * @return idEmpleado
  */
  @NotNull 
  @Schema(name = "idEmpleado", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("idEmpleado")
  public String getIdEmpleado() {
    return idEmpleado;
  }

  public void setIdEmpleado(String idEmpleado) {
    this.idEmpleado = idEmpleado;
  }

  public EmpleadoDto activo(Boolean activo) {
    this.activo = activo;
    return this;
  }

  /**
   * Get activo
   * @return activo
  */
  @NotNull 
  @Schema(name = "activo", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("activo")
  public Boolean getActivo() {
    return activo;
  }

  public void setActivo(Boolean activo) {
    this.activo = activo;
  }

  public EmpleadoDto fechaIngreso(LocalDate fechaIngreso) {
    this.fechaIngreso = fechaIngreso;
    return this;
  }

  /**
   * Get fechaIngreso
   * @return fechaIngreso
  */
  @NotNull @Valid 
  @Schema(name = "fechaIngreso", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("fechaIngreso")
  public LocalDate getFechaIngreso() {
    return fechaIngreso;
  }

  public void setFechaIngreso(LocalDate fechaIngreso) {
    this.fechaIngreso = fechaIngreso;
  }

  public EmpleadoDto correoElectronico(String correoElectronico) {
    this.correoElectronico = correoElectronico;
    return this;
  }

  /**
   * Get correoElectronico
   * @return correoElectronico
  */
  @NotNull 
  @Schema(name = "correoElectronico", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("correoElectronico")
  public String getCorreoElectronico() {
    return correoElectronico;
  }

  public void setCorreoElectronico(String correoElectronico) {
    this.correoElectronico = correoElectronico;
  }

  public EmpleadoDto telefono(String telefono) {
    this.telefono = telefono;
    return this;
  }

  /**
   * Get telefono
   * @return telefono
  */
  @NotNull @Size(min = 10, max = 10) 
  @Schema(name = "telefono", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("telefono")
  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public EmpleadoDto extensionTelefono(String extensionTelefono) {
    this.extensionTelefono = extensionTelefono;
    return this;
  }

  /**
   * Get extensionTelefono
   * @return extensionTelefono
  */
  @NotNull @Size(min = 3, max = 6) 
  @Schema(name = "extensionTelefono", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("extensionTelefono")
  public String getExtensionTelefono() {
    return extensionTelefono;
  }

  public void setExtensionTelefono(String extensionTelefono) {
    this.extensionTelefono = extensionTelefono;
  }

  public EmpleadoDto idTipoPlaza(String idTipoPlaza) {
    this.idTipoPlaza = idTipoPlaza;
    return this;
  }

  /**
   * Get idTipoPlaza
   * @return idTipoPlaza
  */
  @NotNull 
  @Schema(name = "idTipoPlaza", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("idTipoPlaza")
  public String getIdTipoPlaza() {
    return idTipoPlaza;
  }

  public void setIdTipoPlaza(String idTipoPlaza) {
    this.idTipoPlaza = idTipoPlaza;
  }

  public EmpleadoDto idPuesto(String idPuesto) {
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

  public EmpleadoDto idDireccion(String idDireccion) {
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

  public EmpleadoDto idSubdireccion(String idSubdireccion) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmpleadoDto empleado = (EmpleadoDto) o;
    return Objects.equals(this.idEmpleado, empleado.idEmpleado) &&
        Objects.equals(this.activo, empleado.activo) &&
        Objects.equals(this.fechaIngreso, empleado.fechaIngreso) &&
        Objects.equals(this.correoElectronico, empleado.correoElectronico) &&
        Objects.equals(this.telefono, empleado.telefono) &&
        Objects.equals(this.extensionTelefono, empleado.extensionTelefono) &&
        Objects.equals(this.idTipoPlaza, empleado.idTipoPlaza) &&
        Objects.equals(this.idPuesto, empleado.idPuesto) &&
        Objects.equals(this.idDireccion, empleado.idDireccion) &&
        Objects.equals(this.idSubdireccion, empleado.idSubdireccion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idEmpleado, activo, fechaIngreso, correoElectronico, telefono, extensionTelefono, idTipoPlaza, idPuesto, idDireccion, idSubdireccion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmpleadoDto {\n");
    sb.append("    idEmpleado: ").append(toIndentedString(idEmpleado)).append("\n");
    sb.append("    activo: ").append(toIndentedString(activo)).append("\n");
    sb.append("    fechaIngreso: ").append(toIndentedString(fechaIngreso)).append("\n");
    sb.append("    correoElectronico: ").append(toIndentedString(correoElectronico)).append("\n");
    sb.append("    telefono: ").append(toIndentedString(telefono)).append("\n");
    sb.append("    extensionTelefono: ").append(toIndentedString(extensionTelefono)).append("\n");
    sb.append("    idTipoPlaza: ").append(toIndentedString(idTipoPlaza)).append("\n");
    sb.append("    idPuesto: ").append(toIndentedString(idPuesto)).append("\n");
    sb.append("    idDireccion: ").append(toIndentedString(idDireccion)).append("\n");
    sb.append("    idSubdireccion: ").append(toIndentedString(idSubdireccion)).append("\n");
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

