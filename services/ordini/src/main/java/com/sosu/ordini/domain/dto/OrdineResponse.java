package com.sosu.ordini.domain.dto;

import com.sosu.ordini.domain.enums.PaymentMethod;
import lombok.Builder;

@Builder
public record OrdineResponse(
    Long id,
    Long idProdotto,
    Integer quantity,
    PaymentMethod paymentMethod,
    Long idCarrello
) {
}
