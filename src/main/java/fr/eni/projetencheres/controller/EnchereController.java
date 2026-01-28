package fr.eni.projetencheres.controller;


import fr.eni.projetencheres.bo.Article;
import fr.eni.projetencheres.bo.Categorie;
import fr.eni.projetencheres.service.ArticleService;
import fr.eni.projetencheres.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;


@Controller
public class EnchereController {
    ArticleService articleService;
    UtilisateurService utilisateurService;

    public EnchereController(ArticleService articleService, UtilisateurService utilisateurService) {
        this.articleService = articleService;
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/encheres")
    public String displayArticles (Model model) {
        List<Article> list= this.articleService.getAllArticles();
        model.addAttribute("articleLst", list);
        return "liste_des_artVente";
    }

    @GetMapping ("/encheres/inscription")
    public String inscription() { return "s_inscrire";}


    @GetMapping ("/encheres/vendre")
    public String Vendre() {
        return "add_vente";
    }

    @GetMapping ("/encheres/details_vente")
    public String details() {
        return "details_vente";
    }

//    @GetMapping ("/liste_des_artVente")
//    public String liste_des_artVente() {
//        return "liste_des_artVente";
//    }

    @GetMapping ("/encheres/login")
    public String login() {
        return "login";
    }

    @GetMapping ("/encheres/profil")
    public String profil() {
        return "profil";
    }





//    @GetMapping({"/details_vente"})
//    public String showDetails(@RequestParam("id") long id, Model model) {
//        Article article = this.articleService.getArticleById(id);
//        model.addAttribute("article", article);
//        return "details_vente";
//    }

}
