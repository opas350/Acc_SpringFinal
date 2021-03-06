package com.opas350.service.impl;

import com.opas350.entities.Book;
import com.opas350.repository.BookRepository;
import com.opas350.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by javier.reyes.valdez on 3/2/2017.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findByIsbn(String isbn) {return bookRepository.findByIsbn(isbn);}

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
}
