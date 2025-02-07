package com.sosu.ordini.controllers;

import com.sosu.ordini.domain.dto.response.OrdineIdResponse;
import com.sosu.ordini.domain.dto.request.OrdineRequest;
import com.sosu.ordini.domain.dto.response.OrdineResponse;
import com.sosu.ordini.domain.dto.request.OrdineUpdateRequest;
import com.sosu.ordini.services.OrdineService;
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
@RequestMapping("/api/v1/ordini")
public class OrdineController {

    @Autowired
    private OrdineService ordineService;

    @GetMapping("/get/{id}")
    public ResponseEntity<OrdineResponse> getOrdineById(@PathVariable Long id) {
        return new ResponseEntity<>(ordineService.getOrdineById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrdineResponse>> getAll() {
        return new ResponseEntity<>(ordineService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<OrdineIdResponse> createOrdine(@RequestBody OrdineRequest request) {
        return new ResponseEntity<>(ordineService.createOrdine(request), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OrdineIdResponse> updateOrdine(@PathVariable Long id, @RequestBody OrdineUpdateRequest request) {
        return new ResponseEntity<>(ordineService.updateOrdine(id, request), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<OrdineIdResponse> deleteOrdine(@PathVariable Long id) {
        return new ResponseEntity<>(ordineService.deleteOrdineById(id), HttpStatus.OK);
    }

    @GetMapping("/get_by_carrello/{id_carrello}")
    public ResponseEntity<List<OrdineResponse>> getByCarrelloId(@PathVariable Long idCarrello) {
        return new ResponseEntity<>(ordineService.getByCarrelloId(idCarrello), HttpStatus.OK);
    }

}
