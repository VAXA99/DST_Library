package com.dst_library.Controller;

import com.dst_library.Entity.Genre;
import com.dst_library.Service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    GenreService genreService;

    @GetMapping
    public String getGenresPage(Model model) {
        List<Genre> genres = genreService.getAll();
        model.addAttribute("genres", genres);
        return "genres";
    }

    @GetMapping("/delete/{genreId}")
    public String deleteGenre(@PathVariable Long genreId) {
        genreService.delete(genreId);

        return "redirect:/genres";
    }

    @PostMapping("/add")
    public String add( @RequestParam(value = "name") String name) {

        if  (name.trim().isEmpty()) {
            return "redirect:/genres";
        }
        Genre genre = new Genre(name);
        genreService.create(genre);

        return "redirect:/genres";
    }
}
