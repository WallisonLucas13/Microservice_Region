package com.example.regiao.domain.regiao.inputs;

import com.example.regiao.domain.regiao.models.RegionContainerModel;
import com.example.regiao.domain.regiao.models.RegionModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegionContainerInput {
    private String sigla;
    private String nome;
    @JsonProperty("regiao")
    private RegionModel region;
}
