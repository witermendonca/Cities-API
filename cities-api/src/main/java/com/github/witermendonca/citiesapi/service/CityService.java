package com.github.witermendonca.citiesapi.service;

import com.github.witermendonca.citiesapi.entity.City;
import com.github.witermendonca.citiesapi.exception.CityNotFoundException;
import com.github.witermendonca.citiesapi.repository.CityRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    Logger log = LoggerFactory.getLogger(CityService.class);

    public List<City> listAll() {
        return cityRepository.findAll();
    }

    public Page<City> listAllPage(Pageable page) {
        return cityRepository.findAll(page);
    }

    /** Distance By Points in Miles Method */
    public Double distanceByPointsInMiles(final Long city1, final Long city2) throws CityNotFoundException {

        City foundCity1 = verifyIfIdExists(city1);
        City foundCity2 = verifyIfIdExists(city2);

        return cityRepository.distanceByPoints(foundCity1.getId(), foundCity2.getId());

    }

    /** Distance By Cube in Meters Method */
    public Double distanceByCubeInMeters(Long city1, Long city2) throws CityNotFoundException {

        City foundCity1 = verifyIfIdExists(city1);
        City foundCity2 = verifyIfIdExists(city2);

        return  cityRepository.distanceByCube(foundCity1.getLatitude(), foundCity1.getLongitude(),
                    foundCity2.getLatitude(), foundCity2.getLongitude());

    }

    private City verifyIfIdExists(Long id) throws CityNotFoundException {
        return cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException(id));
    }


}
