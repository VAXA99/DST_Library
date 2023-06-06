package com.dst_library.Controller;

import com.dst_library.Entity.Branch;
import com.dst_library.Service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    BranchService branchService;

    @GetMapping
    public String getBranchesBook(Model model) {
        List<Branch> branches = branchService.getAll();
        model.addAttribute("branches", branches);

        return "branches";
    }
}
