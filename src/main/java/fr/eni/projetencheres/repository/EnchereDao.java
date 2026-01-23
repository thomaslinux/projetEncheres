package fr.eni.projetencheres.repository;

import fr.eni.projetencheres.bo.Enchere;

import java.util.List;

public interface EnchereDao {
    public List<Enchere> readEncheres();

    void addEnchere(Enchere enchere);

    Enchere getEnchere(long id);

    void deleteEnchere(long id);

    void updateEnchere(Enchere enchere);
}
