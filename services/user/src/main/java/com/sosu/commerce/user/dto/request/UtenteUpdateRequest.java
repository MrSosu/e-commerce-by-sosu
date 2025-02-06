package com.sosu.commerce.user.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record UtenteUpdateRequest(
        @Size(max = 30, message = "La lunghezza massima di un nome è 30 caratteri")
        String nome,
        @Size(max = 30, message = "La lunghezza massima di un cognome è 30 caratteri")
        String cognome,
        @Past(message = "La data di nascita non può essere nel futuro")
        LocalDate dataNascita,
        @Email(message = "Formato non valido")
        String email
) {
}
