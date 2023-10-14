package com.example.urlshortener.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "links")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String longUrl;

    private String shortUrl;

    @CreatedDate
    private LocalDate createdAt ;

    @PrePersist
    public void setDate(){
        createdAt = LocalDate.now();
    }

}
