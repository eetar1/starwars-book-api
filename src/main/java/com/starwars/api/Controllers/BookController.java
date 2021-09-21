package com.starwars.api.Controllers;

import com.starwars.api.Models.Book;
import com.starwars.api.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

  private final BookRepository repository;

  @Autowired
  public BookController(BookRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/{era}")
  public List<Book> getBooksByEra(@PathVariable(name = "era") String era) {
    return getBooksByEra(era);
  }
}
