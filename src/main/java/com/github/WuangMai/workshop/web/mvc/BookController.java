package com.github.WuangMai.workshop.web.mvc;

import com.github.WuangMai.workshop.model.Book;
import com.github.WuangMai.workshop.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/books/")
public class BookController {

private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public String showBooks(Model model){
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "/books/all";
    }

    @GetMapping("/add")
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        return "/books/add";
    }

    @PostMapping("/add")
    public String addBook(@Valid Book book, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return "books/add";
        bookService.add(book);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/edit/{id}")
    public String prepareEdit(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.get(id));
        return "/books/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit (@Valid Book book, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return "books/edit";
        bookService.update(book);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/show/{id}")
    public String showSingle(@PathVariable Long id, Model model){
        if(bookService.get(id).isEmpty()) return "books/all";
        model.addAttribute("book", bookService.get(id).get());
        return "/books/show";
    }



}
