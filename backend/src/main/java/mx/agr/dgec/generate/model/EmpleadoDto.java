package mx.agr.dgec.generate.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
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
 * Atributos de un empleado
 */

@Schema(name = "EmpleadoDto", description = "Atributos de un empleado")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class EmpleadoDto {

  private Boolean activo;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate fechaIngreso;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate fechaTermino;

  private Integer diasVacaciones;

  private Integer diasVacacionesPendiente;

  /**
   * Gets or Sets motivoBaja
   */
  public enum MotivoBajaEnum {
    N_A("N/A"),
    
    TERMINO_CONTRATO("TERMINO CONTRATO"),
    
    RENUNCIA("RENUNCIA"),
    
    LIQUIDACION("LIQUIDACION");

    private String value;

    MotivoBajaEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MotivoBajaEnum fromValue(String value) {
      for (MotivoBajaEnum b : MotivoBajaEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private MotivoBajaEnum motivoBaja = MotivoBajaEnum.N_A;

  public EmpleadoDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public EmpleadoDto(Boolean activo, LocalDate fechaIngreso, LocalDate fechaTermino, Integer diasVacaciones, Integer diasVacacionesPendiente, MotivoBajaEnum motivoBaja) {
    this.activo = activo;
    this.fechaIngreso = fechaIngreso;
    this.fechaTermino = fechaTermino;
    this.diasVacaciones = diasVacaciones;
    this.diasVacacionesPendiente = diasVacacionesPendiente;
    this.motivoBaja = motivoBaja;
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

  public EmpleadoDto fechaTermino(LocalDate fechaTermino) {
    this.fechaTermino = fechaTermino;
    return this;
  }

  /**
   * Get fechaTermino
   * @return fechaTermino
  */
  @NotNull @Valid 
  @Schema(name = "fechaTermino", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("fechaTermino")
  public LocalDate getFechaTermino() {
    return fechaTermino;
  }

  public void setFechaTermino(LocalDate fechaTermino) {
    this.fechaTermino = fechaTermino;
  }

  public EmpleadoDto diasVacaciones(Integer diasVacaciones) {
    this.diasVacaciones = diasVacaciones;
    return this;
  }

  /**
   * Get diasVacaciones
   * @return diasVacaciones
  */
  @NotNull 
  @Schema(name = "diasVacaciones", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("diasVacaciones")
  public Integer getDiasVacaciones() {
    return diasVacaciones;
  }

  public void setDiasVacaciones(Integer diasVacaciones) {
    this.diasVacaciones = diasVacaciones;
  }

  public EmpleadoDto diasVacacionesPendiente(Integer diasVacacionesPendiente) {
    this.diasVacacionesPendiente = diasVacacionesPendiente;
    return this;
  }

  /**
   * Get diasVacacionesPendiente
   * @return diasVacacionesPendiente
  */
  @NotNull 
  @Schema(name = "diasVacacionesPendiente", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("diasVacacionesPendiente")
  public Integer getDiasVacacionesPendiente() {
    return diasVacacionesPendiente;
  }

  public void setDiasVacacionesPendiente(Integer diasVacacionesPendiente) {
    this.diasVacacionesPendiente = diasVacacionesPendiente;
  }

  public EmpleadoDto motivoBaja(MotivoBajaEnum motivoBaja) {
    this.motivoBaja = motivoBaja;
    return this;
  }

  /**
   * Get motivoBaja
   * @return motivoBaja
  */
  @NotNull 
  @Schema(name = "motivoBaja", example = "N/A", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("motivoBaja")
  public MotivoBajaEnum getMotivoBaja() {
    return motivoBaja;
  }

  public void setMotivoBaja(MotivoBajaEnum motivoBaja) {
    this.motivoBaja = motivoBaja;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmpleadoDto empleadoDto = (EmpleadoDto) o;
    return Objects.equals(this.activo, empleadoDto.activo) &&
        Objects.equals(this.fechaIngreso, empleadoDto.fechaIngreso) &&
        Objects.equals(this.fechaTermino, empleadoDto.fechaTermino) &&
        Objects.equals(this.diasVacaciones, empleadoDto.diasVacaciones) &&
        Objects.equals(this.diasVacacionesPendiente, empleadoDto.diasVacacionesPendiente) &&
        Objects.equals(this.motivoBaja, empleadoDto.motivoBaja);
  }

  @Override
  public int hashCode() {
    return Objects.hash(activo, fechaIngreso, fechaTermino, diasVacaciones, diasVacacionesPendiente, motivoBaja);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmpleadoDto {\n");
    sb.append("    activo: ").append(toIndentedString(activo)).append("\n");
    sb.append("    fechaIngreso: ").append(toIndentedString(fechaIngreso)).append("\n");
    sb.append("    fechaTermino: ").append(toIndentedString(fechaTermino)).append("\n");
    sb.append("    diasVacaciones: ").append(toIndentedString(diasVacaciones)).append("\n");
    sb.append("    diasVacacionesPendiente: ").append(toIndentedString(diasVacacionesPendiente)).append("\n");
    sb.append("    motivoBaja: ").append(toIndentedString(motivoBaja)).append("\n");
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

