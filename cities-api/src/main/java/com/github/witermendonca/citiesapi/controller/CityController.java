package com.github.witermendonca.citiesapi.controller;

import com.github.witermendonca.citiesapi.entity.City;
import com.github.witermendonca.citiesapi.exception.CityNotFoundException;
import com.github.witermendonca.citiesapi.service.CityService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping
    public List<City> listAll() {
        return cityService.listAll();
    }

    @GetMapping("/pages")
    public Page<City> cities(Pageable page) {
        return cityService.listAllPage(page);
    }

    /** Get distance from city 1 to city 2 in miles */
    @GetMapping("/by-points")
    public Double byPoints(@RequestParam(name = "from") final Long city1,
                           @RequestParam(name = "to") final Long city2) throws CityNotFoundException {

        //Ex: /cities/by-points?from=4929&to=5254
        return cityService.distanceByPointsInMiles(city1, city2);
    }

    /** Get distance from city 1 to city 2 in meters */
    @GetMapping("/by-cube")
    public Double byCube(@RequestParam(name = "from") final Long city1,
                         @RequestParam(name = "to") final Long city2) throws CityNotFoundException {

        //Ex: /cities/by-cube?from=4929&to=5254
        return cityService.distanceByCubeInMeters(city1, city2);
    }

}
