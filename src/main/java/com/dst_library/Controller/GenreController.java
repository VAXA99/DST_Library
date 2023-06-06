package com.dst_library.Controller;

import com.dst_library.Entity.Genre;
import com.dst_library.Service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    GenreService genreService;

    @GetMapping
    public String getGenresPage(Model model) {
        List<Genre> genres = genreService.getAll();
        model.addAttribute("genres", genres);

        return "genres";
    }
}
