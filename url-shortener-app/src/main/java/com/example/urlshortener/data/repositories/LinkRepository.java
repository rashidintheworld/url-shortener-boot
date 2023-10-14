package com.example.urlshortener.data.repositories;

import com.example.urlshortener.data.models.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LinkRepository extends JpaRepository<Link, Long> {

    boolean existsByShortUrl(String shortUrl);

    Optional<Link> findByShortUrl(String shortUrl);

    void deleteByShortUrl(String shortUrl);
}
