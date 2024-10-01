package com.example.regiao.domain.regiao.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegionContainerModel {

    private String sigla;
    private String nome;
    @JsonProperty("regiao")
    private RegionModel region;
}
