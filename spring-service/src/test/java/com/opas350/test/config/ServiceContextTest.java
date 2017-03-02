package com.opas350.test.config;

import com.opas350.config.ServiceContext;
import com.opas350.service.BookService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by javier.reyes.valdez on 3/2/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceContext.class)
public class ServiceContextTest {

    @Autowired
    protected BookService bookService;
}
