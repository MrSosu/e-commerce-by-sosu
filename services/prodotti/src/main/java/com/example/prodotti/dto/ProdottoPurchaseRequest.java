package com.example.prodotti.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Builder
public record ProdottoPurchaseRequest(
        @NotNull(message = "l'id del prodotto non può essere null")
        Long id_prodotto,
        @NotNull(message = "la quantità non può essere null")
        @Positive
        Integer quantita
) {

}
