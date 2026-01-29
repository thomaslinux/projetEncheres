package fr.eni.projetencheres.controller.converter;


import fr.eni.projetencheres.bo.Categorie;
import fr.eni.projetencheres.service.CategorieService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class CategorieConverter implements Converter<String, Categorie> {

    CategorieService categorieService;

    public CategorieConverter(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @Override
    public Categorie convert(String idstring) {
        long id = Long.parseLong(idstring);
        return categorieService.getCategorie(id);
    }
}


