package mx.agr.dgec.validators.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import mx.agr.dgec.validators.NotBlankElementValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NotBlankElementValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(NotBlankElement.List.class)
public @interface NotBlankElement {
    String message() default "La lista no puede contener valores vacíos";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        NotBlankElement[] value();
    }
}
