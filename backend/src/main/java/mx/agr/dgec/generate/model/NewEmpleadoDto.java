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
  private List<@Valid EscolaridadDto> escolaridades = new ArrayList<>();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate fechaIngreso;

  private TipoPlazaEnumDto idTipoPlaza;

  private String idRegion;

  private String idDireccion;

  private String idSubdireccion;

  private String idPuesto;

  @Valid
  private List<String> roles = new ArrayList<>();

  public NewEmpleadoDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public NewEmpleadoDto(PersonaDto persona, DomicilioDto domicilio, List<@Valid EscolaridadDto> escolaridades, LocalDate fechaIngreso, TipoPlazaEnumDto idTipoPlaza, String idRegion, String idDireccion, String idSubdireccion, String idPuesto, List<String> roles) {
    this.persona = persona;
    this.domicilio = domicilio;
    this.escolaridades = escolaridades;
    this.fechaIngreso = fechaIngreso;
    this.idTipoPlaza = idTipoPlaza;
    this.idRegion = idRegion;
    this.idDireccion = idDireccion;
    this.idSubdireccion = idSubdireccion;
    this.idPuesto = idPuesto;
    this.roles = roles;
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

  public NewEmpleadoDto escolaridades(List<@Valid EscolaridadDto> escolaridades) {
    this.escolaridades = escolaridades;
    return this;
  }

  public NewEmpleadoDto addEscolaridadesItem(EscolaridadDto escolaridadesItem) {
    if (this.escolaridades == null) {
      this.escolaridades = new ArrayList<>();
    }
    this.escolaridades.add(escolaridadesItem);
    return this;
  }

  /**
   * Get escolaridades
   * @return escolaridades
  */
  @NotNull @Valid 
  @Schema(name = "escolaridades", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("escolaridades")
  public List<@Valid EscolaridadDto> getEscolaridades() {
    return escolaridades;
  }

  public void setEscolaridades(List<@Valid EscolaridadDto> escolaridades) {
    this.escolaridades = escolaridades;
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

  public NewEmpleadoDto idTipoPlaza(TipoPlazaEnumDto idTipoPlaza) {
    this.idTipoPlaza = idTipoPlaza;
    return this;
  }

  /**
   * Get idTipoPlaza
   * @return idTipoPlaza
  */
  @NotNull @Valid 
  @Schema(name = "idTipoPlaza", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("idTipoPlaza")
  public TipoPlazaEnumDto getIdTipoPlaza() {
    return idTipoPlaza;
  }

  public void setIdTipoPlaza(TipoPlazaEnumDto idTipoPlaza) {
    this.idTipoPlaza = idTipoPlaza;
  }

  public NewEmpleadoDto idRegion(String idRegion) {
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

  public NewEmpleadoDto roles(List<String> roles) {
    this.roles = roles;
    return this;
  }

  public NewEmpleadoDto addRolesItem(String rolesItem) {
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
    NewEmpleadoDto newEmpleado = (NewEmpleadoDto) o;
    return Objects.equals(this.persona, newEmpleado.persona) &&
        Objects.equals(this.domicilio, newEmpleado.domicilio) &&
        Objects.equals(this.escolaridades, newEmpleado.escolaridades) &&
        Objects.equals(this.fechaIngreso, newEmpleado.fechaIngreso) &&
        Objects.equals(this.idTipoPlaza, newEmpleado.idTipoPlaza) &&
        Objects.equals(this.idRegion, newEmpleado.idRegion) &&
        Objects.equals(this.idDireccion, newEmpleado.idDireccion) &&
        Objects.equals(this.idSubdireccion, newEmpleado.idSubdireccion) &&
        Objects.equals(this.idPuesto, newEmpleado.idPuesto) &&
        Objects.equals(this.roles, newEmpleado.roles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(persona, domicilio, escolaridades, fechaIngreso, idTipoPlaza, idRegion, idDireccion, idSubdireccion, idPuesto, roles);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewEmpleadoDto {\n");
    sb.append("    persona: ").append(toIndentedString(persona)).append("\n");
    sb.append("    domicilio: ").append(toIndentedString(domicilio)).append("\n");
    sb.append("    escolaridades: ").append(toIndentedString(escolaridades)).append("\n");
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

