package com.github.WuangMai.workshop.service;

import com.github.WuangMai.workshop.model.Book;
import com.github.WuangMai.workshop.repository.BookRepo;
import com.github.WuangMai.workshop.repository.MockBookRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Primary
@Component
public class BookService implements MockBookRepo {

    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public void add(Book book) {
        bookRepo.save(book);
    }

    public List<Book> getBooks() {
        return bookRepo.findAll();
    }

    @Override
    public Optional<Book> get(Long id) {
        return bookRepo.findById(id);
    }

    @Override
    public void delete(Long id) {
        if (get(id).isPresent()) {
            bookRepo.deleteById(id);
        }
    }

    @Override
    public void update(Book book) {

    }

//    @Override
//    public void update(Book book) {
//        if (this.get(book.getId()).isPresent()) {
//            int indexOf = books.indexOf(this.get(book.getId()).get());
////            bookRepo.
//        }
//    }
}
