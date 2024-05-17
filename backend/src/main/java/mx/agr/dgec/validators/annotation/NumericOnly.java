package mx.agr.dgec.validators.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import mx.agr.dgec.validators.NumericOnlyValidator;

import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = NumericOnlyValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
public @interface NumericOnly {
    String message() default "La cadena debe contener solo caracteres numéricos";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
