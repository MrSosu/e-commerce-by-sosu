package com.sosu.commerce.user.services;

import com.sosu.commerce.user.dto.request.IndirizzoRequest;
import com.sosu.commerce.user.dto.response.EntityIdResponse;
import com.sosu.commerce.user.entities.Indirizzo;
import com.sosu.commerce.user.exceptions.IndirizzoNotFoundException;
import com.sosu.commerce.user.mappers.IndirizzoMapper;
import com.sosu.commerce.user.repositories.IndirizzoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndirizzoService {

    @Autowired
    private IndirizzoRepository indirizzoRepository;
    @Autowired
    private IndirizzoMapper indirizzoMapper;

    public Indirizzo getIndirizzoById(Long id) {
        return indirizzoRepository
                .findById(id)
                .orElseThrow(() -> new IndirizzoNotFoundException(String.format("L'indirizzo con id %d non esiste", id)));
    }

    public EntityIdResponse createIndirizzo(Indirizzo request) {
        Indirizzo indirizzo = indirizzoRepository.save(request);
        return EntityIdResponse.builder().id(indirizzo.getId()).build();
    }

}
