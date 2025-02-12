package com.sosu.ordini.controllers;

import com.sosu.ordini.domain.dto.response.CarrelloIdResponse;
import com.sosu.ordini.services.CarrelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/carrello")
public class CarrelloController {

    @Autowired
    private CarrelloService carrelloService;

    // endpoint da esporre
    // 1) getById
    @GetMapping("/get/{id}")
    public ResponseEntity<CarrelloIdResponse> getCarrelloById(@PathVariable Long id) {
        return new ResponseEntity<>(carrelloService.getCarrelloById(id), HttpStatus.OK);
    }
    // 2) getAll
    // 3) get carrello by utente id
    // 4) create
    // 5) add ordine
    // 6) delete ordine
    // 7) delete carrello


}
