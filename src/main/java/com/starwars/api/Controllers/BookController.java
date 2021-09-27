package com.starwars.api.Controllers;

import com.starwars.api.Models.Book;
import com.starwars.api.Repositories.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository repository) {
        this.bookRepository = repository;
    }

    @GetMapping("/era/{era}")
    public List<Book> getBooksByEra(@PathVariable(name = "era") String era) {
        return bookRepository.findByEraAndTypeOrderById(era, "ON");
    }

    @GetMapping("/type/{type}")
    public List<Book> getBooksByType(@PathVariable(name = "type") String type) {
        return bookRepository.findByTypeOrderById(type);
    }

    @PostMapping
    public Book updateBook(Book book) throws Exception {
        Book save = bookRepository.findById(book.getId()).orElseThrow(Exception::new);
        save.setOwned(book.getOwned());
        return bookRepository.save(save);
    }
}
