package io.sevendiko.medalyst.model;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record CalculatorResponse(
        BigDecimal vat,
        BigDecimal net,
        BigDecimal gross
) {}
