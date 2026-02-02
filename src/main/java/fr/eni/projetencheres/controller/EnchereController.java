package fr.eni.projetencheres.controller;


import fr.eni.projetencheres.bo.Article;
import fr.eni.projetencheres.bo.Categorie;
import fr.eni.projetencheres.service.ArticleService;
import fr.eni.projetencheres.service.CategorieService;
import fr.eni.projetencheres.service.UtilisateurService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.time.LocalDateTime;
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
        return "redirect:/encheres";
    }

    @PostMapping("/encheres/update")
    public String updateArticle(@ModelAttribute(name="article") Article article) {
        System.out.println(article);
        articleService.updateArticle(article);
        return"redirect:/encheres";
    }


    @GetMapping ("/encheres/details_vente")
    public String detailsArticle(@RequestParam(name="id")long id, Model model) {
        Article article = articleService.getArticleById(id);
        List<Categorie> list = categorieService.getAllCategories();
        long selectedCategoryId = article.getCategorie().getId_categorie();
//        debug prints
        System.out.println(article);
        System.out.println(list);
        System.out.println(selectedCategoryId);

        model.addAttribute("article", article);
        model.addAttribute("categoriesList",list);
        model.addAttribute("selectedCategoryId", selectedCategoryId);
        return "view_details_article";
    }

    @GetMapping ("/encheres/login")
    public String login() {
        return "login";
    }

    @GetMapping ("/encheres/profil")
    public String profil() {
        return "profil";
    }

}