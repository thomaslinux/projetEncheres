package fr.eni.projetencheres.repository;

import fr.eni.projetencheres.bo.Categorie;

import java.util.List;

public interface CategorieDao {
    public List<Categorie> readCategories();

    void addCategorie(Categorie categorie);

    Categorie getCategorie(long id);

    void deleteCategorie(long id);

    void updateCategorie(Categorie categorie);
}
