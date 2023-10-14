package com.example.urlshortener.exceptions;

import org.springframework.http.HttpStatus;

public class LinkNotFoundException extends UrlShortenerException {

    public LinkNotFoundException() {
        this("Link not found");
    }

    public LinkNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
