package com.github.witermendonca.citiesapi.repository;

import com.github.witermendonca.citiesapi.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
