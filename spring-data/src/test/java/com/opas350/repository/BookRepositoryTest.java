package com.opas350.repository;

import com.opas350.entities.Book;
import com.opas350.persistence.PersistenceContextTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by javier.reyes.valdez on 3/2/2017.
 */
public class BookRepositoryTest extends PersistenceContextTest {

    @Test
    public void count(){

        long numberBooks = bookRepository.count();
        Assert.assertTrue(numberBooks > 0);
    }

    @Test
    public void findAllBooks() {
        List<Book> books = bookRepository.findAll();
        Assert.assertFalse(books.isEmpty());
    }

    @Test
    public void findByTitle() {
        String titleExpected = "Java for Dummies";
        List<Book> books = bookRepository.findByTitle(titleExpected);
        String titleActual = books.get(0).getTitle();
        Assert.assertTrue(titleActual.contains(titleExpected));
    }
}
