package com.example.urlshortener.controllers;

import com.example.urlshortener.data.models.Link;
import com.example.urlshortener.services.LinkService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/link")
@AllArgsConstructor
public class LinkController {

    private final LinkService linkService;

    
    @PostMapping
    public ResponseEntity<String> createShortUrl(@RequestParam String longUrl){
        return ResponseEntity.ok(linkService.shorten(longUrl));
    }

    @GetMapping
    public ResponseEntity<String> retrieveLongUrl(@RequestParam String shortUrl){
        return ResponseEntity.ok(linkService.getLongUrl(shortUrl));
    }


    @DeleteMapping("/{shortUrl}")
    public ResponseEntity<String> deleteLink(@PathVariable String shortUrl){
        linkService.deleteShortUrl(shortUrl);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping("/all")
    public ResponseEntity<Page<Link>> getAllLinks(){
        return ResponseEntity.ok(linkService.getAllLinks(Pageable.unpaged()));
    }

}
