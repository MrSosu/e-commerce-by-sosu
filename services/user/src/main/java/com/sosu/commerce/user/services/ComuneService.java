package com.sosu.commerce.user.services;

import com.sosu.commerce.user.entities.Comune;
import com.sosu.commerce.user.exceptions.ComuneNotFoundException;
import com.sosu.commerce.user.repositories.ComuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComuneService {

    @Autowired
    private ComuneRepository comuneRepository;

    public Comune getComuneById(Long id) {
        return comuneRepository
                .findById(id)
                .orElseThrow(() -> new ComuneNotFoundException(String.format("Comune con id %d non trovato!", id)));
    }

}
