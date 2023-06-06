package com.dst_library.Controller;

import com.dst_library.Entity.Form;
import com.dst_library.Service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/form")
public class FormController {

    @Autowired
    FormService formService;

    @GetMapping
    public String getFormsPage(Model model) {
        List<Form> forms = formService.getAll();
        model.addAttribute("forms", forms);

        return "forms";
    }
}
