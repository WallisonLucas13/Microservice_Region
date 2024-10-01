package com.example.regiao.domain.regiao.ports;

import com.example.regiao.domain.regiao.inputs.RegionContainerInput;
import com.example.regiao.domain.regiao.models.RegionContainerModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;

public interface RegionContainerPort {

    RegionContainerModel findRegionContainerByUf(final String uf) throws URISyntaxException;
}
