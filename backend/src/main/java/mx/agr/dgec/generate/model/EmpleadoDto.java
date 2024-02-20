package mx.agr.dgec.generate.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
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

  private String idDireccion;

  private String idSubdireccion;

  private String idPuesto;

  public EmpleadoDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public EmpleadoDto(String idEmpleado, String idDireccion, String idSubdireccion, String idPuesto) {
    this.idEmpleado = idEmpleado;
    this.idDireccion = idDireccion;
    this.idSubdireccion = idSubdireccion;
    this.idPuesto = idPuesto;
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
        Objects.equals(this.idDireccion, empleado.idDireccion) &&
        Objects.equals(this.idSubdireccion, empleado.idSubdireccion) &&
        Objects.equals(this.idPuesto, empleado.idPuesto);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idEmpleado, idDireccion, idSubdireccion, idPuesto);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmpleadoDto {\n");
    sb.append("    idEmpleado: ").append(toIndentedString(idEmpleado)).append("\n");
    sb.append("    idDireccion: ").append(toIndentedString(idDireccion)).append("\n");
    sb.append("    idSubdireccion: ").append(toIndentedString(idSubdireccion)).append("\n");
    sb.append("    idPuesto: ").append(toIndentedString(idPuesto)).append("\n");
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

