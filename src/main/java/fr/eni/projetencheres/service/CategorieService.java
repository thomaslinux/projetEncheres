package fr.eni.projetencheres.service;

import fr.eni.projetencheres.bo.Categorie;

import java.util.List;

public interface CategorieService {
    List<Categorie> getAllCategories();

    void addCategoeire(Categorie categorie);

    Categorie getCategorie(long id);

    void deleteCategorie (long id);

    void updateCategorie(Categorie categorie);

}
