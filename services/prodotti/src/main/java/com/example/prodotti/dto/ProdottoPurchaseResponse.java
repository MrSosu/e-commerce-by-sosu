package com.example.prodotti.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Builder
public record ProdottoPurchaseResponse(
        @NotNull
        Long id_prodotto,
        @NotNull
        String nome,
        @NotNull
        @Positive
        Integer quantita
) {



}
