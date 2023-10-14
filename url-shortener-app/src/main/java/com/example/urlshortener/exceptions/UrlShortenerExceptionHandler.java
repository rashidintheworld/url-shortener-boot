package com.example.urlshortener.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UrlShortenerExceptionHandler {

    @ExceptionHandler(UrlShortenerException.class)
    public ResponseEntity<ExceptionResponse> exceptionHandler(UrlShortenerException e){
        ExceptionResponse res = ExceptionResponse.builder()
                .message(e.getMessage())
                .status(e.getStatus())
                .build();
        return new ResponseEntity<>(res, e.getStatus());
    }
}
