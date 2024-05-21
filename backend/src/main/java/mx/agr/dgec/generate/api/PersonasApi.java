/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.5.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package mx.agr.dgec.generate.api;

import mx.agr.dgec.generate.model.ErrorDto;
import mx.agr.dgec.generate.model.RegistrosDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import mx.agr.dgec.validators.annotation.*;
import mx.agr.dgec.validators.*;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.5.0")
@Validated
@Tag(name = "Personas", description = "Funciones sobre personas")
public interface PersonasApi {

    /**
     * GET /api/personas/estadosCiviles : Recupera los estados civiles de una persona
     * Recupera los estados civiles de una persona permitidos por el sistema
     *
     * @return OK (status code 200)
     *         or Forbidden (status code 403)
     */
    @Operation(
        operationId = "recuperarEstadosCiviles",
        summary = "Recupera los estados civiles de una persona",
        description = "Recupera los estados civiles de una persona permitidos por el sistema",
        tags = { "Personas" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = RegistrosDto.class)))
            }),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            })
        },
        security = {
            @SecurityRequirement(name = "jwt")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/personas/estadosCiviles",
        produces = { "application/json" }
    )
    
    ResponseEntity<List<RegistrosDto>> recuperarEstadosCiviles(
        
    );


    /**
     * GET /api/personas/generos : Recuperar generos para una persona
     * Recupera los géneros de una persona permitidos por el sistema
     *
     * @return OK (status code 200)
     *         or Forbidden (status code 403)
     */
    @Operation(
        operationId = "recuperarGeneros",
        summary = "Recuperar generos para una persona",
        description = "Recupera los géneros de una persona permitidos por el sistema",
        tags = { "Personas" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = RegistrosDto.class)))
            }),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            })
        },
        security = {
            @SecurityRequirement(name = "jwt")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/personas/generos",
        produces = { "application/json" }
    )
    
    ResponseEntity<List<RegistrosDto>> recuperarGeneros(
        
    );

}
