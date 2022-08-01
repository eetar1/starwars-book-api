package com.starwars.api.Services;

import com.starwars.api.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // This function will get called every day at midnight
    // This is used to keep the mongo atlas alive.
    @Scheduled(cron = "0 0 0 ? * *")
    public void pingDB() {
        this.bookRepository.existsById("1");
    }
}
