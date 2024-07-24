package io.sevendiko.medalyst;

import io.sevendiko.medalyst.controller.IMedalystCalculatorController;
import io.sevendiko.medalyst.model.CalculatorRequest;
import io.sevendiko.medalyst.model.CalculatorResponse;
import io.sevendiko.medalyst.providers.GrossCalculatorArgumentProvider;
import io.sevendiko.medalyst.providers.InvalidArgumentsProvider;
import io.sevendiko.medalyst.providers.NetCalculatorArgumentProvider;
import io.sevendiko.medalyst.providers.VatCalculatorArgumentsProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MedalystApplicationTests {

    @Autowired
    private IMedalystCalculatorController calculatorController;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void contextLoads() {
        assertNotNull(applicationContext);
    }

    @ParameterizedTest
    @ArgumentsSource(VatCalculatorArgumentsProvider.class)
    void testCalculateFromVat(CalculatorRequest request, CalculatorResponse response) {

        CalculatorResponse actualResponse = calculatorController.calculate(request).getBody();

        assertEquals(response.net().setScale(2, RoundingMode.UNNECESSARY), actualResponse.net().setScale(2, RoundingMode.UNNECESSARY));
        assertEquals(response.vat().setScale(2, RoundingMode.UNNECESSARY), actualResponse.vat().setScale(2, RoundingMode.UNNECESSARY));
        assertEquals(response.gross().setScale(2, RoundingMode.UNNECESSARY), actualResponse.gross().setScale(2, RoundingMode.UNNECESSARY));
    }

    @ParameterizedTest
    @ArgumentsSource(GrossCalculatorArgumentProvider.class)
    void testCalculateFromGross(CalculatorRequest request, CalculatorResponse response) {

        CalculatorResponse actualResponse = calculatorController.calculate(request).getBody();

        assertEquals(response.net().setScale(2, RoundingMode.UNNECESSARY), actualResponse.net().setScale(2, RoundingMode.UNNECESSARY));
        assertEquals(response.vat().setScale(2, RoundingMode.UNNECESSARY), actualResponse.vat().setScale(2, RoundingMode.UNNECESSARY));
        assertEquals(response.gross().setScale(2, RoundingMode.UNNECESSARY), actualResponse.gross().setScale(2, RoundingMode.UNNECESSARY));
    }

    @ParameterizedTest
    @ArgumentsSource(NetCalculatorArgumentProvider.class)
    void testCalculateFromNet(CalculatorRequest request, CalculatorResponse response) {

        CalculatorResponse actualResponse = calculatorController.calculate(request).getBody();

        assertEquals(response.net().setScale(2, RoundingMode.UNNECESSARY), actualResponse.net().setScale(2, RoundingMode.UNNECESSARY));
        assertEquals(response.vat().setScale(2, RoundingMode.UNNECESSARY), actualResponse.vat().setScale(2, RoundingMode.UNNECESSARY));
        assertEquals(response.gross().setScale(2, RoundingMode.UNNECESSARY), actualResponse.gross().setScale(2, RoundingMode.UNNECESSARY));
    }

    @ParameterizedTest
    @ArgumentsSource(InvalidArgumentsProvider.class)
    void testInvalidArgumentsProvided(CalculatorRequest request, Class<? extends Throwable> expectedException) {
        assertThrows(expectedException, () -> calculatorController.calculate(request));
    }

}
