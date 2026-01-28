package fr.eni.projetencheres.repository;

import fr.eni.projetencheres.bo.Utilisateur;

import java.util.List;

public interface UtilisateurDao {
    public List<Utilisateur> readUtilisateurs();

    void addUtilisateur(Utilisateur utilisateur);

    void addRoleToUtilisateur(Utilisateur utilisateur);

    Utilisateur getUtilisateurByID(long id_utilisateur);

    Utilisateur getUtilisateurByUsername(String pseudo);

    Utilisateur getUtilisateurByEmail(String email);

    Utilisateur getUtilisateurByPseudo(String pseudo);

    void deleteUtilisateur(long id_utilisateur);

    void updateUtilisateur(Utilisateur utilisateur);
}
