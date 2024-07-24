package io.sevendiko.medalyst.service;

import io.sevendiko.medalyst.model.CalculatorRequest;
import io.sevendiko.medalyst.model.CalculatorResponse;

public interface ICalculatorService {

    CalculatorResponse calculate(CalculatorRequest calculatorRequest);
}
