package com.sosu.ordini.domain.dto.request;

import com.sosu.ordini.domain.enums.PaymentMethod;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrdineRequest(
        @NotNull
        Long idProdotto,
        @NotNull
        @Positive
        Integer quantity,
        @NotNull
        PaymentMethod paymentMethod,
        @NotNull
        Long idCarrello,
        @NotNull
        Long idUtente
) {
}
