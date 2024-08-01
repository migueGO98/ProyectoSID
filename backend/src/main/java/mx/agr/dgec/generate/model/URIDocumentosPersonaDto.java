package mx.agr.dgec.generate.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
 * URIDocumentosPersonaDto
 */

@JsonTypeName("URIDocumentosPersona")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
public class URIDocumentosPersonaDto {

  private URI ine;

  private URI actaNacimiento;

  private URI numeroSeguroSocial;

  private URI curp;

  private URI rfc;

  private URI comprobanteDomicilio;

  @Valid
  private List<URI> titulosProfesionales = new ArrayList<>();

  @Valid
  private List<URI> cedulasProfesionales = new ArrayList<>();

  public URIDocumentosPersonaDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public URIDocumentosPersonaDto(URI ine, URI actaNacimiento, URI numeroSeguroSocial, URI curp, URI rfc, URI comprobanteDomicilio, List<URI> titulosProfesionales) {
    this.ine = ine;
    this.actaNacimiento = actaNacimiento;
    this.numeroSeguroSocial = numeroSeguroSocial;
    this.curp = curp;
    this.rfc = rfc;
    this.comprobanteDomicilio = comprobanteDomicilio;
    this.titulosProfesionales = titulosProfesionales;
  }

  public URIDocumentosPersonaDto ine(URI ine) {
    this.ine = ine;
    return this;
  }

  /**
   * Get ine
   * @return ine
  */
  @NotNull @Valid 

  @Schema(name = "ine", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("ine")
  public URI getIne() {
    return ine;
  }

  public void setIne(URI ine) {
    this.ine = ine;
  }

  public URIDocumentosPersonaDto actaNacimiento(URI actaNacimiento) {
    this.actaNacimiento = actaNacimiento;
    return this;
  }

  /**
   * Get actaNacimiento
   * @return actaNacimiento
  */
  @NotNull @Valid 

  @Schema(name = "actaNacimiento", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("actaNacimiento")
  public URI getActaNacimiento() {
    return actaNacimiento;
  }

  public void setActaNacimiento(URI actaNacimiento) {
    this.actaNacimiento = actaNacimiento;
  }

  public URIDocumentosPersonaDto numeroSeguroSocial(URI numeroSeguroSocial) {
    this.numeroSeguroSocial = numeroSeguroSocial;
    return this;
  }

  /**
   * Get numeroSeguroSocial
   * @return numeroSeguroSocial
  */
  @NotNull @Valid 

  @Schema(name = "numeroSeguroSocial", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("numeroSeguroSocial")
  public URI getNumeroSeguroSocial() {
    return numeroSeguroSocial;
  }

  public void setNumeroSeguroSocial(URI numeroSeguroSocial) {
    this.numeroSeguroSocial = numeroSeguroSocial;
  }

  public URIDocumentosPersonaDto curp(URI curp) {
    this.curp = curp;
    return this;
  }

  /**
   * Get curp
   * @return curp
  */
  @NotNull @Valid 

  @Schema(name = "curp", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("curp")
  public URI getCurp() {
    return curp;
  }

  public void setCurp(URI curp) {
    this.curp = curp;
  }

  public URIDocumentosPersonaDto rfc(URI rfc) {
    this.rfc = rfc;
    return this;
  }

  /**
   * Get rfc
   * @return rfc
  */
  @NotNull @Valid 

  @Schema(name = "rfc", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("rfc")
  public URI getRfc() {
    return rfc;
  }

  public void setRfc(URI rfc) {
    this.rfc = rfc;
  }

  public URIDocumentosPersonaDto comprobanteDomicilio(URI comprobanteDomicilio) {
    this.comprobanteDomicilio = comprobanteDomicilio;
    return this;
  }

  /**
   * Get comprobanteDomicilio
   * @return comprobanteDomicilio
  */
  @NotNull @Valid 

  @Schema(name = "comprobanteDomicilio", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("comprobanteDomicilio")
  public URI getComprobanteDomicilio() {
    return comprobanteDomicilio;
  }

  public void setComprobanteDomicilio(URI comprobanteDomicilio) {
    this.comprobanteDomicilio = comprobanteDomicilio;
  }

  public URIDocumentosPersonaDto titulosProfesionales(List<URI> titulosProfesionales) {
    this.titulosProfesionales = titulosProfesionales;
    return this;
  }

  public URIDocumentosPersonaDto addTitulosProfesionalesItem(URI titulosProfesionalesItem) {
    if (this.titulosProfesionales == null) {
      this.titulosProfesionales = new ArrayList<>();
    }
    this.titulosProfesionales.add(titulosProfesionalesItem);
    return this;
  }

  /**
   * Get titulosProfesionales
   * @return titulosProfesionales
  */
  @NotNull @Valid 
@Size(min = 1, max = 10) 
  @Schema(name = "titulosProfesionales", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("titulosProfesionales")
  public List<URI> getTitulosProfesionales() {
    return titulosProfesionales;
  }

  public void setTitulosProfesionales(List<URI> titulosProfesionales) {
    this.titulosProfesionales = titulosProfesionales;
  }

  public URIDocumentosPersonaDto cedulasProfesionales(List<URI> cedulasProfesionales) {
    this.cedulasProfesionales = cedulasProfesionales;
    return this;
  }

  public URIDocumentosPersonaDto addCedulasProfesionalesItem(URI cedulasProfesionalesItem) {
    if (this.cedulasProfesionales == null) {
      this.cedulasProfesionales = new ArrayList<>();
    }
    this.cedulasProfesionales.add(cedulasProfesionalesItem);
    return this;
  }

  /**
   * Get cedulasProfesionales
   * @return cedulasProfesionales
  */
  @Valid 
@Size(min = 0, max = 10) 
  @Schema(name = "cedulasProfesionales", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cedulasProfesionales")
  public List<URI> getCedulasProfesionales() {
    return cedulasProfesionales;
  }

  public void setCedulasProfesionales(List<URI> cedulasProfesionales) {
    this.cedulasProfesionales = cedulasProfesionales;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    URIDocumentosPersonaDto urIDocumentosPersona = (URIDocumentosPersonaDto) o;
    return Objects.equals(this.ine, urIDocumentosPersona.ine) &&
        Objects.equals(this.actaNacimiento, urIDocumentosPersona.actaNacimiento) &&
        Objects.equals(this.numeroSeguroSocial, urIDocumentosPersona.numeroSeguroSocial) &&
        Objects.equals(this.curp, urIDocumentosPersona.curp) &&
        Objects.equals(this.rfc, urIDocumentosPersona.rfc) &&
        Objects.equals(this.comprobanteDomicilio, urIDocumentosPersona.comprobanteDomicilio) &&
        Objects.equals(this.titulosProfesionales, urIDocumentosPersona.titulosProfesionales) &&
        Objects.equals(this.cedulasProfesionales, urIDocumentosPersona.cedulasProfesionales);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ine, actaNacimiento, numeroSeguroSocial, curp, rfc, comprobanteDomicilio, titulosProfesionales, cedulasProfesionales);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class URIDocumentosPersonaDto {\n");
    sb.append("    ine: ").append(toIndentedString(ine)).append("\n");
    sb.append("    actaNacimiento: ").append(toIndentedString(actaNacimiento)).append("\n");
    sb.append("    numeroSeguroSocial: ").append(toIndentedString(numeroSeguroSocial)).append("\n");
    sb.append("    curp: ").append(toIndentedString(curp)).append("\n");
    sb.append("    rfc: ").append(toIndentedString(rfc)).append("\n");
    sb.append("    comprobanteDomicilio: ").append(toIndentedString(comprobanteDomicilio)).append("\n");
    sb.append("    titulosProfesionales: ").append(toIndentedString(titulosProfesionales)).append("\n");
    sb.append("    cedulasProfesionales: ").append(toIndentedString(cedulasProfesionales)).append("\n");
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

