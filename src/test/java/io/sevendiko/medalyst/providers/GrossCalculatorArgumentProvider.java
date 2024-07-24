package io.sevendiko.medalyst.providers;

import io.sevendiko.medalyst.model.CalculatorRequest;
import io.sevendiko.medalyst.model.CalculatorResponse;
import io.sevendiko.medalyst.model.VatPercentage;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class GrossCalculatorArgumentProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(
                        CalculatorRequest
                                .builder()
                                .gross(new BigDecimal(132))
                                .vatPercentage(VatPercentage.TWENTY_PERCENTAGE)
                                .build(),
                        CalculatorResponse
                                .builder()
                                .vat(new BigDecimal(22))
                                .net(new BigDecimal(110))
                                .gross(new BigDecimal(132))
                                .build()
                ),
                Arguments.of(
                        CalculatorRequest
                                .builder()
                                .gross(new BigDecimal(100))
                                .vatPercentage(VatPercentage.THIRTEEN_PERCENTAGE)
                                .build(),
                        CalculatorResponse
                                .builder()
                                .vat(new BigDecimal("11.50"))
                                .net(new BigDecimal("88.50"))
                                .gross(new BigDecimal("100.00"))
                                .build()
                ),
                Arguments.of(
                        CalculatorRequest
                                .builder()
                                .gross(new BigDecimal(132))
                                .vatPercentage(VatPercentage.TEN_PERCENTAGE)
                                .build(),
                        CalculatorResponse
                                .builder()
                                .vat(new BigDecimal(12))
                                .net(new BigDecimal(120))
                                .gross(new BigDecimal(132))
                                .build()
                )
        );
    }
}
