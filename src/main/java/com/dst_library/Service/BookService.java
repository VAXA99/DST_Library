package com.dst_library.Service;


import com.dst_library.Entity.Book;
import com.dst_library.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Async
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Async
    public Book getById(Long idBook) {
        return  bookRepository.findById(idBook).orElse(null);
    }

    @Async
    public Book getByName(String name) {
        return bookRepository.getByName(name);
    }

    @Async
    public void create(Book book) {
        bookRepository.save(book);
    }

    @Async
    public void delete(Long idBook) {
        bookRepository.deleteById(idBook);
    }

    @Async
    public void update(Book book) {
        Book _book = getById(book.getIdBook());
        _book.setAuthor(book.getAuthor());
        _book.setName(book.getName());
        _book.setGenre(book.getGenre());
        bookRepository.save(_book);
    }

}
