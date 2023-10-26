package com.pb.library.controller;

import com.pb.library.entity.Author;
import com.pb.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import java.util.Arrays;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/list")
    public String listAuthors(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "authors/list-authors";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Author author = new Author();
        model.addAttribute("author", author);
        return "authors/author-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("authorId") int id, Model model) {
        Author author = authorService.findById(id);
        model.addAttribute("author", author);
        return "authors/author-form";
    }

    @PostMapping("/save")
    public String saveAuthor(@ModelAttribute("author") Author author) {
        authorService.save(author);
        return "redirect:/authors/list";
    }

    @DeleteMapping("/delete")
    public String deleteAuthor(@RequestParam("authorId") int id) {
        authorService.deleteById(id);
        return "redirect:/authors/list";
    }
}
