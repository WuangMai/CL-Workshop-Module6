package com.github.WuangMai.workshop.web.rest;

import com.github.WuangMai.workshop.model.Book;
import com.github.WuangMai.workshop.service.MockBookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookRestController {

    private final MockBookService mockBookService;

    public BookRestController(MockBookService mockBookService) {
        this.mockBookService = mockBookService;
    }

    @RequestMapping("/hello")
    public Book helloBook(){
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }


    @GetMapping("")
    public List<Book> getList(){
        return mockBookService.getBooks();
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        mockBookService.add(book);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id){
        return mockBookService.get(id).orElseThrow(() -> {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        });
    }

    @DeleteMapping("/{id}")
    public void removeBook(@PathVariable Long id){
        mockBookService.delete(id);
    }

    @PutMapping("")
    public void updateBook(@RequestBody Book book){
        mockBookService.update(book);
    }

}
