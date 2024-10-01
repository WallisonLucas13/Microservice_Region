package com.example.regiao.infraestructure.api.v1.handler;

import com.example.regiao.infraestructure.api.v1.exceptions.RegionNotFoundException;
import com.example.regiao.infraestructure.api.v1.exceptions.UfFormatInvalidException;
import com.example.regiao.infraestructure.api.v1.responses.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomizedExceptionHandler {

    @ExceptionHandler(RegionNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerRegionNotFound(final RegionNotFoundException ex,
                                                                final HttpServletRequest request) {
        final ErrorResponse errorResponse = buildErrorResponse(ex.getHttpStatus(), ex.getMessage(), request);
        return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
    }
    @ExceptionHandler(UfFormatInvalidException.class)
    public ResponseEntity<ErrorResponse> handlerUfFormatInvalid(final UfFormatInvalidException ex,
                                                                final HttpServletRequest request) {
        final ErrorResponse errorResponse = buildErrorResponse(ex.getHttpStatus(), ex.getMessage(), request);
        return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
    }

    private ErrorResponse buildErrorResponse(final HttpStatus httpStatus,
                                             final String message,
                                             final HttpServletRequest request){
        return new ErrorResponse(
                httpStatus.getReasonPhrase(),
                message,
                request.getServletPath()
        );
    }
}
