package com.example.regiao.domain.regiao.usecases;

import com.example.regiao.domain.regiao.models.RegionContainerModel;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.net.URISyntaxException;

public interface RegionContainerIntegration {

    RegionContainerModel findRegionContainerByUf(final String uf) throws URISyntaxException, JsonProcessingException;
}
