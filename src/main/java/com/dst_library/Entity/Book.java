package com.dst_library.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Book {

    @SequenceGenerator(name = "notes_SEQ", sequenceName = "notes_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "SERIAL", name = "id_book")
    @Id
    private Long idBook;

    @Column(columnDefinition = "TEXT", name = "author")
    private String author;

    @Column(columnDefinition = "TEXT", name = "name")
    private String name;

    @Column(columnDefinition = "TEXT", name = "genre")
    private String genre;

    public Book() {
    }

    public Book(String author, String name, String genre) {
        this.author = author;
        this.name = name;
        this.genre = genre;
    }

    public Book(Long idBook, String author, String name, String genre) {
        this.idBook = idBook;
        this.author = author;
        this.name = name;
        this.genre = genre;
    }
}
