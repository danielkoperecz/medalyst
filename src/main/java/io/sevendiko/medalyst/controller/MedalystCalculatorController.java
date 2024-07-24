package io.sevendiko.medalyst.controller;

import io.sevendiko.medalyst.model.CalculatorRequest;
import io.sevendiko.medalyst.model.CalculatorResponse;
import io.sevendiko.medalyst.service.ICalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedalystCalculatorController implements IMedalystCalculatorController {

    private final ICalculatorService calculatorService;

    public MedalystCalculatorController(ICalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @Override
    public ResponseEntity<CalculatorResponse> calculate(CalculatorRequest calculateRequest) {
        return ResponseEntity.ok(calculatorService.calculate(calculateRequest));
    }
}
