package com.opas350.service.impl;

import com.opas350.entities.Author;
import com.opas350.repository.AuthorRepository;
import com.opas350.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by javier.reyes.valdez on 3/6/2017.
 */
@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author findById(Integer id) {
        return authorRepository.findOne(id);
    }

    @Override
    public void deleteAuthor(Integer id) {
        authorRepository.delete(id);
    }
}
