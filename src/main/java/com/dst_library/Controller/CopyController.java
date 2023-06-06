package com.dst_library.Controller;

import com.dst_library.Entity.Copy;
import com.dst_library.Service.CopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/copy")
public class CopyController {

    @Autowired
    CopyService copyService;

    @GetMapping
    public String getCopiesPage(Model model) {
        List<Copy> copies = copyService.getAll();
        model.addAttribute("copies", copies);

        return "copies";
    }
}
