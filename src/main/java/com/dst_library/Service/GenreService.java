package com.dst_library.Service;

import com.dst_library.Entity.Genre;
import com.dst_library.Repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreRepository formRepository;

    @Async
    public List<Genre> getAll() {
        return formRepository.findAll();
    }

    @Async
    public Genre getById(Long idGenre) {
        return formRepository.findById(idGenre).orElse(null);
    }

    @Async
    public void create(Genre genre) {
        formRepository.save(genre);
    }

    @Async
    public void delete(Long idGenre) {
        formRepository.deleteById(idGenre);
    }

    @Async
    public void update(Genre genre) {
        Genre _genre = getById(genre.getIdGenre());
        _genre.setName(genre.getName());

        formRepository.save(_genre);
    }
}
