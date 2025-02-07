package com.sosu.ordini.services;

import com.sosu.ordini.domain.dto.request.ProdottoPurchaseRequest;
import com.sosu.ordini.domain.dto.response.ProdottoPurchaseResponse;
import com.sosu.ordini.exceptions.PurchaseProductsFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProdottoClient {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${application.config.prodotti-url}")
    private String prodottiUrl;

    public List<ProdottoPurchaseResponse> purchaseProdotti(@RequestBody List<ProdottoPurchaseRequest> requests) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE); // imposto come json il contenuto del body
        HttpEntity<List<ProdottoPurchaseRequest>> requestEntity = new HttpEntity<>(requests, headers); // definisco l'entità nel body
        // definisco il tipo di risposta dell'API
        ParameterizedTypeReference<List<ProdottoPurchaseResponse>> responseType =
                new ParameterizedTypeReference<>() {};
        ResponseEntity<List<ProdottoPurchaseResponse>> responseEntity = restTemplate.exchange
                        (prodottiUrl + "/purchase",
                        HttpMethod.POST, requestEntity, responseType);
        if (responseEntity.getStatusCode().isError()) throw new PurchaseProductsFailedException("Qualcosa è andato storto " +
                "nel purchase dei prodotti");
        return responseEntity.getBody();

    }

}
