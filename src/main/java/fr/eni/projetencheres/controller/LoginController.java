package fr.eni.projetencheres.controller;


import fr.eni.projetencheres.bo.Utilisateur;
import fr.eni.projetencheres.repository.UtilisateurDao;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    UtilisateurDao utilisateurDao;

    public LoginController(UtilisateurDao utilisateurDao) {
        this.utilisateurDao = utilisateurDao;
    }

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
            return "signup"; // renvoie la page avec les erreurs affichées
        }
        utilisateurDao.addUtilisateur(utilisateur);
          System.out.println(utilisateur);
        return "redirect:/login";
      }

}
