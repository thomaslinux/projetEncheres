package fr.eni.projetencheres.controller;


import fr.eni.projetencheres.bo.Utilisateur;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping({"/login"})
    public String displayLogin() {
        return "login";
    }

    @GetMapping ("/inscription")
    public String inscription(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "signup";
    }

    // TODO save the utilisateur on submit
      @PostMapping ("/inscription")
    public String inscription(@Valid Utilisateur utilisateur, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "signup"; // affiche les erreurs sur la page
        }
        // save the utilisateur logic here
        return "redirect:/login";
      }

}
