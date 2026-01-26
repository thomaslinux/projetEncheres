package fr.eni.projetencheres.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({"/encheres"})
@Controller
public class EnchereController {

    @GetMapping
    public String pageDAccueil() {
        return "index";
    }

}
