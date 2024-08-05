/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.5.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package mx.agr.dgec.generate.api;

import mx.agr.dgec.generate.model.ActualizarDatosEmpleadoDto;
import mx.agr.dgec.generate.model.EmpleadoDto;
import mx.agr.dgec.generate.model.ErrorDto;
import mx.agr.dgec.generate.model.NewEmpleadoDto;
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
@Tag(name = "Empleados", description = "Funciones sobre empleados de la DGEC")
public interface EmpleadosApi {

    /**
     * PUT /api/empleados/{id} : Actualizar un empleado
     * Actualiza los datos de un empleado con base a su ID
     *
     * @param id ID del empleado (required)
     * @param actualizarDatosEmpleadoDto  (optional)
     * @return No Content (status code 204)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not Found (status code 404)
     */
    @Operation(
        operationId = "actualizarEmpleado",
        summary = "Actualizar un empleado",
        description = "Actualiza los datos de un empleado con base a su ID",
        tags = { "Empleados" },
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
        value = "/api/empleados/{id}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    ResponseEntity<Void> actualizarEmpleado(
        
@Parameter(name = "id", description = "ID del empleado", required = true, in = ParameterIn.PATH) @PathVariable("id") String id,
        @Parameter(name = "ActualizarDatosEmpleadoDto", description = "") @Valid
 @RequestBody(required = false) ActualizarDatosEmpleadoDto actualizarDatosEmpleadoDto
    );


    /**
     * POST /api/empleados : Crear un nuevo empleado
     * Crea un nuevo empleado
     *
     * @param newEmpleadoDto  (required)
     * @return Created (status code 201)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not Found (status code 404)
     *         or Conflict (status code 409)
     */
    @Operation(
        operationId = "crearEmpleado",
        summary = "Crear un nuevo empleado",
        description = "Crea un nuevo empleado",
        tags = { "Empleados" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Created", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = EmpleadoDto.class))
            }),
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
        value = "/api/empleados",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    ResponseEntity<EmpleadoDto> crearEmpleado(
        @Parameter(name = "NewEmpleadoDto", description = "", required = true) @Valid
 @RequestBody NewEmpleadoDto newEmpleadoDto
    );


    /**
     * DELETE /api/empleados/{id} : Eliminar un empleado
     * Elimina un empleado con base a su ID
     *
     * @param id ID del empleado (required)
     * @return No Content (status code 204)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not Found (status code 404)
     *         or Conflict (status code 409)
     */
    @Operation(
        operationId = "eliminarEmpleado",
        summary = "Eliminar un empleado",
        description = "Elimina un empleado con base a su ID",
        tags = { "Empleados" },
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
        method = RequestMethod.DELETE,
        value = "/api/empleados/{id}",
        produces = { "application/json" }
    )
    
    ResponseEntity<Void> eliminarEmpleado(
        
@Parameter(name = "id", description = "ID del empleado", required = true, in = ParameterIn.PATH) @PathVariable("id") String id
    );


    /**
     * GET /api/empleados/{id} : Recuperar un empleado
     * Recupera datos de un empleado con base a su ID
     *
     * @param id ID del empleado (required)
     * @return OK (status code 200)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not Found (status code 404)
     */
    @Operation(
        operationId = "recuperarEmpleado",
        summary = "Recuperar un empleado",
        description = "Recupera datos de un empleado con base a su ID",
        tags = { "Empleados" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = EmpleadoDto.class))
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
        value = "/api/empleados/{id}",
        produces = { "application/json" }
    )
    
    ResponseEntity<EmpleadoDto> recuperarEmpleado(
        
@Parameter(name = "id", description = "ID del empleado", required = true, in = ParameterIn.PATH) @PathVariable("id") String id
    );


    /**
     * GET /api/empleados : Recuperar empleados
     * Recupera todos los empleados registrados o recupera con base a filtros por Estado, Región, Dirección, Subdirección,  Tipo de Plaza, Puesto y/o Rol.
     *
     * @param idRegion ID de la Región (optional)
     * @param idDireccion ID de la Dirección (optional)
     * @param idSubdireccion ID de la Subdirección (optional)
     * @param idTipoPlaza ID del Tipo de Plaza (optional)
     * @param idPuesto ID del Puesto (optional)
     * @param idEstado ID del Estado (optional)
     * @param idRol ID del Rol (optional)
     * @return OK (status code 200)
     *         or No Content (status code 204)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     */
    @Operation(
        operationId = "recuperarEmpleados",
        summary = "Recuperar empleados",
        description = "Recupera todos los empleados registrados o recupera con base a filtros por Estado, Región, Dirección, Subdirección,  Tipo de Plaza, Puesto y/o Rol.",
        tags = { "Empleados" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = EmpleadoDto.class)))
            }),
            @ApiResponse(responseCode = "204", description = "No Content"),
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
        value = "/api/empleados",
        produces = { "application/json" }
    )
    
    ResponseEntity<List<EmpleadoDto>> recuperarEmpleados(
        
@Parameter(name = "idRegion", description = "ID de la Región", in = ParameterIn.QUERY) @Valid @RequestParam(value = "idRegion", required = false) String idRegion,
        
@Parameter(name = "idDireccion", description = "ID de la Dirección", in = ParameterIn.QUERY) @Valid @RequestParam(value = "idDireccion", required = false) String idDireccion,
        
@Parameter(name = "idSubdireccion", description = "ID de la Subdirección", in = ParameterIn.QUERY) @Valid @RequestParam(value = "idSubdireccion", required = false) String idSubdireccion,
        
@Parameter(name = "idTipoPlaza", description = "ID del Tipo de Plaza", in = ParameterIn.QUERY) @Valid @RequestParam(value = "idTipoPlaza", required = false) String idTipoPlaza,
        
@Parameter(name = "idPuesto", description = "ID del Puesto", in = ParameterIn.QUERY) @Valid @RequestParam(value = "idPuesto", required = false) String idPuesto,
        
@Parameter(name = "idEstado", description = "ID del Estado", in = ParameterIn.QUERY) @Valid @RequestParam(value = "idEstado", required = false) String idEstado,
        
@Parameter(name = "idRol", description = "ID del Rol", in = ParameterIn.QUERY) @Valid @RequestParam(value = "idRol", required = false) String idRol
    );


    /**
     * GET /api/empleados/motivosBaja : Recuperar motivos de baja
     * Recupera los motivos de bajas de un empleado permitidos por el sistema
     *
     * @return OK (status code 200)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     */
    @Operation(
        operationId = "recuperarMotivosBaja",
        summary = "Recuperar motivos de baja",
        description = "Recupera los motivos de bajas de un empleado permitidos por el sistema",
        tags = { "Empleados" },
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
        value = "/api/empleados/motivosBaja",
        produces = { "application/json" }
    )
    
    ResponseEntity<List<RegistrosDto>> recuperarMotivosBaja(
        
    );

}
