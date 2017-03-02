package com.opas350.persistence;

import com.opas350.repository.BookRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.PersistenceContext;

/**
 * Created by javier.reyes.valdez on 3/2/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceContext.class)
public class PersistenceContextTest {

    @Autowired
    protected BookRepository bookRepository;

}
