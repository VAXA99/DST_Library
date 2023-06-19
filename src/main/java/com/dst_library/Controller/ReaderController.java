package com.dst_library.Controller;

import com.dst_library.Entity.Reader;
import com.dst_library.Service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/readers")
public class ReaderController {

    @Autowired
    ReaderService readerService;

    @GetMapping
    public String getReadersPage(Model model) {
        List<Reader> readers = readerService.getAll();
        model.addAttribute("readers", readers);

        return "readers";
    }
}
