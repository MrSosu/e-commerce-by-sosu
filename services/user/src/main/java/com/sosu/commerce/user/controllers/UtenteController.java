package com.sosu.commerce.user.controllers;

import com.sosu.commerce.user.dto.request.IndirizzoRequest;
import com.sosu.commerce.user.dto.request.UtenteRequest;
import com.sosu.commerce.user.dto.request.UtenteUpdateRequest;
import com.sosu.commerce.user.dto.response.EntityIdResponse;
import com.sosu.commerce.user.dto.response.GenericResponse;
import com.sosu.commerce.user.dto.response.UtenteResponse;
import com.sosu.commerce.user.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/utenti")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @GetMapping("/get/{id}")
    public ResponseEntity<UtenteResponse> getUtenteById(@PathVariable Long id) {
        return new ResponseEntity<>(utenteService.getUtenteById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UtenteResponse>> getAll() {
        return new ResponseEntity<>(utenteService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<EntityIdResponse> createUtente(@RequestBody UtenteRequest request) {
        return new ResponseEntity<>(utenteService.createUtente(request), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EntityIdResponse> updateUtente(@PathVariable Long id, @RequestBody UtenteUpdateRequest request) {
        return new ResponseEntity<>(utenteService.updateUtente(id, request), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GenericResponse> deleteUtenteById(@PathVariable Long id) {
        return new ResponseEntity<>(utenteService.deleteUtenteById(id), HttpStatus.OK);
    }

    @PostMapping("/add_indirizzo/{id}")
    public ResponseEntity<EntityIdResponse> addIndirizzo(@PathVariable Long id, @RequestBody IndirizzoRequest request) {
        return new ResponseEntity<>(utenteService.addIndirizzo(id, request), HttpStatus.CREATED);
    }

}
