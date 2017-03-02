package com.opas350.test.service;

import com.opas350.entities.Book;
import com.opas350.test.config.ServiceContextTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by javier.reyes.valdez on 3/2/2017.
 */
public class BookServiceTest extends ServiceContextTest {

    @Test
    public void findByTitle() {

        String titleExpected = "Java for noobs";
        List<Book> books = bookService.findByTitle(titleExpected) ;

        books.forEach(book -> {
            String titleActual = book.getTitle();
            System.out.println(titleActual);
            Assert.assertTrue(titleActual.contains(titleExpected));
        });

    }
}
