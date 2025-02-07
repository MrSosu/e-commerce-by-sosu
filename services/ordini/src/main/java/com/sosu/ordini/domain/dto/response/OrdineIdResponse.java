package com.sosu.ordini.domain.dto.response;

import lombok.Builder;

@Builder
public record OrdineIdResponse(
        Long idOrdine
) {
}
