package com.github.WuangMai.workshop.web.mvc;

import com.github.WuangMai.workshop.model.Book;
import com.github.WuangMai.workshop.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/books")
public class BookController {

private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public String showPosts(Model model){
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "/books/all";
    }
}
