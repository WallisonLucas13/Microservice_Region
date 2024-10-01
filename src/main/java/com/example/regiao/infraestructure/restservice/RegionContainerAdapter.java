package com.example.regiao.infraestructure.restservice;

import com.example.regiao.domain.regiao.converters.RegionContainerConverter;
import com.example.regiao.domain.regiao.inputs.RegionContainerInput;
import com.example.regiao.domain.regiao.models.RegionContainerModel;
import com.example.regiao.domain.regiao.ports.RegionContainerPort;
import com.example.regiao.infraestructure.api.v1.exceptions.RegionNotFoundException;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@Component
public class RegionContainerAdapter extends RestClientAdapter implements RegionContainerPort{

    private final String REGION_IBGE_URL;

    public RegionContainerAdapter(@Value("${api.regionIbge.url}") final String REGION_IBGE_URL_URL,
                                  final RestClient restClient){
        super(restClient);
        this.REGION_IBGE_URL = REGION_IBGE_URL_URL;
    }

    @Override
    public RegionContainerModel findRegionContainerByUf(@NotBlank final String uf) throws URISyntaxException {
        var uri = new URI(String.format("%s%s", this.REGION_IBGE_URL, uf));
        try {
            return RegionContainerConverter
                    .inputToModel(this.get(uri, RegionContainerInput.class));
        } catch(RestClientException e){
            throw new RegionNotFoundException(HttpStatus.NOT_FOUND,
                    "Region not found!");
        }
    }

}
