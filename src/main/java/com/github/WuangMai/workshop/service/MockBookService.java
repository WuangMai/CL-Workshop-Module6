package com.github.WuangMai.workshop.service;

import com.github.WuangMai.workshop.model.Book;
import com.github.WuangMai.workshop.repository.BookRepo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@ToString
@Component
public class MockBookService {
    private List<Book> books;
    private static Long nextId = 4L;

    public MockBookService() {
        books = new ArrayList<>();
        books.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        books.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        books.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    public void add(Book book){
        book.setId(nextId++);
        books.add(book);
    }

    public Optional<Book> get(Long id) {
        return books.stream().filter(item -> item.getId().equals(id)).findFirst();
    }

    public void delete(Long id) {
        if (get(id).isPresent()) {
            books.remove(this.get(id).get());
        }
    }

    public void update(Book book) {
        if (this.get(book.getId()).isPresent()) {
            int indexOf = books.indexOf(this.get(book.getId()).get());
            books.set(indexOf, book);
        }
    }

}
