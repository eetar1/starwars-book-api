package com.starwars.api.Models;

import java.time.Instant;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "starwarsbooks")
@Data
public class Book {

    @Id @NotBlank private String id;

    @NotBlank private String title;

    @NotBlank private String author;

    @NotBlank private String year;

    @Indexed @NotBlank private String type;

    @Indexed @NotBlank private String era;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Field("releasedate")
    private Instant releaseDate;

    @NotNull private Boolean owned;
}
