package fr.eni.projetencheres.Service;

import fr.eni.projetencheres.bo.Utilisateur;
import fr.eni.projetencheres.repository.UtilisateurDao;
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
    public void addUtilisateur(Utilisateur utilisateur) {
        this.utilisateurDao.addUtilisateur(utilisateur);
    }

    @Override
    public Utilisateur getUtilisateurById(long id) {
        return this.utilisateurDao.getUtilisateur(id);
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
