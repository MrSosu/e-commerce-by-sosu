package com.sosu.ordini.services;

import com.sosu.ordini.domain.dto.OrdineIdResponse;
import com.sosu.ordini.domain.dto.OrdineRequest;
import com.sosu.ordini.domain.dto.OrdineResponse;
import com.sosu.ordini.domain.dto.OrdineUpdateRequest;
import com.sosu.ordini.domain.entities.Ordine;
import com.sosu.ordini.exceptions.OrdineNotFoundException;
import com.sosu.ordini.mappers.OrdineMapper;
import com.sosu.ordini.repositories.OrdineRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrdineService {

    @Autowired
    private OrdineRepository ordineRepository;
    @Autowired
    private OrdineMapper ordineMapper;

    public OrdineResponse getOrdineById(Long id) {
        Ordine ordine = ordineRepository
                .findById(id)
                .orElseThrow(() -> new OrdineNotFoundException(String.format("L'ordine con id %d non esiste", id)));
        return ordineMapper.toResponse(ordine);
    }

    public List<OrdineResponse> getAll() {
        return ordineRepository
                .findAll()
                .stream()
                .map(ordineMapper::toResponse)
                .toList();
    }


    public OrdineIdResponse createOrdine(OrdineRequest request) {
        // 1) verifico se l'utente esiste

        // 2) chiamo il metodo purchaseProducts per aggiornare il database dei prodotti

        // 3) creo effettivamente l'ordine e lo salvo

        // 4) notificare il servizio di pagamento
        return null;
    }


    public OrdineIdResponse updateOrdine(Long id, OrdineUpdateRequest request) {
        Ordine ordine = ordineRepository
                .findById(id)
                .orElseThrow(() -> new OrdineNotFoundException(String.format("L'ordine con id %d non esiste", id)));
        if (request.quantity() != null) ordine.setQuantity(request.quantity());
        if (request.paymentMethod() != null) ordine.setPaymentMethod(request.paymentMethod());
        ordineRepository.save(ordine);
        return OrdineIdResponse.builder().idOrdine(ordine.getId()).build();
    }

    public OrdineIdResponse deleteOrdineById(Long id) {
        ordineRepository.deleteById(id);
        return OrdineIdResponse.builder().idOrdine(id).build();
    }

    public List<OrdineResponse> getByCarrelloId(Long idCarrello) {
        return ordineRepository
                .findByCarrello_Id(idCarrello)
                .stream()
                .map(ordineMapper::toResponse)
                .toList();
    }
}
