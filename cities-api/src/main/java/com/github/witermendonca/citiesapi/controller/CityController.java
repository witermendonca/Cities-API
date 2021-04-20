package com.github.witermendonca.citiesapi.controller;

import com.github.witermendonca.citiesapi.entity.City;
import com.github.witermendonca.citiesapi.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping
    public List<City> listAll(){
        return cityService.listAll();
    }

    @GetMapping("/pages")
    public Page<City> cities(Pageable page) {
        return cityService.listAllPage(page);
    }


}
