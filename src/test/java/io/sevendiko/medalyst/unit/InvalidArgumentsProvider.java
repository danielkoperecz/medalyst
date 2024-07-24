package io.sevendiko.medalyst.unit;

import io.sevendiko.medalyst.model.CalculatorRequest;
import io.sevendiko.medalyst.model.VatPercentage;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class InvalidArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(
                        CalculatorRequest
                                .builder()
                                .net(new BigDecimal(110))
                                .build(),
                        ConstraintViolationException.class
                ),
                Arguments.of(
                        CalculatorRequest
                                .builder()
                                .net(new BigDecimal(110))
                                .gross(new BigDecimal(100))
                                .vatPercentage(VatPercentage.TWENTY_PERCENTAGE)
                                .build(),
                        ConstraintViolationException.class
                ),
                Arguments.of(
                        CalculatorRequest
                                .builder()
                                .vatPercentage(VatPercentage.TWENTY_PERCENTAGE)
                                .build(),
                        ConstraintViolationException.class
                ),
                Arguments.of(
                        CalculatorRequest
                                .builder()
                                .net(new BigDecimal(-110))
                                .vatPercentage(VatPercentage.TWENTY_PERCENTAGE)
                                .build(),
                        ConstraintViolationException.class
                )
        );
    }
}
