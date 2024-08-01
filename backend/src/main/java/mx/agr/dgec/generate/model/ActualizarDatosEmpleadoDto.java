package mx.agr.dgec.generate.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mx.agr.dgec.generate.model.ActualizarDatosPersonaDto;
import mx.agr.dgec.generate.model.DomicilioDto;
import mx.agr.dgec.generate.model.EscolaridadDto;
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
 * ActualizarDatosEmpleadoDto
 */

@JsonTypeName("ActualizarDatosEmpleado")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
public class ActualizarDatosEmpleadoDto {

  private ActualizarDatosPersonaDto persona;

  private DomicilioDto domicilio;

  @Valid
  private List<@Valid EscolaridadDto> escolaridades = new ArrayList<>();

  private String correoElectronicoInstitucional;

  private String idTipoPlaza;

  private String idRegion;

  private String idDireccion;

  private String idSubdireccion;

  private String idPuesto;

  @Valid
  private List<@Pattern(regexp = "^[a-zA-Z0-9]+$")String> idRoles = new ArrayList<>();

  public ActualizarDatosEmpleadoDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ActualizarDatosEmpleadoDto(ActualizarDatosPersonaDto persona, DomicilioDto domicilio, List<@Valid EscolaridadDto> escolaridades, String correoElectronicoInstitucional, String idTipoPlaza, String idRegion, String idDireccion, String idSubdireccion, String idPuesto, List<@Pattern(regexp = "^[a-zA-Z0-9]+$")String> idRoles) {
    this.persona = persona;
    this.domicilio = domicilio;
    this.escolaridades = escolaridades;
    this.correoElectronicoInstitucional = correoElectronicoInstitucional;
    this.idTipoPlaza = idTipoPlaza;
    this.idRegion = idRegion;
    this.idDireccion = idDireccion;
    this.idSubdireccion = idSubdireccion;
    this.idPuesto = idPuesto;
    this.idRoles = idRoles;
  }

  public ActualizarDatosEmpleadoDto persona(ActualizarDatosPersonaDto persona) {
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
  public ActualizarDatosPersonaDto getPersona() {
    return persona;
  }

  public void setPersona(ActualizarDatosPersonaDto persona) {
    this.persona = persona;
  }

  public ActualizarDatosEmpleadoDto domicilio(DomicilioDto domicilio) {
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

  public ActualizarDatosEmpleadoDto escolaridades(List<@Valid EscolaridadDto> escolaridades) {
    this.escolaridades = escolaridades;
    return this;
  }

  public ActualizarDatosEmpleadoDto addEscolaridadesItem(EscolaridadDto escolaridadesItem) {
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

  public ActualizarDatosEmpleadoDto correoElectronicoInstitucional(String correoElectronicoInstitucional) {
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

  public ActualizarDatosEmpleadoDto idTipoPlaza(String idTipoPlaza) {
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

  public ActualizarDatosEmpleadoDto idRegion(String idRegion) {
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

  public ActualizarDatosEmpleadoDto idDireccion(String idDireccion) {
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

  public ActualizarDatosEmpleadoDto idSubdireccion(String idSubdireccion) {
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

  public ActualizarDatosEmpleadoDto idPuesto(String idPuesto) {
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

  public ActualizarDatosEmpleadoDto idRoles(List<@Pattern(regexp = "^[a-zA-Z0-9]+$")String> idRoles) {
    this.idRoles = idRoles;
    return this;
  }

  public ActualizarDatosEmpleadoDto addIdRolesItem(String idRolesItem) {
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
    ActualizarDatosEmpleadoDto actualizarDatosEmpleado = (ActualizarDatosEmpleadoDto) o;
    return Objects.equals(this.persona, actualizarDatosEmpleado.persona) &&
        Objects.equals(this.domicilio, actualizarDatosEmpleado.domicilio) &&
        Objects.equals(this.escolaridades, actualizarDatosEmpleado.escolaridades) &&
        Objects.equals(this.correoElectronicoInstitucional, actualizarDatosEmpleado.correoElectronicoInstitucional) &&
        Objects.equals(this.idTipoPlaza, actualizarDatosEmpleado.idTipoPlaza) &&
        Objects.equals(this.idRegion, actualizarDatosEmpleado.idRegion) &&
        Objects.equals(this.idDireccion, actualizarDatosEmpleado.idDireccion) &&
        Objects.equals(this.idSubdireccion, actualizarDatosEmpleado.idSubdireccion) &&
        Objects.equals(this.idPuesto, actualizarDatosEmpleado.idPuesto) &&
        Objects.equals(this.idRoles, actualizarDatosEmpleado.idRoles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(persona, domicilio, escolaridades, correoElectronicoInstitucional, idTipoPlaza, idRegion, idDireccion, idSubdireccion, idPuesto, idRoles);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActualizarDatosEmpleadoDto {\n");
    sb.append("    persona: ").append(toIndentedString(persona)).append("\n");
    sb.append("    domicilio: ").append(toIndentedString(domicilio)).append("\n");
    sb.append("    escolaridades: ").append(toIndentedString(escolaridades)).append("\n");
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

