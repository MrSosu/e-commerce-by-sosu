package com.sosu.commerce.user.mappers;

import com.sosu.commerce.user.dto.request.IndirizzoRequest;
import com.sosu.commerce.user.entities.Indirizzo;
import com.sosu.commerce.user.services.ComuneService;
import com.sosu.commerce.user.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndirizzoMapper {

    @Autowired
    private ComuneService comuneService;

    public Indirizzo toEntity(IndirizzoRequest request) {
        return Indirizzo
                .builder()
                .via(request.via())
                .civico(request.civico())
                .cap(request.cap())
                .comune(comuneService.getComuneById(request.comuneId()))
                .build();
    }

}
