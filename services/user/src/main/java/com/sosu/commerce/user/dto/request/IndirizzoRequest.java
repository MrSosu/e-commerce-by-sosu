package com.sosu.commerce.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record IndirizzoRequest(
        @NotBlank
        String via,
        @NotBlank
        String civico,
        @NotBlank
        String cap,
        @NotNull
        Long comuneId
) {
}
