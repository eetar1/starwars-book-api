package com.starwars.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableMongoRepositories
@EnableScheduling
public class StarwarsBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarwarsBookApplication.class, args);
    }
}
