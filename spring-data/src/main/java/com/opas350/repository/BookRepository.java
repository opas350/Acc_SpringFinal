package com.opas350.repository;

import com.opas350.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by javier.reyes.valdez on 3/2/2017.
 */
public interface BookRepository extends JpaRepository<Book, String>, CrudRepository<Book, String> {

    List<Book> findByTitle(String title);

    Book findByIsbn(String isbn);

}
