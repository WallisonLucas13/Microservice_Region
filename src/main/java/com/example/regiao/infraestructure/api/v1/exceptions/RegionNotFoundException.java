package com.example.regiao.infraestructure.api.v1.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RegionNotFoundException extends RuntimeException{

    private final HttpStatus httpStatus;

    public RegionNotFoundException(final HttpStatus httpStatus,
                                    final String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
