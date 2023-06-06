package com.dst_library.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "id_book")
    @Id
    private Long idBook;

    @Column(columnDefinition = "TEXT", name = "author")
    private String author;

    @Column(columnDefinition = "TEXT", name = "name")
    private String name;

    @Column(columnDefinition = "TEXT", name = "genre")
    private String genre;

    public Book(String author, String name, String genre) {
        this.author = author;
        this.name = name;
        this.genre = genre;
    }
}
