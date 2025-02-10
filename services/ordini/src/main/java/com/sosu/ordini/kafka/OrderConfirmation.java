package com.sosu.ordini.kafka;

import com.sosu.ordini.domain.enums.PaymentMethod;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record OrderConfirmation(
        Long id,
        Long idProdotto,
        Integer quantity,
        PaymentMethod paymentMethod,
        LocalDateTime timestamp
) {
}
