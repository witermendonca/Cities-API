package com.github.witermendonca.citiesapi.service;

import com.github.witermendonca.citiesapi.entity.Country;
import com.github.witermendonca.citiesapi.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public List<Country> listAll(){
        return countryRepository.findAll();
    }

    public Page<Country> listAllPage(Pageable page) {
        return countryRepository.findAll(page);
    }

    public ResponseEntity <Country> findById(Long id) {
        Optional<Country> country = countryRepository.findById(id);

        if(country.isPresent()) {
            return ResponseEntity.ok().body(country.get());
        }
        return ResponseEntity.notFound().build();
    }
}
