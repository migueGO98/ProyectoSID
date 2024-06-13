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
import mx.agr.dgec.generate.model.DomicilioDto;
import mx.agr.dgec.generate.model.EscolaridadDto;
import mx.agr.dgec.generate.model.PersonaDto;
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
 * NewEmpleadoDto
 */

@JsonTypeName("NewEmpleado")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
public class NewEmpleadoDto {

  private PersonaDto persona;

  private DomicilioDto domicilio;

  @Valid
  private List<@Valid EscolaridadDto> escolaridades = new ArrayList<>();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate fechaIngreso;

  private String correoElectronicoInstitucional;

  private String idTipoPlaza;

  private String idRegion;

  private String idDireccion;

  private String idSubdireccion;

  private String idPuesto;

  @Valid
  private List<@Pattern(regexp = "^[a-zA-Z0-9]+$")String> idRoles = new ArrayList<>();

  public NewEmpleadoDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public NewEmpleadoDto(PersonaDto persona, DomicilioDto domicilio, List<@Valid EscolaridadDto> escolaridades, LocalDate fechaIngreso, String correoElectronicoInstitucional, String idTipoPlaza, String idRegion, String idDireccion, String idSubdireccion, String idPuesto, List<@Pattern(regexp = "^[a-zA-Z0-9]+$")String> idRoles) {
    this.persona = persona;
    this.domicilio = domicilio;
    this.escolaridades = escolaridades;
    this.fechaIngreso = fechaIngreso;
    this.correoElectronicoInstitucional = correoElectronicoInstitucional;
    this.idTipoPlaza = idTipoPlaza;
    this.idRegion = idRegion;
    this.idDireccion = idDireccion;
    this.idSubdireccion = idSubdireccion;
    this.idPuesto = idPuesto;
    this.idRoles = idRoles;
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
  @NotNull @Valid @NotNullElement
@Size(min = 1, max = 5) 
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

  @Schema(name = "fechaIngreso", example = "2020-01-01", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("fechaIngreso")
  public LocalDate getFechaIngreso() {
    return fechaIngreso;
  }

  public void setFechaIngreso(LocalDate fechaIngreso) {
    this.fechaIngreso = fechaIngreso;
  }

  public NewEmpleadoDto correoElectronicoInstitucional(String correoElectronicoInstitucional) {
    this.correoElectronicoInstitucional = correoElectronicoInstitucional;
    return this;
  }

  /**
   * Get correoElectronicoInstitucional
   * @return correoElectronicoInstitucional
  */
  @NotNull 
@jakarta.validation.constraints.Email 
  @Schema(name = "correoElectronicoInstitucional", example = "fabian.estarda@agricultura.com.mx", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("correoElectronicoInstitucional")
  public String getCorreoElectronicoInstitucional() {
    return correoElectronicoInstitucional;
  }

  public void setCorreoElectronicoInstitucional(String correoElectronicoInstitucional) {
    this.correoElectronicoInstitucional = correoElectronicoInstitucional;
  }

  public NewEmpleadoDto idTipoPlaza(String idTipoPlaza) {
    this.idTipoPlaza = idTipoPlaza;
    return this;
  }

  /**
   * Get idTipoPlaza
   * @return idTipoPlaza
  */
  @NotNull @NotBlank
@Pattern(regexp = "^[a-zA-Z0-9]+$") 
  @Schema(name = "idTipoPlaza", example = "SPC", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("idTipoPlaza")
  public String getIdTipoPlaza() {
    return idTipoPlaza;
  }

  public void setIdTipoPlaza(String idTipoPlaza) {
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
  @NotNull @NotBlank
@Pattern(regexp = "^[a-zA-Z0-9]+$") 
  @Schema(name = "idRegion", example = "oc", requiredMode = Schema.RequiredMode.REQUIRED)
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
  @NotNull @NotBlank
@Pattern(regexp = "^[a-zA-Z0-9]+$") 
  @Schema(name = "idDireccion", example = "DGEC", requiredMode = Schema.RequiredMode.REQUIRED)
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
  @NotNull @NotBlank
@Pattern(regexp = "^[a-zA-Z0-9]+$") 
  @Schema(name = "idSubdireccion", example = "SUBAdmonOC", requiredMode = Schema.RequiredMode.REQUIRED)
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
  @NotNull @NotBlank
@Pattern(regexp = "^[a-zA-Z0-9]+$") 
  @Schema(name = "idPuesto", example = "na1", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("idPuesto")
  public String getIdPuesto() {
    return idPuesto;
  }

  public void setIdPuesto(String idPuesto) {
    this.idPuesto = idPuesto;
  }

  public NewEmpleadoDto idRoles(List<@Pattern(regexp = "^[a-zA-Z0-9]+$")String> idRoles) {
    this.idRoles = idRoles;
    return this;
  }

  public NewEmpleadoDto addIdRolesItem(String idRolesItem) {
    if (this.idRoles == null) {
      this.idRoles = new ArrayList<>();
    }
    this.idRoles.add(idRolesItem);
    return this;
  }

  /**
   * Get idRoles
   * @return idRoles
  */
  @NotNull @NotNullElement @NotBlankElement @NotDuplicateElement
@Size(min = 1, max = 20) 
  @Schema(name = "idRoles", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("idRoles")
  public List<@Pattern(regexp = "^[a-zA-Z0-9]+$")String> getIdRoles() {
    return idRoles;
  }

  public void setIdRoles(List<@Pattern(regexp = "^[a-zA-Z0-9]+$")String> idRoles) {
    this.idRoles = idRoles;
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
        Objects.equals(this.correoElectronicoInstitucional, newEmpleado.correoElectronicoInstitucional) &&
        Objects.equals(this.idTipoPlaza, newEmpleado.idTipoPlaza) &&
        Objects.equals(this.idRegion, newEmpleado.idRegion) &&
        Objects.equals(this.idDireccion, newEmpleado.idDireccion) &&
        Objects.equals(this.idSubdireccion, newEmpleado.idSubdireccion) &&
        Objects.equals(this.idPuesto, newEmpleado.idPuesto) &&
        Objects.equals(this.idRoles, newEmpleado.idRoles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(persona, domicilio, escolaridades, fechaIngreso, correoElectronicoInstitucional, idTipoPlaza, idRegion, idDireccion, idSubdireccion, idPuesto, idRoles);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewEmpleadoDto {\n");
    sb.append("    persona: ").append(toIndentedString(persona)).append("\n");
    sb.append("    domicilio: ").append(toIndentedString(domicilio)).append("\n");
    sb.append("    escolaridades: ").append(toIndentedString(escolaridades)).append("\n");
    sb.append("    fechaIngreso: ").append(toIndentedString(fechaIngreso)).append("\n");
    sb.append("    correoElectronicoInstitucional: ").append(toIndentedString(correoElectronicoInstitucional)).append("\n");
    sb.append("    idTipoPlaza: ").append(toIndentedString(idTipoPlaza)).append("\n");
    sb.append("    idRegion: ").append(toIndentedString(idRegion)).append("\n");
    sb.append("    idDireccion: ").append(toIndentedString(idDireccion)).append("\n");
    sb.append("    idSubdireccion: ").append(toIndentedString(idSubdireccion)).append("\n");
    sb.append("    idPuesto: ").append(toIndentedString(idPuesto)).append("\n");
    sb.append("    idRoles: ").append(toIndentedString(idRoles)).append("\n");
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

