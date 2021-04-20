package com.github.witermendonca.citiesapi.service;

import com.github.witermendonca.citiesapi.entity.City;
import com.github.witermendonca.citiesapi.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.geo.Point;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    Logger log = LoggerFactory.getLogger(CityService.class);

    public List<City> listAll(){
        return cityRepository.findAll();
    }

    public Page<City> listAllPage(Pageable page) {
        return cityRepository.findAll(page);
    }


}
