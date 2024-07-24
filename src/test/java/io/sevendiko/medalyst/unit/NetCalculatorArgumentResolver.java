package io.sevendiko.medalyst.unit;

import io.sevendiko.medalyst.model.CalculatorRequest;
import io.sevendiko.medalyst.model.CalculatorResponse;
import io.sevendiko.medalyst.model.VatPercentage;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class NetCalculatorArgumentResolver implements ArgumentsProvider {

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
                )
        );
    }
}
