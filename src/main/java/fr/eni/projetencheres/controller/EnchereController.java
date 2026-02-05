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
//import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;


//import java.io.File;
//import java.io.IOException;
import java.util.List;
import java.util.Objects;


@Controller
public class EnchereController {
//    private final Environment environment;
    ArticleService articleService;
    UtilisateurService utilisateurService;
    CategorieService categorieService;
    EnchereService enchereService;
    EncheresSecurity encheresSecurity;

//    public EnchereController(ArticleService articleService, UtilisateurService utilisateurService, CategorieService categorieService, EnchereService enchereService, EncheresSecurity encheresSecurity, Environment environment) {
    public EnchereController(ArticleService articleService, UtilisateurService utilisateurService, CategorieService categorieService, EnchereService enchereService, EncheresSecurity encheresSecurity) {
        this.articleService = articleService;
        this.utilisateurService = utilisateurService;
        this.categorieService = categorieService;
        this.enchereService = enchereService;
        this.encheresSecurity = encheresSecurity;
//        this.environment = environment;
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
    public String addArticle(Model model) {
        List<Categorie> list= categorieService.getAllCategories();

        model.addAttribute("categorieList",list);
        UserDetails userDetails =
                (UserDetails) Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getPrincipal();

        Utilisateur user = utilisateurService.getUtilisateurByUsername(userDetails.getUsername());

        model.addAttribute("user", user);
        model.addAttribute("article", new Article());
        return "add_vente";
    }

    @PostMapping("/encheres/create")
    public String createArticle(@ModelAttribute(name="article") Article article
//            ,@RequestParam("image") MultipartFile file
                                ) {
//        if (!file.isEmpty()) {
//            try {
//                String fileName = article.getNom_article() + "_" + file.getOriginalFilename();
//                String uploadDir = environment.getProperty("image.upload.dir");
//                File directory = new File(uploadDir);
//                if (!directory.exists()) {
//                    directory.mkdirs();
//                }
//                file.transferTo(new File(directory, fileName));
//                article.setImage_lien(fileName);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        UserDetails userDetails =
                (UserDetails) Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getPrincipal();
        article.setVendeur(utilisateurService.getUtilisateurByUsername(userDetails.getUsername()));
//        System.out.println(article);
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

//
//        boolean isVendeur = false;
//        if (utilisateurService.getUtilisateurByUsername(userDetails.getUsername()).getId_utilisateur() == article.getVendeur().getId_utilisateur()) {
//            isVendeur = true;
//        }

        assert userDetails != null;
        model.addAttribute("utilisateurConnect", utilisateurService.getUtilisateurByUsername(userDetails.getUsername()));
        model.addAttribute("article", article);
        model.addAttribute("categoriesList",list);
        model.addAttribute("selectedCategory",article.getCategorie().getId_categorie());
//        model.addAttribute("enchere", new Enchere());
//        System.out.println(enchereService.getEnchereMax(article));
//        model.addAttribute("enchereMax", enchereService.getEnchereMax(article));
//        model.addAttribute("isVendeur", isVendeur);
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
    public String updateArticle(@ModelAttribute(name="article") Article article,
                                @RequestParam("action") String action) {
//        UserDetails userDetails =
//                (UserDetails) Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getPrincipal();
//        assert userDetails != null;
//        Utilisateur user = utilisateurService.getUtilisateurByUsername(userDetails.getUsername());
//        System.out.println("current_user = " + user);
//        System.out.println("vendeur of article = " + article.getVendeur());
//        if (article.getVendeur() == null) {
//            return"redirect:/encheres";
//        }
//        if (article.getVendeur().getId_utilisateur() == user.getId_utilisateur()) {
            if("delete".equals(action)) {
                articleService.deleteArticle(article.getId_article());
            }
            if("update".equals(action)) {
                articleService.updateArticle(article);
            }
//        }
        return"redirect:/encheres";
    }

}