package com.example.server.CatController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatController {

    @GetMapping("/cat")
    public String cat(Model model) {
        model.addAttribute("catName", "Podo");
        return "cat";
    }

}
