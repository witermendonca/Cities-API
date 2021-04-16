package com.github.witermendonca.citiesapi.controller;

import com.github.witermendonca.citiesapi.entity.Country;
import com.github.witermendonca.citiesapi.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    //returns a list of countries
    @GetMapping
    public List<Country> listAll(){
        return countryService.listAll();
    }

    //returns a page of countries
    @GetMapping("/pages")
    public Page<Country> getAll(Pageable page) {
        return countryService.listAllPage(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable Long id){
        return countryService.findById(id);
    }

}
