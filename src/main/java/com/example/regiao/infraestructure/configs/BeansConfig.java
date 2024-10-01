package com.example.regiao.infraestructure.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;

@Configuration
public class BeansConfig {

    @Bean
    public RestClient restClient(){
        return RestClient.create();
    }
}
