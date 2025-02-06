package com.sosu.commerce.user.mappers;

import com.sosu.commerce.user.dto.request.UtenteRequest;
import com.sosu.commerce.user.dto.response.UtenteResponse;
import com.sosu.commerce.user.entities.Indirizzo;
import com.sosu.commerce.user.entities.Utente;
import com.sosu.commerce.user.services.IndirizzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteMapper {

    public UtenteResponse toResponse(Utente utente) {
        return UtenteResponse
                .builder()
                .id(utente.getId())
                .nome(utente.getNome())
                .cognome(utente.getCognome())
                .email(utente.getEmail())
                .dataNascita(utente.getDataNascita())
                .indirizziId(utente.getIndirizzi()
                        .stream()
                        .map(Indirizzo::getId).toList())
                .build();
    }

    public Utente toEntity(UtenteRequest request) {
        return Utente
                .builder()
                .nome(request.nome())
                .cognome(request.cognome())
                .dataNascita(request.dataNascita())
                .email(request.email())
                .build();
    }

}
