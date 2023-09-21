package com.pb.library.controller;

import com.pb.library.entity.Book;
import com.pb.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books/list-books";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "books/book-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("bookId") int id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "books/book-form";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.save(book);
        return "redirect:/books/list";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam("bookId") int id) {
        bookService.deleteById(id);
        return "redirect:/books/list";
    }
}
