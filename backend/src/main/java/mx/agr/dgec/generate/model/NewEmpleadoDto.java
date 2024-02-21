package mx.agr.dgec.generate.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mx.agr.dgec.generate.model.DomicilioDto;
import mx.agr.dgec.generate.model.EscolaridadDto;
import mx.agr.dgec.generate.model.PersonaDto;
import mx.agr.dgec.generate.model.TipoPlazaEnumDto;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * NewEmpleadoDto
 */

@JsonTypeName("NewEmpleado")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class NewEmpleadoDto {

  private PersonaDto persona;

  private DomicilioDto domicilio;

  @Valid
  private List<@Valid EscolaridadDto> escolaridad = new ArrayList<>();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate fechaIngreso;

  private TipoPlazaEnumDto tipoPlaza;

  private Integer idRegion;

  private String idDireccion;

  private String idSubdireccion;

  private String idPuesto;

  public NewEmpleadoDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public NewEmpleadoDto(PersonaDto persona, DomicilioDto domicilio, List<@Valid EscolaridadDto> escolaridad, LocalDate fechaIngreso, TipoPlazaEnumDto tipoPlaza, Integer idRegion, String idDireccion, String idSubdireccion, String idPuesto) {
    this.persona = persona;
    this.domicilio = domicilio;
    this.escolaridad = escolaridad;
    this.fechaIngreso = fechaIngreso;
    this.tipoPlaza = tipoPlaza;
    this.idRegion = idRegion;
    this.idDireccion = idDireccion;
    this.idSubdireccion = idSubdireccion;
    this.idPuesto = idPuesto;
  }

  public NewEmpleadoDto persona(PersonaDto persona) {
    this.persona = persona;
    return this;
  }

  /**
   * Get persona
   * @return persona
  */
  @NotNull @Valid 
  @Schema(name = "persona", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("persona")
  public PersonaDto getPersona() {
    return persona;
  }

  public void setPersona(PersonaDto persona) {
    this.persona = persona;
  }

  public NewEmpleadoDto domicilio(DomicilioDto domicilio) {
    this.domicilio = domicilio;
    return this;
  }

  /**
   * Get domicilio
   * @return domicilio
  */
  @NotNull @Valid 
  @Schema(name = "domicilio", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("domicilio")
  public DomicilioDto getDomicilio() {
    return domicilio;
  }

  public void setDomicilio(DomicilioDto domicilio) {
    this.domicilio = domicilio;
  }

  public NewEmpleadoDto escolaridad(List<@Valid EscolaridadDto> escolaridad) {
    this.escolaridad = escolaridad;
    return this;
  }

  public NewEmpleadoDto addEscolaridadItem(EscolaridadDto escolaridadItem) {
    if (this.escolaridad == null) {
      this.escolaridad = new ArrayList<>();
    }
    this.escolaridad.add(escolaridadItem);
    return this;
  }

  /**
   * Get escolaridad
   * @return escolaridad
  */
  @NotNull @Valid 
  @Schema(name = "escolaridad", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("escolaridad")
  public List<@Valid EscolaridadDto> getEscolaridad() {
    return escolaridad;
  }

  public void setEscolaridad(List<@Valid EscolaridadDto> escolaridad) {
    this.escolaridad = escolaridad;
  }

  public NewEmpleadoDto fechaIngreso(LocalDate fechaIngreso) {
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

  public NewEmpleadoDto tipoPlaza(TipoPlazaEnumDto tipoPlaza) {
    this.tipoPlaza = tipoPlaza;
    return this;
  }

  /**
   * Get tipoPlaza
   * @return tipoPlaza
  */
  @NotNull @Valid 
  @Schema(name = "tipoPlaza", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("tipoPlaza")
  public TipoPlazaEnumDto getTipoPlaza() {
    return tipoPlaza;
  }

  public void setTipoPlaza(TipoPlazaEnumDto tipoPlaza) {
    this.tipoPlaza = tipoPlaza;
  }

  public NewEmpleadoDto idRegion(Integer idRegion) {
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
  public Integer getIdRegion() {
    return idRegion;
  }

  public void setIdRegion(Integer idRegion) {
    this.idRegion = idRegion;
  }

  public NewEmpleadoDto idDireccion(String idDireccion) {
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

  public NewEmpleadoDto idSubdireccion(String idSubdireccion) {
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

  public NewEmpleadoDto idPuesto(String idPuesto) {
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
    NewEmpleadoDto newEmpleado = (NewEmpleadoDto) o;
    return Objects.equals(this.persona, newEmpleado.persona) &&
        Objects.equals(this.domicilio, newEmpleado.domicilio) &&
        Objects.equals(this.escolaridad, newEmpleado.escolaridad) &&
        Objects.equals(this.fechaIngreso, newEmpleado.fechaIngreso) &&
        Objects.equals(this.tipoPlaza, newEmpleado.tipoPlaza) &&
        Objects.equals(this.idRegion, newEmpleado.idRegion) &&
        Objects.equals(this.idDireccion, newEmpleado.idDireccion) &&
        Objects.equals(this.idSubdireccion, newEmpleado.idSubdireccion) &&
        Objects.equals(this.idPuesto, newEmpleado.idPuesto);
  }

  @Override
  public int hashCode() {
    return Objects.hash(persona, domicilio, escolaridad, fechaIngreso, tipoPlaza, idRegion, idDireccion, idSubdireccion, idPuesto);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewEmpleadoDto {\n");
    sb.append("    persona: ").append(toIndentedString(persona)).append("\n");
    sb.append("    domicilio: ").append(toIndentedString(domicilio)).append("\n");
    sb.append("    escolaridad: ").append(toIndentedString(escolaridad)).append("\n");
    sb.append("    fechaIngreso: ").append(toIndentedString(fechaIngreso)).append("\n");
    sb.append("    tipoPlaza: ").append(toIndentedString(tipoPlaza)).append("\n");
    sb.append("    idRegion: ").append(toIndentedString(idRegion)).append("\n");
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
