package com.opas350.service;

import com.opas350.entities.Book;

import java.util.List;

/**
 * Created by javier.reyes.valdez on 3/2/2017.
 */
public interface BookService {
    List<Book> findByTitle(String title);

    List<Book> findAll();

    Book findByIsbn(String isbn);

    Book saveBook(Book book);
}
