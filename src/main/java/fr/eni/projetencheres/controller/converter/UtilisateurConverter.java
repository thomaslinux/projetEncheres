package fr.eni.projetencheres.controller.converter;

import fr.eni.projetencheres.bo.Utilisateur;
import fr.eni.projetencheres.service.UtilisateurService;
import org.springframework.core.convert.converter.Converter;

public class UtilisateurConverter implements Converter<String, Utilisateur> {

    UtilisateurService utilisateurService;

    public UtilisateurConverter(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }


    @Override
    public Utilisateur convert(String idstring) {
        long id = Long.parseLong(idstring);
        return utilisateurService.getUtilisateurById(id);
    }
}
