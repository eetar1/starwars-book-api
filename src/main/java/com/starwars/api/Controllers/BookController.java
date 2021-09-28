package com.starwars.api.Controllers;

import com.starwars.api.Exceptions.MissingEntityException;
import com.starwars.api.Models.Book;
import com.starwars.api.Repositories.BookRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
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

    @GetMapping("/ON")
    public List<Book> getAllONBooks() {
        return bookRepository.findByTypeOrderById("ON");
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping
    public Book updateBook(@RequestBody @Valid Book book, BindingResult result)
            throws MissingEntityException, BindException {
        //    This has to be done so that security check is performed before the binding check
        //    Otherwise binding errors take priority over security errors
        if (result.hasErrors()) {
            throw new BindException(result);
        }

        Book save = bookRepository.findById(book.getId()).orElseThrow(MissingEntityException::new);
        save.setOwned(book.getOwned());
        return bookRepository.save(save);
    }
}
