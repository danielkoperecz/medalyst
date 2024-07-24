package io.sevendiko.medalyst.model;

import lombok.Builder;

@Builder
public record ErrorResponse(
        Integer errorCode,
        String errorDescription
) {}
