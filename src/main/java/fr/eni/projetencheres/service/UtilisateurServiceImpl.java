package fr.eni.projetencheres.service;

import fr.eni.projetencheres.bo.Utilisateur;
import fr.eni.projetencheres.repository.UtilisateurDao;
import fr.eni.projetencheres.service.exception.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    UtilisateurDao utilisateurDao;

    public UtilisateurServiceImpl(UtilisateurDao utilisateurDao) {
        this.utilisateurDao = utilisateurDao;
    }

    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        return this.utilisateurDao.readUtilisateurs();
    }

    @Override
    public void addUtilisateur(Utilisateur utilisateur) throws ServiceException {

        if (utilisateurDao.getUtilisateurByUsername(utilisateur.getPseudo()) != null) {
            throw new ServiceException("Ce pseudo est déjà utilisé !");
        }
        this.utilisateurDao.addUtilisateur(utilisateur);
        this.utilisateurDao.addRoleToUtilisateur(utilisateur);
    }

    @Override
    public Utilisateur getUtilisateurById(long id) {
        return this.utilisateurDao.getUtilisateurByID(id);
    }

    @Override
    public void deleteUtilisateur(long id) {
        this.utilisateurDao.deleteUtilisateur(id);
    }

    @Override
    public void updateUtilisateur(Utilisateur utilisateur) {
        this.utilisateurDao.updateUtilisateur(utilisateur);
    }
}
