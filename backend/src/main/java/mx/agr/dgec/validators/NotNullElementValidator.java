package mx.agr.dgec.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import mx.agr.dgec.validators.annotation.NotNullElement;

import java.util.List;

public class NotNullElementValidator implements ConstraintValidator<NotNullElement, List<?>> {
    @Override
    public void initialize(NotNullElement constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<?> list, ConstraintValidatorContext constraintValidatorContext) {
        if (list == null) return true; // No necesitamos validar una lista nula, esto se hace con @NotNull
        for (Object element : list)
            if (element == null) return false;
        return true;
    }
}
