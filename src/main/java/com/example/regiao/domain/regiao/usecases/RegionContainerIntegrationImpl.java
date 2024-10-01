package com.example.regiao.domain.regiao.usecases;

import com.example.regiao.domain.regiao.converters.RegionContainerConverter;
import com.example.regiao.domain.regiao.models.RegionContainerModel;
import com.example.regiao.domain.regiao.ports.RegionContainerPort;
import com.example.regiao.infraestructure.api.v1.exceptions.RegionNotFoundException;
import com.example.regiao.infraestructure.api.v1.exceptions.UfFormatInvalidException;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.net.URISyntaxException;

@Component
@RequiredArgsConstructor
public class RegionContainerIntegrationImpl implements RegionContainerIntegration{

    private final RegionContainerPort port;

    @Override
    public RegionContainerModel findRegionContainerByUf(final String uf) throws URISyntaxException, JsonProcessingException, UfFormatInvalidException, RegionNotFoundException {
        isUfFormatValid(uf);
        return port.findRegionContainerByUf(uf);
    }

    private void isUfFormatValid(final String uf) throws UfFormatInvalidException{
        if(uf.length() != 2 || uf.matches(".*\\d.*")){
            throw new UfFormatInvalidException(HttpStatus.BAD_REQUEST,
                    "The UF is in a invalid format, please correct it and try again");
        }
    }
}
