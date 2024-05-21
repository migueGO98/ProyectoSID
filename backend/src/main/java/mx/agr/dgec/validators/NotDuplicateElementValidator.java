package mx.agr.dgec.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import mx.agr.dgec.validators.annotation.NotDuplicateElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NotDuplicateElementValidator implements ConstraintValidator<NotDuplicateElement, List<?>> {
    @Override
    public void initialize(NotDuplicateElement constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<?> list, ConstraintValidatorContext constraintValidatorContext) {
        if (list == null) return true; // No necesitamos validar una lista nula, esto se hace con @NotNull

        Set<Object> set = new HashSet<>();
        for (Object element : list) {
            if (element == null) return true; // No necesitamos validar elementos nullos, esto se hace con @NotNullElement
            if (!set.add(element)) return false; // Se encontró un elemento duplicado
        }
        return true;
    }
}
