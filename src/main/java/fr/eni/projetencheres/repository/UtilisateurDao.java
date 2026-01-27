package fr.eni.projetencheres.repository;

import fr.eni.projetencheres.bo.Utilisateur;

import java.util.List;

public interface UtilisateurDao {
    public List<Utilisateur> readUtilisateurs();

    void addUtilisateur(Utilisateur utilisateur);

    void addRoleToUtilisateur(Utilisateur utilisateur);

    Utilisateur getUtilisateur(long id_utilisateur);

    void deleteUtilisateur(long id_utilisateur);

    void updateUtilisateur(Utilisateur utilisateur);
}
