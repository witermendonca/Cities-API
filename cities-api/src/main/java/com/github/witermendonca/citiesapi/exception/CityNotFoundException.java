package com.github.witermendonca.citiesapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CityNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public CityNotFoundException(Long id) {
        super("City not found with ID " + id);
    }
}
