package com.github.witermendonca.citiesapi.service;

import com.github.witermendonca.citiesapi.entity.Country;
import com.github.witermendonca.citiesapi.exception.CountryNotFoundException;
import com.github.witermendonca.citiesapi.repository.CountryRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public List<Country> listAll() {
        return countryRepository.findAll();
    }

    public Page<Country> listAllPage(Pageable page) {
        return countryRepository.findAll(page);
    }


    /** Find By Id Method */
    public Country findById(Long id) throws CountryNotFoundException {

        Optional<Country> country = countryRepository.findById(id);

        if (country.isPresent()) {
            return country.get();
        }
        throw new CountryNotFoundException(id);
    }
}
