package com.example.urlshortener.services;

import com.example.urlshortener.data.models.Link;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LinkService {

    String shorten(String longUrl);

    String getLongUrl(String shortUrl);

    void deleteShortUrl(String shortUrl);

    Page<Link> getAllLinks(Pageable pageable);

}
