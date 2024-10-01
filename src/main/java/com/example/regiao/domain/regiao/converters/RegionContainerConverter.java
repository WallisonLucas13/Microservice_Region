package com.example.regiao.domain.regiao.converters;

import com.example.regiao.domain.regiao.inputs.RegionContainerInput;
import com.example.regiao.domain.regiao.models.RegionContainerModel;

public class RegionContainerConverter {

    public static RegionContainerModel inputToModel(RegionContainerInput input){
        return RegionContainerModel.builder()
                .nome(input.getNome())
                .sigla(input.getSigla())
                .region(input.getRegion())
                .build();
    }
}
