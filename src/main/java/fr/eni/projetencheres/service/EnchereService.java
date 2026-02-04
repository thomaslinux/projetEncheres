package fr.eni.projetencheres.service;

import fr.eni.projetencheres.bo.Enchere;
import fr.eni.projetencheres.bo.Utilisateur;

import java.util.List;

public interface EnchereService {

        public List<Enchere> getAllEncheres();

        void addEnchere(Enchere enchere);

        Enchere getEnchereById(long id);

        Enchere getEnchereByUtilisateur(Utilisateur enchereur);

        void deleteEnchere(long id);

        void updateEnchere(Enchere enchere);
}
