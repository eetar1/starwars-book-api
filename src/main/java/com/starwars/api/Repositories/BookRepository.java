package com.starwars.api.Repositories;

import com.starwars.api.Models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

  List<Book> findByEra(String era);
}
