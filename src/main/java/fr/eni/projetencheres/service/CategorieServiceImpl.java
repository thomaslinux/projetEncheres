package fr.eni.projetencheres.service;


import fr.eni.projetencheres.bo.Categorie;
import fr.eni.projetencheres.repository.CategorieDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImpl implements CategorieService  {
    CategorieDao categorieDao;


    public CategorieServiceImpl(CategorieDao categorieDao) {
        this.categorieDao = categorieDao;
    }

    @Override
    public List<Categorie> getAllCategories() {
        return this.categorieDao.readCategories();
    }

    @Override
    public void addCategorie(Categorie categorie) {
        this.categorieDao.addCategorie(categorie);

    }

    @Override
    public Categorie getCategorie(long id) {
        return this.categorieDao.getCategorie(id);
    }

    @Override
    public Categorie getCategorieByLibelle(String libelle) {
        return this.categorieDao.getCategorieByLibelle(libelle);
    }

    @Override
    public void deleteCategorie(long id) {
        this.categorieDao.deleteCategorie(id);

    }

    @Override
    public void updateCategorie(Categorie categorie) {

    }
}
