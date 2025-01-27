package com.br.emakers.apiProjeto.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Date;

public record RestErrorMessage(
        HttpStatus status,
        String message,
        Date timestamp
) {
    public RestErrorMessage(HttpStatus status, String message) {
        this(status, message, new Date());
    }
}