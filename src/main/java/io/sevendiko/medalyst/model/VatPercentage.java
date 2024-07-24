package io.sevendiko.medalyst.model;

import lombok.Getter;

@Getter
public enum VatPercentage {
    TEN_PERCENTAGE(10),
    THIRTEEN_PERCENTAGE(13),
    TWENTY_PERCENTAGE(20);

    private final int value;

    VatPercentage(int value) {
        this.value = value;
    }

    public static VatPercentage fromValue(int value) {
        for (VatPercentage percentage : VatPercentage.values()) {
            if (percentage.value == value) {
                return percentage;
            }
        }
        throw new IllegalArgumentException("Unknown percentage value: " + value);
    }
}
