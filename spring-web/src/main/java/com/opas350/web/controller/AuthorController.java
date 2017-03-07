package com.opas350.web.controller;

import com.opas350.entities.Author;
import com.opas350.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by javier.reyes.valdez on 3/6/2017.
 */
@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    @RequestMapping(value = {"/authors"})
    public String allAuthors(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "authors";
    }

    @GetMapping
    @RequestMapping(value = {"/author/new"})
    public String newAuthor(Model model) {
        model.addAttribute("author", new Author());
        return "newAuthor";
    }

    @GetMapping
    @RequestMapping(value = {"/author/{id}"})
    public String showAuthor(@PathVariable Integer id, Model model) {
        model.addAttribute("author", authorService.findById(id));
        return "showAuthor";
    }

    @PostMapping
    @RequestMapping(value = "/author")
    public String saveAuthor(Author author) {
        authorService.saveAuthor(author);
        return "redirect:/author/" + author.getIdAuthor();
    }
}
