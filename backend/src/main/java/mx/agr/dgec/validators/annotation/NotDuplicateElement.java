package mx.agr.dgec.validators.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import mx.agr.dgec.validators.NotDuplicateElementValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NotDuplicateElementValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(NotDuplicateElement.List.class)
public @interface NotDuplicateElement {
    String message() default "La lista no puede contener valores duplicados";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        NotDuplicateElement[] value();
    }
}
