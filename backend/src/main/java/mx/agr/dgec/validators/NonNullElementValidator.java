package mx.agr.dgec.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import mx.agr.dgec.validators.annotation.NonNullElement;

import java.util.List;

public class NonNullElementValidator implements ConstraintValidator<NonNullElement, List<?>> {

    @Override
    public boolean isValid(List<?> list, ConstraintValidatorContext context) {
        if (list == null) return true; // No necesitamos validar una lista nula, esto se hace con @NotNull
        for (Object element : list)
            if (element == null) return false;
        return true;
    }
}
