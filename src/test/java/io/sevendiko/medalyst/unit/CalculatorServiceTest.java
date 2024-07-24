package io.sevendiko.medalyst.unit;

import io.sevendiko.medalyst.model.CalculatorRequest;
import io.sevendiko.medalyst.model.CalculatorResponse;
import io.sevendiko.medalyst.service.ICalculatorService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculatorServiceTest {

    @Autowired
    private ICalculatorService calculatorService;

    @ParameterizedTest
    @ArgumentsSource(VatCalculatorArgumentsProvider.class)
    void testCalculateFromVat(CalculatorRequest request, CalculatorResponse response) {

        CalculatorResponse actualResponse = calculatorService.calculate(request);

        assertEquals(response.net().setScale(2, RoundingMode.UNNECESSARY), actualResponse.net().setScale(2, RoundingMode.UNNECESSARY));
        assertEquals(response.vat().setScale(2, RoundingMode.UNNECESSARY), actualResponse.vat().setScale(2, RoundingMode.UNNECESSARY));
        assertEquals(response.gross().setScale(2, RoundingMode.UNNECESSARY), actualResponse.gross().setScale(2, RoundingMode.UNNECESSARY));
    }

    @ParameterizedTest
    @ArgumentsSource(GrossCalculatorArgumentProvider.class)
    void testCalculateFromGross(CalculatorRequest request, CalculatorResponse response) {

        CalculatorResponse actualResponse = calculatorService.calculate(request);

        assertEquals(response.net().setScale(2, RoundingMode.UNNECESSARY), actualResponse.net().setScale(2, RoundingMode.UNNECESSARY));
        assertEquals(response.vat().setScale(2, RoundingMode.UNNECESSARY), actualResponse.vat().setScale(2, RoundingMode.UNNECESSARY));
        assertEquals(response.gross().setScale(2, RoundingMode.UNNECESSARY), actualResponse.gross().setScale(2, RoundingMode.UNNECESSARY));
    }

    @ParameterizedTest
    @ArgumentsSource(NetCalculatorArgumentProvider.class)
    void testCalculateFromNet(CalculatorRequest request, CalculatorResponse response) {

        CalculatorResponse actualResponse = calculatorService.calculate(request);

        assertEquals(response.net().setScale(2, RoundingMode.UNNECESSARY), actualResponse.net().setScale(2, RoundingMode.UNNECESSARY));
        assertEquals(response.vat().setScale(2, RoundingMode.UNNECESSARY), actualResponse.vat().setScale(2, RoundingMode.UNNECESSARY));
        assertEquals(response.gross().setScale(2, RoundingMode.UNNECESSARY), actualResponse.gross().setScale(2, RoundingMode.UNNECESSARY));
    }
}
