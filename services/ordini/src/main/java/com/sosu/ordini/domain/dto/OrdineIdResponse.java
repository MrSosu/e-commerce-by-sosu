package com.sosu.ordini.domain.dto;

import lombok.Builder;

@Builder
public record OrdineIdResponse(
        Long idOrdine
) {
}
