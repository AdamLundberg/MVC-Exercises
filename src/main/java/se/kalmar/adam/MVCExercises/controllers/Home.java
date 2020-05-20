package se.kalmar.adam.MVCExercises.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Home {
    private List<String> nameList = new ArrayList<>();

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @PostMapping("/contact")
    public String contact(@RequestParam String name) {
        nameList.add(name);
        return "redirect:contact";
    }

    @GetMapping("/contact-list")
    public String contactList(Model model) {
        model.addAttribute("nameList", nameList);

        return "contact-list";
    }
}
