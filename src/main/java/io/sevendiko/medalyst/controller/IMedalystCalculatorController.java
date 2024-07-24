package io.sevendiko.medalyst.controller;

import io.sevendiko.medalyst.model.CalculatorRequest;
import io.sevendiko.medalyst.model.CalculatorResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Validated
public interface IMedalystCalculatorController {

    @PostMapping("/calculate")
    ResponseEntity<CalculatorResponse> calculate(@Valid @RequestBody CalculatorRequest calculateRequest);
}
