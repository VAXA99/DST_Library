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
@Table(name = "catalogue")
public class Catalogue {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "id_catalogue")
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

    public Catalogue(Genre genre, Book book, String keywords) {
        this.genre = genre;
        this.book = book;
        this.keywords = keywords;
    }
}
