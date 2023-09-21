package com.pb.library.service;

import com.pb.library.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findById(int id);

    void save(Book author);

    void deleteById(int id);
}
