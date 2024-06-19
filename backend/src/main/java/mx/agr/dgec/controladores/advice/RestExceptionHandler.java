package mx.agr.dgec.controladores.advice;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import jakarta.annotation.Nonnull;
import lombok.extern.slf4j.Slf4j;
import mx.agr.dgec.exceptions.ElementoNoEncontradoException;
import mx.agr.dgec.exceptions.ElementoNoPerteneceException;
import mx.agr.dgec.exceptions.ReglaNegocioException;
import mx.agr.dgec.generate.model.ErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Object> handleAuthenticationException(AuthenticationException ex) {

        if(ex instanceof InsufficientAuthenticationException) {
            var error = new ErrorDto("ERROR_AUTH", "No se ha proporcionado un medio de autenticación");
            log.info("No se ha proporcionado alguna autentificación: {}", ex.getMessage());
            return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
        }

        if(ex instanceof CredentialsExpiredException) {
            var error = new ErrorDto("ERROR_AUTH_CRED", "Credencial expirada");
            log.info("Credencial expirada: {}", ex.getMessage());
            return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
        }

        var error = new ErrorDto("ERROR_AUTH", "Error de autenticación");
        log.info("Error de autenticación: {}", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> handleAccessDeniedException(AccessDeniedException ex) {
        var error = new ErrorDto("ERROR_ACCESS_DENIED", "No tienes permisos para acceder a este recurso");
        log.info("Acceso denegado: {}", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
    }

    // Error personalizado de validación @Valid (Para los Dto)
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            @Nonnull HttpHeaders headers,
            @Nonnull HttpStatusCode status,
            @Nonnull WebRequest request) {
        // Obtener los detalles de los errores de validación
        List<FieldError> erroresFiles = ex.getBindingResult().getFieldErrors();

        ErrorDto error = erroresFiles.stream()
                .map(errorFile -> new ErrorDto("ERROR_IN_ATTRIBUTE", errorFile.getField() + ": " + errorFile.getDefaultMessage()))
                .findFirst()
                .orElse(null); // Si no hay errores, error será null

        if(error != null) log.info("Error en el campo {}", error.getMensaje());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // Error personalizado para errores de formato en JSON, ejemplo, recibir un booleano en lugar de un número (Para el body request)
    @Override
    public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                               @Nonnull HttpHeaders headers,
                                                               @Nonnull HttpStatusCode status,
                                                               @Nonnull WebRequest request) {
        // Para tipos de datos no válidos
        if (ex.getCause() instanceof InvalidFormatException ife) {
            var error = getError(ife);
            log.info("Error de tipo de dato: {}", error.getMensaje());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }

        // Para los enums
        if(ex.getCause() instanceof ValueInstantiationException vie) {
            var error = getError(vie);
            error.setMensaje(error.getMensaje() + ", el valor debe estar en la lista de valores permitidos");
            log.info("Error de valor permitido (Enum): {}", error.getMensaje());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }

        // Errores en parsear el objeto JSON a un Dto (errores en el tipo de dato)
        if(ex.getCause() instanceof MismatchedInputException mie) {
            var error = getError(mie);
            error.setMensaje(error.getMensaje() + ", tipo de dato incorrecto");
            log.info("Errores en el cuerpo de la petición: {}", error.getMensaje());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }

        // Error por default por no detectar que Exception es lanzada por Jackson
        var error = new ErrorDto("ERROR", "Error en la solicitud, verifica el cuerpo de la petición");

        log.error("Errores en el cuerpo de la petición, exception general by MessageNotReadableException, Throw by {}, msj: {}", ex.getCause(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    private ErrorDto getError(JsonMappingException ex) {
        // Recuperar el nombre del campo que causó el error
        var fieldPath = ex.getPath().stream()
                .map(JsonMappingException.Reference::getFieldName)
                .filter(fieldName -> fieldName != null && !fieldName.isEmpty())
                .collect(Collectors.joining("."));
        var mensajeError = "El valor proporcionado para " + fieldPath + " no es válido";
        return new ErrorDto("ERROR_BODY_REQUEST", mensajeError);
    }


    @ExceptionHandler(ReglaNegocioException.class)
    public ResponseEntity<ErrorDto> handleReglaNegocioException(ReglaNegocioException ex) {
        var error = new ErrorDto("ERROR_REG_NG", ex.getMessage());
        log.info("No cumple con la Regla de negocio: {}", error.getMensaje());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ElementoNoEncontradoException.class)
    public ResponseEntity<ErrorDto> handleElementoNoEncontradoException(ElementoNoEncontradoException ex) {
        var error = new ErrorDto("ERROR_ELEMENT_NOT_EXIST", ex.getMessage());
        log.info("Elemento no encontrado: {}", error.getMensaje());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ElementoNoPerteneceException.class)
    public ResponseEntity<ErrorDto> handleElementoNoPerteneceException(ElementoNoPerteneceException ex) {
        var error = new ErrorDto("ERROR_ELEMENT_NOT_BELONG", ex.getMessage());
        log.info("Elemento no pertenece: {}", error.getMensaje());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /*********************************
     * Las siguientes exception se marcan con log.WARN porque es un error que no debería ocurrir y es un error de programación
     *********************************
     */

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDto> handleNullPointerException(NullPointerException ex) {
        var error = new ErrorDto("ERROR_NPE", "Ha ocurrido un error, comunicate con el administrador");
        log.warn("Ha ocurrido un error de puntero nulo: {}", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDto> handleIllegalArgumentException(IllegalArgumentException ex) {
        var error = new ErrorDto("ERROR_IAE", ex.getMessage());
        log.warn("Error de argumento ilegal: {}", error.getMensaje());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
