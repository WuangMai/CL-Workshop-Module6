package com.github.WuangMai.workshop.repository;

import com.github.WuangMai.workshop.model.Book;

import java.util.Optional;

public interface MockBookRepo {

    void add(Book book);

    Optional<Book> get(Long id);

    void delete(Long id);

    void update(Book book);
}
