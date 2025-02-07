package com.sosu.ordini.services;

import com.sosu.ordini.domain.dto.response.UtenteResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.text.html.parser.Entity;

@FeignClient(name = "user-service", url = "${application.config.user-url}")
public interface UtenteClient {

    @GetMapping("/get/{id}")
    UtenteResponse getUtenteById(@PathVariable Long id);

}
