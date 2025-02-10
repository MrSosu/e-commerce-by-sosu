package com.sosu.ordini.services;

import com.sosu.ordini.domain.dto.request.ProdottoPurchaseRequest;
import com.sosu.ordini.domain.dto.response.OrdineIdResponse;
import com.sosu.ordini.domain.dto.request.OrdineRequest;
import com.sosu.ordini.domain.dto.response.OrdineResponse;
import com.sosu.ordini.domain.dto.request.OrdineUpdateRequest;
import com.sosu.ordini.domain.entities.Ordine;
import com.sosu.ordini.exceptions.OrdineNotFoundException;
import com.sosu.ordini.kafka.OrderConfirmation;
import com.sosu.ordini.kafka.OrderProducer;
import com.sosu.ordini.mappers.OrdineMapper;
import com.sosu.ordini.repositories.OrdineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdineService {

    @Autowired
    private OrdineRepository ordineRepository;
    @Autowired
    private OrdineMapper ordineMapper;
    @Autowired
    private UtenteClient utenteClient;
    @Autowired
    private ProdottoClient prodottoClient;
    @Autowired
    private OrderProducer orderProducer;

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
        var utente = utenteClient.getUtenteById(request.idUtente());
        // 2) chiamo il metodo purchaseProducts per aggiornare il database dei prodotti
        List<ProdottoPurchaseRequest> requests = new ArrayList<>();
        requests.add(
                ProdottoPurchaseRequest
                        .builder()
                        .id_prodotto(request.idProdotto())
                        .quantita(request.quantity())
                        .build()
        );
        var purchasedProducts = prodottoClient.purchaseProdotti(requests).getFirst();
        // 3) creo effettivamente l'ordine e lo salvo
        var ordine = ordineRepository.save(ordineMapper.toEntity(request));
        // TODO 4) notificare il servizio di pagamento
        orderProducer.sendConfermaOrdine(OrderConfirmation
                .builder()
                .id(ordine.getId())
                .paymentMethod(ordine.getPaymentMethod())
                .quantity(ordine.getQuantity())
                .idProdotto(ordine.getIdProdotto())
                .timestamp(LocalDateTime.now())
                .build());
        return OrdineIdResponse.builder().idOrdine(ordine.getId()).build();
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
