package com.example.regiao.infraestructure.api.v1.controllers;

import com.example.regiao.domain.regiao.usecases.RegionContainerIntegration;
import com.example.regiao.infraestructure.api.v1.exceptions.RegionNotFoundException;
import com.example.regiao.infraestructure.api.v1.exceptions.UfFormatInvalidException;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequestMapping("api/v1/region")
@CrossOrigin(origins = "http://localhost:8083/*")
@RequiredArgsConstructor
public class RegionContainerController {

    private final RegionContainerIntegration integration;

    @GetMapping("/{uf}")
    public ResponseEntity<Object> getRegionByUf(@PathVariable("uf") @Valid final String uf) throws URISyntaxException, JsonProcessingException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(integration.findRegionContainerByUf(uf));
    }
}
