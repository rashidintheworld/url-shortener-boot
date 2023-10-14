package com.example.urlshortener.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class UrlShortenerException extends RuntimeException{

    @Getter
    private HttpStatus status;

    public UrlShortenerException(){
        super();
        this.status = HttpStatus.BAD_REQUEST;
    }

    public UrlShortenerException(String message){
        super(message);
        this.status = HttpStatus.BAD_REQUEST;
    }

    public UrlShortenerException(HttpStatus status, String message){
        super(message);
        this.status = status;
    }
}
