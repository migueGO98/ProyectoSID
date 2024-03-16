package mx.agr.dgec.generate.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

  private String nombreCompleto;

  private Boolean activo;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate fechaIngreso;

  private String idTipoPlaza;

  private String idRegion;

  private String idDireccion;

  private String idSubdireccion;

  private String idPuesto;

  @Valid
  private List<String> roles = new ArrayList<>();

  public EmpleadoDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public EmpleadoDto(String idEmpleado, String nombreCompleto, Boolean activo, LocalDate fechaIngreso, String idTipoPlaza, String idRegion, String idDireccion, String idSubdireccion, String idPuesto, List<String> roles) {
    this.idEmpleado = idEmpleado;
    this.nombreCompleto = nombreCompleto;
    this.activo = activo;
    this.fechaIngreso = fechaIngreso;
    this.idTipoPlaza = idTipoPlaza;
    this.idRegion = idRegion;
    this.idDireccion = idDireccion;
    this.idSubdireccion = idSubdireccion;
    this.idPuesto = idPuesto;
    this.roles = roles;
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

  public EmpleadoDto nombreCompleto(String nombreCompleto) {
    this.nombreCompleto = nombreCompleto;
    return this;
  }

  /**
   * Get nombreCompleto
   * @return nombreCompleto
  */
  @NotNull 
  @Schema(name = "nombreCompleto", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nombreCompleto")
  public String getNombreCompleto() {
    return nombreCompleto;
  }

  public void setNombreCompleto(String nombreCompleto) {
    this.nombreCompleto = nombreCompleto;
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

  public EmpleadoDto idRegion(String idRegion) {
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

  public EmpleadoDto roles(List<String> roles) {
    this.roles = roles;
    return this;
  }

  public EmpleadoDto addRolesItem(String rolesItem) {
    if (this.roles == null) {
      this.roles = new ArrayList<>();
    }
    this.roles.add(rolesItem);
    return this;
  }

  /**
   * Get roles
   * @return roles
  */
  @NotNull 
  @Schema(name = "roles", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("roles")
  public List<String> getRoles() {
    return roles;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
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
        Objects.equals(this.nombreCompleto, empleado.nombreCompleto) &&
        Objects.equals(this.activo, empleado.activo) &&
        Objects.equals(this.fechaIngreso, empleado.fechaIngreso) &&
        Objects.equals(this.idTipoPlaza, empleado.idTipoPlaza) &&
        Objects.equals(this.idRegion, empleado.idRegion) &&
        Objects.equals(this.idDireccion, empleado.idDireccion) &&
        Objects.equals(this.idSubdireccion, empleado.idSubdireccion) &&
        Objects.equals(this.idPuesto, empleado.idPuesto) &&
        Objects.equals(this.roles, empleado.roles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idEmpleado, nombreCompleto, activo, fechaIngreso, idTipoPlaza, idRegion, idDireccion, idSubdireccion, idPuesto, roles);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmpleadoDto {\n");
    sb.append("    idEmpleado: ").append(toIndentedString(idEmpleado)).append("\n");
    sb.append("    nombreCompleto: ").append(toIndentedString(nombreCompleto)).append("\n");
    sb.append("    activo: ").append(toIndentedString(activo)).append("\n");
    sb.append("    fechaIngreso: ").append(toIndentedString(fechaIngreso)).append("\n");
    sb.append("    idTipoPlaza: ").append(toIndentedString(idTipoPlaza)).append("\n");
    sb.append("    idRegion: ").append(toIndentedString(idRegion)).append("\n");
    sb.append("    idDireccion: ").append(toIndentedString(idDireccion)).append("\n");
    sb.append("    idSubdireccion: ").append(toIndentedString(idSubdireccion)).append("\n");
    sb.append("    idPuesto: ").append(toIndentedString(idPuesto)).append("\n");
    sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
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

