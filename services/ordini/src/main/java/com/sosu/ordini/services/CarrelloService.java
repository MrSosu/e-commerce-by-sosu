package com.sosu.ordini.services;

import com.sosu.ordini.domain.entities.Carrello;
import com.sosu.ordini.exceptions.CarrelloNotFoundException;
import com.sosu.ordini.repositories.CarrelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrelloService {

    @Autowired
    private CarrelloRepository carrelloRepository;

    public Carrello getCarrelloById(Long id) {
        return carrelloRepository
                .findById(id)
                .orElseThrow(() -> new CarrelloNotFoundException(String.format("Il carrello con id %d non esiste")));
    }

}
