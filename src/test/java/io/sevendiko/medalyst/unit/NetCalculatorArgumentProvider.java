package io.sevendiko.medalyst.unit;

import io.sevendiko.medalyst.model.CalculatorRequest;
import io.sevendiko.medalyst.model.CalculatorResponse;
import io.sevendiko.medalyst.model.VatPercentage;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class NetCalculatorArgumentProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(
                        CalculatorRequest
                                .builder()
                                .net(new BigDecimal(110))
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
                                .net(new BigDecimal(110))
                                .vatPercentage(VatPercentage.THIRTEEN_PERCENTAGE)
                                .build(),
                        CalculatorResponse
                                .builder()
                                .vat(new BigDecimal("14.30"))
                                .net(new BigDecimal("110.00"))
                                .gross(new BigDecimal("124.30"))
                                .build()
                ),
                Arguments.of(
                        CalculatorRequest
                                .builder()
                                .net(new BigDecimal(110))
                                .vatPercentage(VatPercentage.TEN_PERCENTAGE)
                                .build(),
                        CalculatorResponse
                                .builder()
                                .vat(new BigDecimal(11))
                                .net(new BigDecimal(110))
                                .gross(new BigDecimal(121))
                                .build()
                )
        );
    }
}
