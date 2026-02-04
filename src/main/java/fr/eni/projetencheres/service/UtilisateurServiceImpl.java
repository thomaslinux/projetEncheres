package fr.eni.projetencheres.service;

import fr.eni.projetencheres.bo.Utilisateur;
import fr.eni.projetencheres.repository.UtilisateurDao;
import fr.eni.projetencheres.service.exception.ServiceException;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    UtilisateurDao utilisateurDao;
    PasswordEncoder passwordEncoder;

    public UtilisateurServiceImpl(UtilisateurDao utilisateurDao, PasswordEncoder passwordEncoder) {
        this.utilisateurDao = utilisateurDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        return this.utilisateurDao.readUtilisateurs();
    }

    @Override
    public void addUtilisateur(Utilisateur utilisateur) throws ServiceException {

        if (utilisateurDao.getUtilisateurByPseudo(utilisateur.getPseudo()) != null) {
            throw new ServiceException("Ce pseudo est déjà utilisé !");
        }
        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
        this.utilisateurDao.addUtilisateur(utilisateur);
        this.utilisateurDao.addRoleToUtilisateur(utilisateur);
    }

    @Override
    public Utilisateur getUtilisateurById(long id) {
        return this.utilisateurDao.getUtilisateurByID(id);
    }

    @Override
    public Utilisateur getUtilisateurByUsername(String username) {
        return this.utilisateurDao.getUtilisateurByPseudo(username);
    }

    @Override
    public Utilisateur getUtilisateurByEmail(String email) {
        return this.utilisateurDao.getUtilisateurByEmail(email);
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
