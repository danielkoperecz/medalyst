package io.sevendiko.medalyst.validator;

import io.sevendiko.medalyst.annotation.ExactlyOneField;
import io.sevendiko.medalyst.model.CalculatorRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ExactlyOneFieldValidator implements ConstraintValidator<ExactlyOneField, CalculatorRequest> {

    @Override
    public boolean isValid(CalculatorRequest request, ConstraintValidatorContext context) {
        int nonNullFieldCount = 0;

        if (request.vat() != null) {
            nonNullFieldCount++;
        }
        if (request.net() != null) {
            nonNullFieldCount++;
        }
        if (request.gross() != null) {
            nonNullFieldCount++;
        }

        return nonNullFieldCount == 1;
    }
}
