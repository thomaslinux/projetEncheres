package fr.eni.projetencheres.repository;

import fr.eni.projetencheres.bo.Enchere;
import fr.eni.projetencheres.bo.Utilisateur;

import java.util.List;

public interface EnchereDao {
    public List<Enchere> readEncheres();

    void addEnchere(Enchere enchere);

    Enchere getEnchere(long id);

    Enchere getEnchereByUser(Utilisateur utilisateur);

    void deleteEnchere(long id);

    void updateEnchere(Enchere enchere);
}
