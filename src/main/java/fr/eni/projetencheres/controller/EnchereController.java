package fr.eni.projetencheres.controller;


import fr.eni.projetencheres.bo.Article;
import fr.eni.projetencheres.bo.Categorie;
import fr.eni.projetencheres.bo.Enchere;
import fr.eni.projetencheres.bo.Utilisateur;
import fr.eni.projetencheres.security.EncheresSecurity;
import fr.eni.projetencheres.service.ArticleService;
import fr.eni.projetencheres.service.CategorieService;
import fr.eni.projetencheres.service.EnchereService;
import fr.eni.projetencheres.service.UtilisateurService;
import jakarta.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


@Controller
public class EnchereController {
    ArticleService articleService;
    UtilisateurService utilisateurService;
    CategorieService categorieService;
    EnchereService enchereService;
    EncheresSecurity encheresSecurity;

    public EnchereController(ArticleService articleService, UtilisateurService utilisateurService, CategorieService categorieService, EnchereService enchereService, EncheresSecurity encheresSecurity) {
        this.articleService = articleService;
        this.utilisateurService = utilisateurService;
        this.categorieService = categorieService;
        this.enchereService = enchereService;
        this.encheresSecurity = encheresSecurity;
    }

    // ----------------------------Barre de recherche----------------------------

    @GetMapping("/encheres")
    public String displayArticles (Model model) {
        List<Article> list= this.articleService.getAllArticles();
        model.addAttribute("articleLst", list);
        return "liste_des_artVente";
    }

    @GetMapping("/encheres/oldsearch")
    public String searchArticles(@RequestParam(name="q") String article_name, Model model) {
        System.out.println("searchArticles");
        List<Article> list = articleService.searchArticle(article_name);
        model.addAttribute("articleLst",list);
        return "liste_des_artVente";
    }

    @GetMapping("/encheres/search")
    public String searchArticlesConfigurable(Model model,
        @RequestParam(name="q", defaultValue = "") String searchedTerm,
        @RequestParam(name="byCategorie", defaultValue = "off") String byCategorie,
        @RequestParam(name="byDescription", defaultValue = "off") String byDescription,
        @RequestParam(name="categorie", defaultValue = "") String categorie
                                            ) {
        System.out.println("searchArticlesConfigurable");
        List<Article> list = articleService.searchArticleConfigurable(searchedTerm, byCategorie, byDescription, categorie);
        model.addAttribute("articleLst",list);
        return "liste_des_artVente";
    }

// ----------------------------Mettre un article en vente----------------------------

    @GetMapping ("/encheres/add")
    public String addArticle(Model model,
                             @Valid Article article,
                             BindingResult bindingResult,
                             @ModelAttribute("user") Utilisateur user) {
        List<Categorie> list= categorieService.getAllCategories();

        model.addAttribute("categorieList",list);
        if (bindingResult.hasErrors()) {
            System.err.println("addArticle erreur");
            return "add_vente"; // affiche les erreurs sur la page
        }
        System.out.println("utilisateur actuel" + user);
        article.setVendeur(user);

        model.addAttribute("article", new Article());
        return "add_vente";
    }

    @PostMapping("/encheres/create")
    public String createArticle(Model model, Article article) {
        articleService.addArticle(article);
        return "redirect:/encheres";
    }
// ----------------------------Détails, update et possibilité d'enchérir----------------------------

    @GetMapping ("/encheres/details_vente")
    public String detailsArticle(@RequestParam(name="id")long id, Model model) {
        UserDetails userDetails =
                (UserDetails) Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getPrincipal();

        Article article = articleService.getArticleById(id);
        List<Categorie> list = categorieService.getAllCategories();

        assert userDetails != null;
        model.addAttribute("utilisateurConnect", utilisateurService.getUtilisateurByUsername(userDetails.getUsername()));
        model.addAttribute("article", article);
        model.addAttribute("categoriesList",list);
        model.addAttribute("selectedCategory",article.getCategorie().getId_categorie());
        model.addAttribute("enchere", new Enchere());
        return "view_details_article_encherir";

    }

    @PostMapping("/encheres/acheter")
    public String encherir(@ModelAttribute(name="enchere") Enchere enchere, @RequestParam(name="id_article") long id_article) {
        UserDetails userDetails =
                (UserDetails) Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getPrincipal();

        assert userDetails != null;
        enchere.setUtilisateur(utilisateurService.getUtilisateurByUsername(userDetails.getUsername()));

        Article art = new Article();
        art.setId_article(id_article);
        enchere.setArticle(art);

        System.out.println(enchere);

        enchereService.addEnchere(enchere);
        return "redirect:/encheres/details_vente?id=" + id_article;
    }

    @PostMapping("/encheres/update")
    public String updateArticle(@ModelAttribute(name="article") Article article, Model model) {
        articleService.updateArticle(article);
        return"redirect:/encheres";
    }

}