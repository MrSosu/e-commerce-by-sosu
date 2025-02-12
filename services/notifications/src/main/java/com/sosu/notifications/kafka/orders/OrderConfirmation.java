package com.sosu.notifications.kafka.orders;

import com.sosu.notifications.kafka.payment.PaymentMethod;
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
