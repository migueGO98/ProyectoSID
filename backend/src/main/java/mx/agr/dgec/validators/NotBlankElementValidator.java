package mx.agr.dgec.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import mx.agr.dgec.validators.annotation.NotBlankElement;

import java.util.List;

public class NotBlankElementValidator implements ConstraintValidator<NotBlankElement, List<String>> {
    @Override
    public void initialize(NotBlankElement constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<String> list, ConstraintValidatorContext constraintValidatorContext) {
        if (list == null) return true; // No necesitamos validar una lista nula, esto se hace con @NotNull
        for (String element : list) {
            if (element == null) return true; // No necesitamos validar elementos nullos, esto se hace con @NotNullElement
            if (element.isBlank()) return false;
        }
        return true;
    }
}
