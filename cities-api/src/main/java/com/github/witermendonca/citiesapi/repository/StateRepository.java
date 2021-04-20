package com.github.witermendonca.citiesapi.repository;

import com.github.witermendonca.citiesapi.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
}
