package com.starwars.api.Repositories;

import com.starwars.api.Models.Book;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

    List<Book> findByEraAndTypeOrderById(String era, String type);

    List<Book> findByTypeOrderById(String type);

    List<Book> findAllByOrderById();

    List<Book> findByTitleContainingIgnoreCase(String query);
}
