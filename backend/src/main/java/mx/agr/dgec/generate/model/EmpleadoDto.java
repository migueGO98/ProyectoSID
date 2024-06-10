package mx.agr.dgec.generate.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
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
 * EmpleadoDto
 */

@JsonTypeName("Empleado")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
public class EmpleadoDto {

  private String idEmpleado;

  private String nombreCompleto;

  private Boolean activo;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate fechaIngreso;

  private String tipoPlaza;

  private String region;

  private String direccion;

  private String subdireccion;

  private String puesto;

  @Valid
  private Set<String> roles = new LinkedHashSet<>();

  public EmpleadoDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public EmpleadoDto(String idEmpleado, String nombreCompleto, Boolean activo, LocalDate fechaIngreso, String tipoPlaza, String region, String direccion, String subdireccion, String puesto, Set<String> roles) {
    this.idEmpleado = idEmpleado;
    this.nombreCompleto = nombreCompleto;
    this.activo = activo;
    this.fechaIngreso = fechaIngreso;
    this.tipoPlaza = tipoPlaza;
    this.region = region;
    this.direccion = direccion;
    this.subdireccion = subdireccion;
    this.puesto = puesto;
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

  public EmpleadoDto tipoPlaza(String tipoPlaza) {
    this.tipoPlaza = tipoPlaza;
    return this;
  }

  /**
   * Get tipoPlaza
   * @return tipoPlaza
  */
  @NotNull 

  @Schema(name = "tipoPlaza", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("tipoPlaza")
  public String getTipoPlaza() {
    return tipoPlaza;
  }

  public void setTipoPlaza(String tipoPlaza) {
    this.tipoPlaza = tipoPlaza;
  }

  public EmpleadoDto region(String region) {
    this.region = region;
    return this;
  }

  /**
   * Get region
   * @return region
  */
  @NotNull 

  @Schema(name = "region", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("region")
  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public EmpleadoDto direccion(String direccion) {
    this.direccion = direccion;
    return this;
  }

  /**
   * Get direccion
   * @return direccion
  */
  @NotNull 

  @Schema(name = "direccion", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("direccion")
  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public EmpleadoDto subdireccion(String subdireccion) {
    this.subdireccion = subdireccion;
    return this;
  }

  /**
   * Get subdireccion
   * @return subdireccion
  */
  @NotNull 

  @Schema(name = "subdireccion", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("subdireccion")
  public String getSubdireccion() {
    return subdireccion;
  }

  public void setSubdireccion(String subdireccion) {
    this.subdireccion = subdireccion;
  }

  public EmpleadoDto puesto(String puesto) {
    this.puesto = puesto;
    return this;
  }

  /**
   * Get puesto
   * @return puesto
  */
  @NotNull 

  @Schema(name = "puesto", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("puesto")
  public String getPuesto() {
    return puesto;
  }

  public void setPuesto(String puesto) {
    this.puesto = puesto;
  }

  public EmpleadoDto roles(Set<String> roles) {
    this.roles = roles;
    return this;
  }

  public EmpleadoDto addRolesItem(String rolesItem) {
    if (this.roles == null) {
      this.roles = new LinkedHashSet<>();
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
  public Set<String> getRoles() {
    return roles;
  }

  @JsonDeserialize(as = LinkedHashSet.class)
  public void setRoles(Set<String> roles) {
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
        Objects.equals(this.tipoPlaza, empleado.tipoPlaza) &&
        Objects.equals(this.region, empleado.region) &&
        Objects.equals(this.direccion, empleado.direccion) &&
        Objects.equals(this.subdireccion, empleado.subdireccion) &&
        Objects.equals(this.puesto, empleado.puesto) &&
        Objects.equals(this.roles, empleado.roles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idEmpleado, nombreCompleto, activo, fechaIngreso, tipoPlaza, region, direccion, subdireccion, puesto, roles);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmpleadoDto {\n");
    sb.append("    idEmpleado: ").append(toIndentedString(idEmpleado)).append("\n");
    sb.append("    nombreCompleto: ").append(toIndentedString(nombreCompleto)).append("\n");
    sb.append("    activo: ").append(toIndentedString(activo)).append("\n");
    sb.append("    fechaIngreso: ").append(toIndentedString(fechaIngreso)).append("\n");
    sb.append("    tipoPlaza: ").append(toIndentedString(tipoPlaza)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    direccion: ").append(toIndentedString(direccion)).append("\n");
    sb.append("    subdireccion: ").append(toIndentedString(subdireccion)).append("\n");
    sb.append("    puesto: ").append(toIndentedString(puesto)).append("\n");
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

