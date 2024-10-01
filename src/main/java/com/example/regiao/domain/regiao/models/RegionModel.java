package com.example.regiao.domain.regiao.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegionModel {

    private String sigla;
    private String nome;
}
