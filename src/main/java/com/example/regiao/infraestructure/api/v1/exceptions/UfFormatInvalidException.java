package com.example.regiao.infraestructure.api.v1.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UfFormatInvalidException extends RuntimeException{

    private final HttpStatus httpStatus;

    public UfFormatInvalidException(final HttpStatus httpStatus,
                                    final String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
