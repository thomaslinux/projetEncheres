package fr.eni.projetencheres.controller;

import fr.eni.projetencheres.bo.Categorie;
import fr.eni.projetencheres.service.CategorieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategorieController {

    CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping("/categories")
    public String displayCategories(Model model) {
        List<Categorie> categories = categorieService.getAllCategories();
        model.addAttribute("list",categories);
        return "categoriesList";
    }

    @GetMapping("/details_categorie")
    public String detailsCategorie(Model model, @RequestParam(name = "id") long id) {
        Categorie categorie = categorieService.getCategorie(id);
        model.addAttribute("category",categorie);
        return "view_details_categorie";
    }
}
