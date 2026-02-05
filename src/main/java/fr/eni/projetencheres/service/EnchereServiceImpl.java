package fr.eni.projetencheres.service;

import fr.eni.projetencheres.bo.Article;
import fr.eni.projetencheres.bo.Enchere;
import fr.eni.projetencheres.bo.Utilisateur;
import fr.eni.projetencheres.repository.EnchereDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnchereServiceImpl implements EnchereService {

    EnchereDao enchereDao;

    public EnchereServiceImpl(EnchereDao enchereDao) {
        this.enchereDao = enchereDao;
    }

    @Override
    public List<Enchere> getAllEncheres() {
        return enchereDao.readEncheres();
    }

    @Override
    public void addEnchere(Enchere enchere) {
        enchereDao.addEnchere(enchere);
    }

    @Override
    public Enchere getEnchereById(long id) {
        return enchereDao.getEnchere(id);
    }

    @Override
    public Enchere getEnchereByUtilisateur(Utilisateur enchereur) {
        return enchereDao.getEnchereByUser(enchereur);
    }

    @Override
    public void deleteEnchere(long id) {
        enchereDao.deleteEnchere(id);
    }

    @Override
    public void updateEnchere(Enchere enchere) {
        enchereDao.updateEnchere(enchere);
    }

    @Override
    public Enchere getEnchereMax(Article article) {return enchereDao.getHighestEnchere(article);
    }


}
