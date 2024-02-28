package mx.agr.dgec.controladores.advice;

import jakarta.annotation.Nonnull;
import lombok.extern.slf4j.Slf4j;
import mx.agr.dgec.generate.model.ErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.List;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            @Nonnull HttpHeaders headers,
            @Nonnull HttpStatusCode status,
            @Nonnull WebRequest request) {
        // Obtener los detalles de los errores de validación
        List<FieldError> erroresFiles = ex.getBindingResult().getFieldErrors();

        ErrorDto error = erroresFiles.stream()
                .map(errorFile -> new ErrorDto("VALIDATOR", errorFile.getField() + " " + errorFile.getDefaultMessage()))
                .findFirst()
                .orElse(null); // Si no hay errores, error será null

        if(error != null) log.info("Error de validación: CÓDIGO: " + error.getCodigo() + ", MENSAJE: " + error.getMensaje());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
