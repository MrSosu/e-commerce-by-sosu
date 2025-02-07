package com.sosu.ordini.mappers;

import com.sosu.ordini.domain.dto.request.OrdineRequest;
import com.sosu.ordini.domain.dto.response.OrdineResponse;
import com.sosu.ordini.domain.entities.Ordine;
import com.sosu.ordini.services.CarrelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdineMapper {

    @Autowired
    private CarrelloService carrelloService;

    public OrdineResponse toResponse(Ordine ordine) {
        return OrdineResponse
                .builder()
                .id(ordine.getId())
                .idProdotto(ordine.getIdProdotto())
                .paymentMethod(ordine.getPaymentMethod())
                .quantity(ordine.getQuantity())
                .idCarrello(ordine.getCarrello().getId())
                .build();
    }

    public Ordine toEntity(OrdineRequest request) {
        return Ordine
                .builder()
                .idProdotto(request.idProdotto())
                .quantity(request.quantity())
                .paymentMethod(request.paymentMethod())
                .carrello(carrelloService.getCarrelloById(request.idCarrello()))
                .build();
    }

}
