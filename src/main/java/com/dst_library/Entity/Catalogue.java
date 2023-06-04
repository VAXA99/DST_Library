package com.dst_library.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Embeddable
@Entity
public class Catalogue {

    @SequenceGenerator(name = "notes_SEQ", sequenceName = "notes_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "SERIAL", name = "id_catalogue")
    @Id
    private Long idCatalogue;

    @ManyToOne
    @JoinColumn(name = "id_genre", referencedColumnName = "id_genre", foreignKey = @ForeignKey(name = "id_genre"))
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "id_book", referencedColumnName = "id_book", foreignKey = @ForeignKey(name = "id_book"))
    private Book book;

    @Column(columnDefinition = "TEXT", name = "keywords")
    private String keywords;

    public Catalogue() {
    }

    public Catalogue(Genre genre, Book book, String keywords) {
        this.genre = genre;
        this.book = book;
        this.keywords = keywords;
    }

    public Catalogue(Long idCatalogue, Genre genre, Book book, String keywords) {
        this.idCatalogue = idCatalogue;
        this.genre = genre;
        this.book = book;
        this.keywords = keywords;
    }
}
