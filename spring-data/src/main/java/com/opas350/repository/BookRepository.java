package com.opas350.repository;

import com.opas350.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by javier.reyes.valdez on 3/2/2017.
 */
public interface BookRepository extends JpaRepository<Book, String> {
    public List<Book> findByTitle(String title);

}
