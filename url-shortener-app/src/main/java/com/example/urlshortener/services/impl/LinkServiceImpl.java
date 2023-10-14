package com.example.urlshortener.services.impl;

import com.example.urlshortener.data.models.Link;
import com.example.urlshortener.data.repositories.LinkRepository;
import com.example.urlshortener.exceptions.LinkNotFoundException;
import com.example.urlshortener.services.LinkService;
import com.example.urlshortener.utils.Utils;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LinkServiceImpl implements LinkService {
    private final LinkRepository linkRepository;

    @Override
    public String shorten(String longUrl) {
        Link link = Link.builder()
                .longUrl(longUrl)
                .shortUrl(this.getShortUrl())
                .build();

        Link savedLink = linkRepository.save(link);
        return savedLink.getShortUrl();
    }

    @Override
    public String getLongUrl(String shortUrl) {
        Link link = linkRepository
                .findByShortUrl(shortUrl)
                .orElseThrow(LinkNotFoundException::new);
        return  link.getLongUrl();
    }
    @Override
    public void deleteShortUrl(String shortUrl) {
        Link link = linkRepository.findByShortUrl(shortUrl)
                .orElseThrow(LinkNotFoundException::new);
        linkRepository.delete(link);
    }

    @Override
    public Page<Link> getAllLinks(Pageable pageable) {
        return linkRepository.findAll(pageable);
    }

    private String getShortUrl(){
        String randString = Utils.generateRandomString(8);
        if(linkRepository.existsByShortUrl(randString)){
            return getShortUrl();
        } else {
            return randString;
        }
    }
}