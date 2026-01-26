package fr.eni.projetencheres.Service;

import fr.eni.projetencheres.bo.Utilisateur;

import java.util.List;

public interface UtilisateurService {

        List<Utilisateur> getAllUtilisateurs();

        void addUtilisateur(Utilisateur utilisateur);

        Utilisateur getUtilisateurById(long id);

        void deleteUtilisateur(long id);

        void updateUtilisateur(Utilisateur utilisateur);

}
