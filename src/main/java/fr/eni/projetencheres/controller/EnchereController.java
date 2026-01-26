package fr.eni.projetencheres.controller;


import fr.eni.projetencheres.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/encheres")

public class EnchereController {

    @Autowired
    UtilisateurService utilisateurService;

    @GetMapping
    public String pageDAccueil() {
        return "index";
    }

    @GetMapping ("/inscription")
    public String inscription() {
        return "s_inscrire";
    }

    @GetMapping ("/vendre")
    public String Vendre() {
        return "add_vente";
    }

    @GetMapping ("/details_vente")
    public String details() {
        return "details_vente";
    }

    @GetMapping ("/liste_des_artVente")
    public String liste_des_artVente() {
        return "liste_des_artVente";
    }

    @GetMapping ("/login")
    public String login() {
        return "login";
    }

    @GetMapping ("/profil")
    public String profil() {
        return "profil";
    }

}
