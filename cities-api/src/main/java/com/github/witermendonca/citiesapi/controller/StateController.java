package com.github.witermendonca.citiesapi.controller;

import com.github.witermendonca.citiesapi.entity.State;
import com.github.witermendonca.citiesapi.service.StateService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/states")
@RequiredArgsConstructor
public class StateController {

    private final StateService stateService;

    @GetMapping
    public List<State> listAll() {
        return stateService.listAll();
    }
}
