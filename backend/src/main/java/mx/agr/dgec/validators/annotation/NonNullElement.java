package mx.agr.dgec.validators.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import mx.agr.dgec.validators.NonNullElementValidator;

import java.lang.annotation.*;

@Constraint(validatedBy = NonNullElementValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(NonNullElement.List.class)
public @interface NonNullElement {
    String message() default "La lista no puede contener valores null";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        NonNullElement[] value();
    }
}
