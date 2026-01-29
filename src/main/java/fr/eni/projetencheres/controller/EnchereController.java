package fr.eni.projetencheres.controller;


import fr.eni.projetencheres.bo.Article;
import fr.eni.projetencheres.bo.Categorie;
import fr.eni.projetencheres.service.ArticleService;
import fr.eni.projetencheres.service.CategorieService;
import fr.eni.projetencheres.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.time.LocalDate;
import java.util.List;


@Controller
public class EnchereController {
    ArticleService articleService;
    UtilisateurService utilisateurService;
    CategorieService categorieService;

    public EnchereController(ArticleService articleService, UtilisateurService utilisateurService, CategorieService categorieService) {
        this.articleService = articleService;
        this.utilisateurService = utilisateurService;
        this.categorieService = categorieService;
    }

    @GetMapping("/encheres")
    public String displayArticles (Model model) {
        List<Article> list= this.articleService.getAllArticles();
        model.addAttribute("articleLst", list);
        return "liste_des_artVente";
    }

    @GetMapping ("/encheres/inscription")
    public String inscription() { return "s_inscrire";}


    @GetMapping ("/encheres/add")
    public String addArticle(Model model, Article article) {
        List<Categorie> list= categorieService.getAllCategories();

        model.addAttribute("article", new Article());
        model.addAttribute("categorieList",list);
        return "add_vente";
    }

    @PostMapping("/encheres/create")
    public String createArticle(Model model, Article article) {
        articleService.addArticle(article);
        return "redirect:/articles";
    }


    @GetMapping ("/encheres/details_vente")
    public String details() {
        return "details_vente";
    }

//    @GetMapping ("/liste_des_artVente")
//    public String liste_des_artVente() {
//        return "liste_des_artVente";
//    }

//    @GetMapping ("/encheres/login")
//    public String login() {
//        return "login";
//    }
//
//    @GetMapping ("/encheres/profil")
//    public String profil() {
//        return "profil";
//    }





//    @GetMapping({"/details_vente"})
//    public String showDetails(@RequestParam("id") long id, Model model) {
//        Article article = this.articleService.getArticleById(id);
//        model.addAttribute("article", article);
//        return "details_vente";
//    }

}