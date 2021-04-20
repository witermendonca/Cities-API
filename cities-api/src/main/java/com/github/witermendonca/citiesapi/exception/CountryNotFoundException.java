package com.github.witermendonca.citiesapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CountryNotFoundException extends Exception {

    public CountryNotFoundException(Long id) {
        super ("Country not found with ID " + id );
    }
}
