package com.dst_library.Controller;

import com.dst_library.Entity.Catalogue;
import com.dst_library.Service.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/catalogue")
public class CatalogueController {

    @Autowired
    CatalogueService catalogueService;

    @GetMapping
    public String getCataloguesPage(Model model) {
        List<Catalogue> catalogues = catalogueService.getAll();
        model.addAttribute("catalogues", catalogues);

        return "catalogues";
    }
}
