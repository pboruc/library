package com.pb.library.service;

import com.pb.library.entity.Author;

import java.util.List;

public interface AuthorService {

    List<Author> findAll();

    Author findById(int id);

    void save(Author author);

    void deleteById(int id);
}
