package fr.eni.projetencheres.controller;


import fr.eni.projetencheres.bo.Utilisateur;
import fr.eni.projetencheres.repository.UtilisateurDao;
import fr.eni.projetencheres.service.UtilisateurService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    UtilisateurService utilisateurService;

    public LoginController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
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

    @PostMapping ("/inscription")
    public String saveInscription(@Valid Utilisateur utilisateur, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "signup"; // renvoie la page avec les erreurs affichées
        }
        // TODO do not save the utilisateur if email exists, display email exists
        utilisateurService.addUtilisateur(utilisateur);
        System.out.println(utilisateur);
        return "redirect:/login";
      }

}
