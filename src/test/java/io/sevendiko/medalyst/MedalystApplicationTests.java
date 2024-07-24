package io.sevendiko.medalyst;

import io.sevendiko.medalyst.controller.IMedalystCalculatorController;
import io.sevendiko.medalyst.model.CalculatorRequest;
import io.sevendiko.medalyst.service.ICalculatorService;
import io.sevendiko.medalyst.unit.InvalidArgumentsProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    @ArgumentsSource(InvalidArgumentsProvider.class)
    void testInvalidArgumentsProvided(CalculatorRequest request, Class<? extends Throwable> expectedException) {
        assertThrows(expectedException, () -> calculatorController.calculate(request));
    }

}
