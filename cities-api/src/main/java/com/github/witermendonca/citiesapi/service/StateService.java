package com.github.witermendonca.citiesapi.service;

import com.github.witermendonca.citiesapi.entity.State;
import com.github.witermendonca.citiesapi.repository.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StateService {

    private final StateRepository stateRepository;

    public List<State> listAll(){
        return stateRepository.findAll();
    }
}
