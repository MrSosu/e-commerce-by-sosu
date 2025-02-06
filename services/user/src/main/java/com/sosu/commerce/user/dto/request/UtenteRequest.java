package com.sosu.commerce.user.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UtenteRequest(
        @NotBlank(message = "Il nome non può essere blank")
        @Size(max = 30, message = "La lunghezza massima di un nome è 30 caratteri")
        String nome,
        @NotBlank
        @Size(max = 30, message = "La lunghezza massima di un cognome è 30 caratteri")
        String cognome,
        @NotNull(message = "La data di nascita non può essere null")
        @Past(message = "La data di nascita non può essere nel futuro")
        LocalDate dataNascita,
        @NotNull
        @Email(message = "Formato non valido")
        String email
) {
}
