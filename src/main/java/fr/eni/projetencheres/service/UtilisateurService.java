package fr.eni.projetencheres.service;

import fr.eni.projetencheres.bo.Utilisateur;
import fr.eni.projetencheres.service.exception.ServiceException;

import java.util.List;

public interface UtilisateurService {

        List<Utilisateur> getAllUtilisateurs();

        void addUtilisateur(Utilisateur utilisateur) throws ServiceException;

        Utilisateur getUtilisateurById(long id);

        void deleteUtilisateur(long id);

        void updateUtilisateur(Utilisateur utilisateur);

}
