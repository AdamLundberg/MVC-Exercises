package se.kalmar.adam.MVCExercises.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Fever {
    private Integer bodyTemp = null;
    private String message = "Enter your body temperature!";
    private String normalTemp = "Your temp is fine!";
    private String highTemp = "Your temp is high!";
    private String lowTemp = "Your temp is low!";

    @GetMapping("/fever")
    public String fever(Model model) {

        if (bodyTemp != null) {
            if (bodyTemp > 38) {
                model.addAttribute("fever", highTemp);
            } else if (bodyTemp <36) {
                model.addAttribute("fever", lowTemp);
            } else {
                model.addAttribute("fever", normalTemp);
            }
        } else {
            model.addAttribute("fever", message);
        }

        return "fever";
    }

    @PostMapping("/fever")
    public String fever(@RequestParam int feverInput) {
        this.bodyTemp = feverInput;
        return "redirect:fever";
    }
}
