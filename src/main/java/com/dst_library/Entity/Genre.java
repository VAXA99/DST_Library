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
@Table(name = "genre")
public class Genre {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "id_genre")
    @Id
    private Long idGenre;

    @Column(columnDefinition = "TEXT", name = "name")
    private String name;

    public Genre(String name) {
        this.name = name;
    }
}
