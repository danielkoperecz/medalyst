package io.sevendiko.medalyst.unit;

import io.sevendiko.medalyst.model.CalculatorRequest;
import io.sevendiko.medalyst.model.CalculatorResponse;
import io.sevendiko.medalyst.service.CalculatorService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {

    @Mock
    private CalculatorService calculatorService;

    @ParameterizedTest
    @ArgumentsSource(VatCalculatorArgumentsProvider.class)
    void testCalculateFromVat(CalculatorRequest request, CalculatorResponse response) {
        when(calculatorService.calculate(request)).thenReturn(response);

        CalculatorResponse actualResponse = calculatorService.calculate(request);

        assertEquals(response.net().setScale(2, RoundingMode.HALF_UP), actualResponse.net().setScale(2, RoundingMode.UNNECESSARY));
        assertEquals(response.vat().setScale(2, RoundingMode.HALF_UP), actualResponse.vat().setScale(2, RoundingMode.UNNECESSARY));
        assertEquals(response.gross().setScale(2, RoundingMode.HALF_UP), actualResponse.gross().setScale(2, RoundingMode.UNNECESSARY));
    }

    @ParameterizedTest
    @ArgumentsSource(GrossCalculatorArgumentProvider.class)
    void testCalculateFromGross(CalculatorRequest request, CalculatorResponse response) {
        when(calculatorService.calculate(request)).thenReturn(response);

        CalculatorResponse actualResponse = calculatorService.calculate(request);

        assertEquals(response.net().setScale(2, RoundingMode.HALF_UP), actualResponse.net().setScale(2, RoundingMode.UNNECESSARY));
        assertEquals(response.vat().setScale(2, RoundingMode.HALF_UP), actualResponse.vat().setScale(2, RoundingMode.UNNECESSARY));
        assertEquals(response.gross().setScale(2, RoundingMode.HALF_UP), actualResponse.gross().setScale(2, RoundingMode.UNNECESSARY));
    }

    @ParameterizedTest
    @ArgumentsSource(NetCalculatorArgumentProvider.class)
    void testCalculateFromNet(CalculatorRequest request, CalculatorResponse response) {
        when(calculatorService.calculate(request)).thenReturn(response);

        CalculatorResponse actualResponse = calculatorService.calculate(request);

        assertEquals(response.net().setScale(2, RoundingMode.HALF_UP), actualResponse.net().setScale(2, RoundingMode.UNNECESSARY));
        assertEquals(response.vat().setScale(2, RoundingMode.HALF_UP), actualResponse.vat().setScale(2, RoundingMode.UNNECESSARY));
        assertEquals(response.gross().setScale(2, RoundingMode.HALF_UP), actualResponse.gross().setScale(2, RoundingMode.UNNECESSARY));
    }
}
