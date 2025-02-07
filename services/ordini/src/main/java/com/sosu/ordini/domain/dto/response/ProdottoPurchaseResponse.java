package com.sosu.ordini.domain.dto.response;

import lombok.Builder;

@Builder
public record ProdottoPurchaseResponse(
        Long id_prodotto,
        String nome,
        Integer quantita
) {



}
