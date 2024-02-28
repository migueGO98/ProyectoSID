/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.0.1).
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
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
@Tag(name = "Escolaridades", description = "Funciones sobre niveles escolares")
public interface EscolaridadesApi {

    /**
     * GET /api/escolaridades/niveles/estados : Recuperar estados niveles escolares
     * Recupera los estados de los niveles escolares permitidos por el sistema 
     *
     * @return OK (status code 200)
     *         or Forbidden (status code 403)
     */
    @Operation(
        operationId = "recuperarEstadosNivelesEscolares",
        summary = "Recuperar estados niveles escolares",
        description = "Recupera los estados de los niveles escolares permitidos por el sistema ",
        tags = { "Escolaridades" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = RegistrosDto.class)))
            }),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/escolaridades/niveles/estados",
        produces = { "application/json" }
    )
    ResponseEntity<List<RegistrosDto>> recuperarEstadosNivelesEscolares(
        
    );


    /**
     * GET /api/escolaridades/niveles : Recuperar niveles escolares
     * Recupera los niveles escolares permitidos por el sistema
     *
     * @return OK (status code 200)
     *         or Forbidden (status code 403)
     */
    @Operation(
        operationId = "recuperarNivelesEscolares",
        summary = "Recuperar niveles escolares",
        description = "Recupera los niveles escolares permitidos por el sistema",
        tags = { "Escolaridades" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = RegistrosDto.class)))
            }),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/escolaridades/niveles",
        produces = { "application/json" }
    )
    ResponseEntity<List<RegistrosDto>> recuperarNivelesEscolares(
        
    );

}
