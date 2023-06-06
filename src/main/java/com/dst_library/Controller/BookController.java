package com.dst_library.Controller;


import com.dst_library.Entity.Book;
import com.dst_library.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String getBooksPage(Model model) {
        List<Book> books = bookService.getAll();
        model.addAttribute("books", books);

        return "books";
    }




}
