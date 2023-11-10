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
 * Devuelve ID despues de registrar exitosamente una nueva persona
 */

@Schema(name = "PersonaCreadaDto", description = "Devuelve ID despues de registrar exitosamente una nueva persona")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class PersonaCreadaDto {

  private Integer id;

  public PersonaCreadaDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PersonaCreadaDto(Integer id) {
    this.id = id;
  }

  public PersonaCreadaDto id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * ID de la persona
   * @return id
  */
  @NotNull 
  @Schema(name = "id", description = "ID de la persona", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonaCreadaDto personaCreadaDto = (PersonaCreadaDto) o;
    return Objects.equals(this.id, personaCreadaDto.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonaCreadaDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

