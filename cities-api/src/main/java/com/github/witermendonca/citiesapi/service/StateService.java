package com.github.witermendonca.citiesapi.service;

import com.github.witermendonca.citiesapi.entity.State;
import com.github.witermendonca.citiesapi.repository.StateRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class StateService {

    private final StateRepository stateRepository;

    public List<State> listAll() {
        return stateRepository.findAll();
    }
}
