package com.sosu.commerce.user.services;

import com.sosu.commerce.user.dto.request.IndirizzoRequest;
import com.sosu.commerce.user.dto.request.UtenteRequest;
import com.sosu.commerce.user.dto.request.UtenteUpdateRequest;
import com.sosu.commerce.user.dto.response.EntityIdResponse;
import com.sosu.commerce.user.dto.response.GenericResponse;
import com.sosu.commerce.user.dto.response.UtenteResponse;
import com.sosu.commerce.user.entities.Indirizzo;
import com.sosu.commerce.user.entities.Utente;
import com.sosu.commerce.user.exceptions.UtenteNotFoundException;
import com.sosu.commerce.user.mappers.IndirizzoMapper;
import com.sosu.commerce.user.mappers.UtenteMapper;
import com.sosu.commerce.user.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private UtenteMapper utenteMapper;
    @Autowired
    private IndirizzoService indirizzoService;
    @Autowired
    private IndirizzoMapper indirizzoMapper;

    public UtenteResponse getUtenteById(Long id) {
        Utente utente = utenteRepository
                .findById(id)
                .orElseThrow(() -> new UtenteNotFoundException(String.format("L'utente con id %d non esiste", id)));
        return utenteMapper.toResponse(utente);
    }

    public List<UtenteResponse> getAll() {
        return utenteRepository
                .findAll()
                .stream()
                .map(utenteMapper::toResponse)
                .toList();
    }


    public EntityIdResponse createUtente(UtenteRequest request) {
        Utente utente = utenteRepository.save(utenteMapper.toEntity(request));
        return EntityIdResponse.builder().id(utente.getId()).build();
    }

    public EntityIdResponse updateUtente(Long id, UtenteUpdateRequest request) {
        Utente utente = utenteRepository
                .findById(id)
                .orElseThrow(() -> new UtenteNotFoundException(String.format("L'utente con id %d non esiste", id)));
        if (request.nome() != null) utente.setNome(request.nome());
        if (request.cognome()!= null) utente.setCognome(request.cognome());
        if (request.dataNascita() != null) utente.setDataNascita(request.dataNascita());
        if (request.email() != null) utente.setEmail(request.email());
        return EntityIdResponse.builder().id(utente.getId()).build();
    }

    public GenericResponse deleteUtenteById(Long id) {
        utenteRepository.deleteById(id);
        return GenericResponse
                .builder()
                .message(String.format("Utente con id %d cancellato con successo", id))
                .build();
    }

    public EntityIdResponse addIndirizzo(Long id, IndirizzoRequest request) {
        Utente utente = utenteRepository
                .findById(id)
                .orElseThrow(() -> new UtenteNotFoundException(String.format("L'utente con id %d non esiste", id)));
        Indirizzo indirizzo = indirizzoMapper.toEntity(request);
        indirizzo.setUtente(utente);
        return indirizzoService.createIndirizzo(indirizzo);
    }
}
