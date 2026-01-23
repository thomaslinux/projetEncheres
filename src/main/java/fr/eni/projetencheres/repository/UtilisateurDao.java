package fr.eni.projetencheres.repository;

import fr.eni.projetencheres.bo.Utilisateur;

import java.util.List;

public interface UtilisateurDao {
    public List<Utilisateur> readUtilisateurs();

    void addUtilisateur(Utilisateur utilisateur);

    Utilisateur getUtilisateur(long id);

    void deleteUtilisateur(long id);

    void updateUtilisateur(Utilisateur utilisateur);
}
