package com.sosu.ordini.domain.dto;

import com.sosu.ordini.domain.enums.PaymentMethod;
import jakarta.validation.constraints.Positive;

public record OrdineUpdateRequest(
        @Positive
        Integer quantity,
        PaymentMethod paymentMethod
) {
}
