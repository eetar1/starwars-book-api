package com.starwars.api.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "starwarsbooks")
@Data
public class Book {

    @Id
    private String id;

    private String title;

    private String author;

    private String year;

    @Indexed
    private String type;

    @Indexed
    private String era;

    private Instant releaseDate;

    private Boolean owned;
}
