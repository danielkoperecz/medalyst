package io.sevendiko.medalyst.service;

import io.sevendiko.medalyst.model.CalculatorRequest;
import io.sevendiko.medalyst.model.CalculatorResponse;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculatorService implements ICalculatorService {

    private static final BigDecimal HUNDRED_PERCENT = new BigDecimal(100);

    @Override
    public CalculatorResponse calculate(final CalculatorRequest calculatorRequest) {
        if (calculatorRequest.vat() != null) {
            return calculateFromVat(calculatorRequest.vat(), calculatorRequest.vatPercentage().getValue());
        }
        if (calculatorRequest.net() != null) {
            return calculateFromNet(calculatorRequest.net(), calculatorRequest.vatPercentage().getValue());
        }
        if (calculatorRequest.gross() != null) {
            return calculateFromGross(calculatorRequest.gross(), calculatorRequest.vatPercentage().getValue());
        }

        return null;
    }

    private CalculatorResponse calculateFromVat(final BigDecimal vat, final Integer vatRate) {
        BigDecimal vatRateDecimal = new BigDecimal(vatRate).divide(HUNDRED_PERCENT, 2, RoundingMode.UNNECESSARY);
        BigDecimal net = vat.divide(vatRateDecimal, 2, RoundingMode.HALF_UP);
        BigDecimal gross = net.add(vat);

        return CalculatorResponse.builder()
                .vat(vat)
                .net(net)
                .gross(gross)
                .build();
    }

    private CalculatorResponse calculateFromNet(final BigDecimal net, final Integer vatRate) {
        BigDecimal vatRateDecimal = new BigDecimal(vatRate).divide(HUNDRED_PERCENT, 2, RoundingMode.UNNECESSARY);
        BigDecimal vat = net.multiply(vatRateDecimal);
        BigDecimal gross = net.add(vat);

        return CalculatorResponse.builder()
                .vat(vat)
                .net(net)
                .gross(gross)
                .build();
    }

    private CalculatorResponse calculateFromGross(final BigDecimal gross, final Integer vatRate) {
        BigDecimal vatRateDecimal = new BigDecimal(vatRate).divide(HUNDRED_PERCENT, 2, RoundingMode.UNNECESSARY);
        BigDecimal net = gross.divide(vatRateDecimal.add(BigDecimal.ONE), RoundingMode.HALF_UP);
        BigDecimal vat = gross.subtract(net);

        return CalculatorResponse.builder()
                .vat(vat)
                .net(net)
                .gross(gross)
                .build();
    }
}
