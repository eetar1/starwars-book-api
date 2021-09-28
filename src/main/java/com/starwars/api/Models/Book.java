package com.starwars.api.Models;

import java.time.Instant;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "starwarsbooks")
@Data
public class Book {

    @Id
    @NotBlank(message = "Book Id's must not be null")
    private String id;

    private String title;

    private String author;

    private String year;

    @Indexed private String type;

    @Indexed private String era;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Field("releasedate")
    private Instant releaseDate;

    private Boolean owned;

    public Book(String id, String title, boolean owned) {
        this.id = id;
        this.title = title;
        this.owned = owned;
    }
}
