package com.opas350.service;

import com.opas350.entities.Author;

import java.util.List;

/**
 * Created by javier.reyes.valdez on 3/6/2017.
 */
public interface AuthorService {
    List<Author> findAll();
    Author saveAuthor(Author author);
    Author findById(Integer id);
    void deleteAuthor(Integer id);
}
