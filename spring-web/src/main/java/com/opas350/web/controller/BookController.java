package com.opas350.web.controller;

import com.opas350.entities.Book;
import com.opas350.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by javier.reyes.valdez on 3/2/2017.
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    @RequestMapping(value={"/books"})
    public String allBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books";
    }

    @GetMapping
    @RequestMapping(value = {"/book/new"})
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        return "newBook";
    }

    @GetMapping
    @RequestMapping(value = {"/book/{isbn}"})
    public String showBook(@PathVariable String isbn, Model model) {
        model.addAttribute("book", bookService.findByIsbn(isbn));
        return "showBook";
    }
    @PostMapping
    @RequestMapping(value = {"/book"})
    public String saveBook(Book book) {
        bookService.saveBook(book);
        return "redirect:/book/"+book.getIsbn();
    }

}
