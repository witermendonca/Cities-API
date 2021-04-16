package com.github.witermendonca.citiesapi.repository;

import com.github.witermendonca.citiesapi.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
