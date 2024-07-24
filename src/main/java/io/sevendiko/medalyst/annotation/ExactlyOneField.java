package io.sevendiko.medalyst.annotation;

import io.sevendiko.medalyst.validator.ExactlyOneFieldValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ExactlyOneFieldValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExactlyOneField {
    String message() default "Exactly one of vat, net, or gross must be provided.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
