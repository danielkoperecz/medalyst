package io.sevendiko.medalyst.model;

import io.sevendiko.medalyst.annotation.ExactlyOneField;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
@ExactlyOneField
public record CalculatorRequest(

        @Positive
        BigDecimal vat,
        @Positive
        BigDecimal net,
        @Positive
        BigDecimal gross,

        @NotNull
        VatPercentage vatPercentage
) {}
