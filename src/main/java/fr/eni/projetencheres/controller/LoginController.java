package fr.eni.projetencheres.controller;


import fr.eni.projetencheres.bo.Utilisateur;
import fr.eni.projetencheres.service.UtilisateurService;
import fr.eni.projetencheres.security.EncheresSecurity;
import fr.eni.projetencheres.service.exception.ServiceException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {

    UtilisateurService utilisateurService;
    EncheresSecurity encheresSecurity;


    public LoginController(UtilisateurService utilisateurService, EncheresSecurity encheresSecurity) {
        this.utilisateurService = utilisateurService;
        this.encheresSecurity = encheresSecurity;
    }

    @GetMapping({"/login"})
    public String displayLogin() {
        return "login";
    }

    @GetMapping("/logout")
    public String displayLogout() {
        return "logout";
    }

    @GetMapping ("/inscription")
    public String inscription(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "signup";
    }

    @PostMapping ("/inscription")
    public String inscription(@Valid Utilisateur utilisateur, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "signup"; // affiche les erreurs sur la page
        }
        try {
            utilisateurService.addUtilisateur(utilisateur);
        } catch(ServiceException e) {
         //Ajoute les erreurs puis renvoie sur la page
            bindingResult.addError(new ObjectError("globalError", e.getMessage()));
            model.addAttribute("notUniqueMessage","Ce pseudo est déjà utilisé. Veuillez choisir un pseudo unique.");
            return "signup";
          }
        return "redirect:/login";
      }
}
