package bsuir.labs.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotZeroValidator implements ConstraintValidator<NotZero, Number> {

    @Override
    public void initialize(NotZero constraintAnnotation) {
    }

    @Override
    public boolean isValid(Number value, ConstraintValidatorContext context) {
        return value != null && value.doubleValue() != 0;
    }
}