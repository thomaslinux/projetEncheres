package fr.eni.projetencheres.controller;


import fr.eni.projetencheres.bo.Utilisateur;
import fr.eni.projetencheres.service.UtilisateurService;
import fr.eni.projetencheres.security.EncheresSecurity;
import fr.eni.projetencheres.service.exception.ServiceException;
import jakarta.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@Controller
public class LoginController {

    UtilisateurService utilisateurService;
    EncheresSecurity encheresSecurity;


    public LoginController(UtilisateurService utilisateurService, EncheresSecurity encheresSecurity) {
        this.utilisateurService = utilisateurService;
        this.encheresSecurity = encheresSecurity;
    }

    @GetMapping({"/login"})
    public String displayLogin(@RequestParam(value = "error", required = false)
                               String error, Model model) {
        if (error != null) {
            model.addAttribute("errorMessage", "Identifiant ou mot de passe incorrect");
        }
        return "login";
    }

    @GetMapping("/logout")
    public String displayLogout() {
        return "logout";
    }

    @GetMapping("/profil")
    public String profil(Model model) {
        UserDetails userDetails =
                (UserDetails) Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getPrincipal();
        assert userDetails != null;
        Utilisateur user = utilisateurService.getUtilisateurByUsername(userDetails.getUsername());
        System.out.println(user);
        model.addAttribute("utilisateurConnect", user);
        return "profil";
    }

    @GetMapping("/{username}")
    public String profilAutre(Model model, @PathVariable (name = "username", required = false) String username) {
        Utilisateur user = utilisateurService.getUtilisateurByUsername(username);
        System.out.println(user);
        if (user == null) {
            return "error_404";
        }
        model.addAttribute("utilisateurConnect", user);
        return "view_details_utilisateur";
    }

    @PostMapping("/profil")
    public String updateUtilisateur(@ModelAttribute("utilisateurConnect")
                                    Utilisateur utilisateurConnect,
                                    @RequestParam("action") String action) {
        System.out.println("utilisateur : " + utilisateurConnect);
        if ("delete".equals(action)) {
            utilisateurService.deleteUtilisateur(utilisateurConnect.getId_utilisateur());
        } else {
            utilisateurService.updateUtilisateur(utilisateurConnect);
        }
        return "redirect:/";
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
