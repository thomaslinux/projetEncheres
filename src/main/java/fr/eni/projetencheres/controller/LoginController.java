package fr.eni.projetencheres.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping({"/login"})
    public String displayLogin() {
        return "login";
    }

    @GetMapping ("/inscription")
    public String inscription() {
        return "signup";
    }

}
