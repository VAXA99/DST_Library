package com.dst_library.Controller;


import com.dst_library.Entity.Book;
import com.dst_library.Entity.Genre;
import com.dst_library.Service.BookService;
import com.dst_library.Service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private GenreService genreService;


    @GetMapping
    public String getBooksPage(Model model) {
        List<Book> books = bookService.getAll();
        model.addAttribute("books", books);

        List<Genre> genres = genreService.getAll();
        model.addAttribute("genres", genres);

        return "books";
    }

    @GetMapping("/delete/{bookId}")
    public String deleteBook(@PathVariable Long bookId) {
        bookService.delete(bookId);

        return "redirect:/books";
    }

    @PostMapping("/add")
    public String add   (@RequestParam(value = "author") String author,
                         @RequestParam(value = "genre") String genre,
                         @RequestParam(value = "name") String name) {
        if  (author.trim().isEmpty() || name.trim().isEmpty()) {
            return "redirect:/books";
        }
        Book book = new Book(author, name, genre);
        bookService.create(book);

        return "redirect:/books";
    }

    @PostMapping("/search_book")
    public String finBook(@RequestParam(value = "key_name") String name, Model model) {
        Book book  = bookService.getByName(name);
        model.addAttribute("books", book);
        return "books";
    }


}
