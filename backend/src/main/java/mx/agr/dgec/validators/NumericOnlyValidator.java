package mx.agr.dgec.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import mx.agr.dgec.validators.annotation.NumericOnly;

public class NumericOnlyValidator implements ConstraintValidator<NumericOnly, String> {

    @Override
    public void initialize(NumericOnly constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null || value.isEmpty() || value.isBlank()) return false;
        return value.matches("^\\d+$"); // El \\d es igual que [0-9]
    }
}
