/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.5.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package mx.agr.dgec.generate.api;

import mx.agr.dgec.generate.model.ErrorDto;
import mx.agr.dgec.generate.model.RegistrosDto;
import mx.agr.dgec.generate.model.URIDocumentosPersonaDto;
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
     * PUT /api/persona/{id}/documentos : Actualizar documentos
     * Actualiza los documentos de un empleado con base a su ID
     *
     * @param id ID de la persona (required)
     * @param ine  (required)
     * @param actaNacimiento  (required)
     * @param numeroSeguroSocial  (required)
     * @param curp  (required)
     * @param rfc  (required)
     * @param comprobanteDomicilio  (required)
     * @param titulosProfesionales  (required)
     * @param cedulasProfesionales  (optional)
     * @return No Content (status code 204)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not Found (status code 404)
     */
    @Operation(
        operationId = "actualizarDocumentos",
        summary = "Actualizar documentos",
        description = "Actualiza los documentos de un empleado con base a su ID",
        tags = { "Personas" },
        responses = {
            @ApiResponse(responseCode = "204", description = "No Content"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            }),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            }),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "Not Found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            })
        },
        security = {
            @SecurityRequirement(name = "jwt")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/api/persona/{id}/documentos",
        produces = { "application/json" },
        consumes = { "multipart/form-data" }
    )
    
    ResponseEntity<Void> actualizarDocumentos(
        
@Parameter(name = "id", description = "ID de la persona", required = true, in = ParameterIn.PATH) @PathVariable("id") String id,
        @Parameter(name = "ine", description = "", required = true) @RequestPart(value = "ine", required = true) MultipartFile ine,
        @Parameter(name = "actaNacimiento", description = "", required = true) @RequestPart(value = "actaNacimiento", required = true) MultipartFile actaNacimiento,
        @Parameter(name = "numeroSeguroSocial", description = "", required = true) @RequestPart(value = "numeroSeguroSocial", required = true) MultipartFile numeroSeguroSocial,
        @Parameter(name = "curp", description = "", required = true) @RequestPart(value = "curp", required = true) MultipartFile curp,
        @Parameter(name = "rfc", description = "", required = true) @RequestPart(value = "rfc", required = true) MultipartFile rfc,
        @Parameter(name = "comprobanteDomicilio", description = "", required = true) @RequestPart(value = "comprobanteDomicilio", required = true) MultipartFile comprobanteDomicilio,
        @Parameter(name = "titulosProfesionales", description = "", required = true) @RequestPart(value = "titulosProfesionales", required = true) List<MultipartFile> titulosProfesionales,
        @Parameter(name = "cedulasProfesionales", description = "") @RequestPart(value = "cedulasProfesionales", required = false) List<MultipartFile> cedulasProfesionales
    );


    /**
     * GET /api/persona/{id}/documentos : Recuperar documentos persona
     * Recupera los documentos oficiales de una persona
     *
     * @param id ID de la persona (required)
     * @return OK (status code 200)
     *         or No Content (status code 204)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not Found (status code 404)
     */
    @Operation(
        operationId = "recuperarDocumentos",
        summary = "Recuperar documentos persona",
        description = "Recupera los documentos oficiales de una persona",
        tags = { "Personas" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = URIDocumentosPersonaDto.class))
            }),
            @ApiResponse(responseCode = "204", description = "No Content"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            }),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            }),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "Not Found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            })
        },
        security = {
            @SecurityRequirement(name = "jwt")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/persona/{id}/documentos",
        produces = { "application/json" }
    )
    
    ResponseEntity<URIDocumentosPersonaDto> recuperarDocumentos(
        
@Parameter(name = "id", description = "ID de la persona", required = true, in = ParameterIn.PATH) @PathVariable("id") String id
    );


    /**
     * GET /api/personas/estadosCiviles : Recupera los estados civiles de una persona
     * Recupera los estados civiles de una persona permitidos por el sistema
     *
     * @return OK (status code 200)
     *         or Unauthorized (status code 401)
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
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
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
     *         or Unauthorized (status code 401)
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
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
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


    /**
     * POST /api/persona/{id}/documentos : Subir documentos persona
     * Sube los documentos oficiales de una persona
     *
     * @param id ID de la persona (required)
     * @param ine  (required)
     * @param actaNacimiento  (required)
     * @param numeroSeguroSocial  (required)
     * @param curp  (required)
     * @param rfc  (required)
     * @param comprobanteDomicilio  (required)
     * @param titulosProfesionales  (required)
     * @param cedulasProfesionales  (optional)
     * @return Created (status code 201)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not Found (status code 404)
     *         or Conflict (status code 409)
     */
    @Operation(
        operationId = "subirDocumentos",
        summary = "Subir documentos persona",
        description = "Sube los documentos oficiales de una persona",
        tags = { "Personas" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            }),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            }),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "Not Found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            }),
            @ApiResponse(responseCode = "409", description = "Conflict", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            })
        },
        security = {
            @SecurityRequirement(name = "jwt")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/api/persona/{id}/documentos",
        produces = { "application/json" },
        consumes = { "multipart/form-data" }
    )
    
    ResponseEntity<Void> subirDocumentos(
        
@Parameter(name = "id", description = "ID de la persona", required = true, in = ParameterIn.PATH) @PathVariable("id") String id,
        @Parameter(name = "ine", description = "", required = true) @RequestPart(value = "ine", required = true) MultipartFile ine,
        @Parameter(name = "actaNacimiento", description = "", required = true) @RequestPart(value = "actaNacimiento", required = true) MultipartFile actaNacimiento,
        @Parameter(name = "numeroSeguroSocial", description = "", required = true) @RequestPart(value = "numeroSeguroSocial", required = true) MultipartFile numeroSeguroSocial,
        @Parameter(name = "curp", description = "", required = true) @RequestPart(value = "curp", required = true) MultipartFile curp,
        @Parameter(name = "rfc", description = "", required = true) @RequestPart(value = "rfc", required = true) MultipartFile rfc,
        @Parameter(name = "comprobanteDomicilio", description = "", required = true) @RequestPart(value = "comprobanteDomicilio", required = true) MultipartFile comprobanteDomicilio,
        @Parameter(name = "titulosProfesionales", description = "", required = true) @RequestPart(value = "titulosProfesionales", required = true) List<MultipartFile> titulosProfesionales,
        @Parameter(name = "cedulasProfesionales", description = "") @RequestPart(value = "cedulasProfesionales", required = false) List<MultipartFile> cedulasProfesionales
    );

}
