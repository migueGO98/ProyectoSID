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
 * Modelo para especificar el error que haya sucedido
 */

@Schema(name = "ModelErrorDto", description = "Modelo para especificar el error que haya sucedido")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ModelErrorDto {

  private String codigo;

  private String mensaje;

  public ModelErrorDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ModelErrorDto(String codigo, String mensaje) {
    this.codigo = codigo;
    this.mensaje = mensaje;
  }

  public ModelErrorDto codigo(String codigo) {
    this.codigo = codigo;
    return this;
  }

  /**
   * Código del error amigable
   * @return codigo
  */
  @NotNull 
  @Schema(name = "codigo", description = "Código del error amigable", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("codigo")
  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public ModelErrorDto mensaje(String mensaje) {
    this.mensaje = mensaje;
    return this;
  }

  /**
   * Mensaje amigable personalizado
   * @return mensaje
  */
  @NotNull 
  @Schema(name = "mensaje", description = "Mensaje amigable personalizado", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("mensaje")
  public String getMensaje() {
    return mensaje;
  }

  public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelErrorDto modelErrorDto = (ModelErrorDto) o;
    return Objects.equals(this.codigo, modelErrorDto.codigo) &&
        Objects.equals(this.mensaje, modelErrorDto.mensaje);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codigo, mensaje);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelErrorDto {\n");
    sb.append("    codigo: ").append(toIndentedString(codigo)).append("\n");
    sb.append("    mensaje: ").append(toIndentedString(mensaje)).append("\n");
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

