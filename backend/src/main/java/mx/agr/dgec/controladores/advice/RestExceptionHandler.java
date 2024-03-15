package mx.agr.dgec.controladores.advice;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import jakarta.annotation.Nonnull;
import lombok.extern.slf4j.Slf4j;
import mx.agr.dgec.generate.model.ErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
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

    // Error personalizado de validación @Valid
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            @Nonnull HttpHeaders headers,
            @Nonnull HttpStatusCode status,
            @Nonnull WebRequest request) {
        // Obtener los detalles de los errores de validación
        List<FieldError> erroresFiles = ex.getBindingResult().getFieldErrors();

        ErrorDto error = erroresFiles.stream()
                .map(errorFile -> new ErrorDto("ERROR_VALIDATOR", errorFile.getField() + " " + errorFile.getDefaultMessage()))
                .findFirst()
                .orElse(null); // Si no hay errores, error será null

        if(error != null) log.info("Error de validación: " + error.getMensaje());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // Error personalizado para errores de formato en JSON, ejemplo, recibir un booleano en lugar de un número
    @Override
    public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                               @Nonnull HttpHeaders headers,
                                                               @Nonnull HttpStatusCode status,
                                                               @Nonnull WebRequest request) {
        if (ex.getCause() instanceof InvalidFormatException ife) {
            var error = getError(ife);
            error.setMensaje(error.getMensaje() + " debe ser de tipo " + ife.getTargetType().getSimpleName());
            log.info("Error de tipo de dato: {}", error.getMensaje());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }

        if(ex.getCause() instanceof ValueInstantiationException vie) {
            var error = getError(vie);
            error.setMensaje(error.getMensaje() + ", el valor debe estar en la lista de valores permitidos y en mayúsculas");
            log.info("Error de valor permitido (Enum): {}", error.getMensaje());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }

        var error = new ErrorDto("ERROR", "Error en la solicitud, verifica las propiedades del objeto JSON");
        log.info("Error en la solicitud causado por MessageNotReadableException");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    private ErrorDto getError(JsonMappingException ex) {
        // Recuperar el nombre del campo que causó el error
        var fieldPath = ex.getPath().stream()
                .map(JsonMappingException.Reference::getFieldName)
                .filter(fieldName -> fieldName != null && !fieldName.isEmpty())
                .collect(Collectors.joining("."));
        var mensajeError = "El valor proporcionado para " + fieldPath + " no es válido";
        return new ErrorDto("ERROR_JSON", mensajeError);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDto> handleIllegalArgumentException(IllegalArgumentException ex) {
        var error = new ErrorDto("ERROR_ARGUMENT", ex.getMessage());
        log.info("Error de argumento ilegal: {}", error.getMensaje());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
