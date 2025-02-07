package com.example.prodotti.dto;

import lombok.*;

@Builder
public record ProdottoPurchaseResponse(
        Long id_prodotto,
        String nome,
        Integer quantita
) {



}
