package fr.eni.projetencheres;

import fr.eni.projetencheres.service.UtilisateurService;
import fr.eni.projetencheres.bo.Utilisateur;
import fr.eni.projetencheres.repository.UtilisateurDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UtilisateurTests {

    @Autowired
    UtilisateurService utilisateurService;

    @Autowired
    UtilisateurDao utilisateurDao;

    // TODO implémenter la gestion de UNIQUE sur pseudo pour éviter les duplications de pseudo et gérer la restriction côté SQL

    @Test
    void addUtilisateur() {
        Utilisateur jeanMich = new Utilisateur("jeanMich", "Jean-Michel", "Cherel", "jmcherel@mail.com", "JEANMICH", "06 66 66 66 66", "rue de la ville", "44444", "Ville", 0, false, true);
        utilisateurDao.addUtilisateur(jeanMich);
        System.out.println(utilisateurDao.readUtilisateurs());
    }

    @Test
    void getUtilisateurById() {
        System.out.println(utilisateurDao.getUtilisateur(2));
    }

    @Test
    void getUtilisateurByPseudo()
    {
        System.out.println(utilisateurDao.getUtilisateurByPseudo("jeanMich"));
    }

    @Test
    void getUtilisateurByEmail() {
        System.out.println(utilisateurDao.getUtilisateurByEmail("jmcherel@mail.com"));
    }

    @Test
    void deleteUtilisateur() {
        System.out.println("Avant suppression :");
        System.out.println(utilisateurDao.readUtilisateurs());
        utilisateurDao.deleteUtilisateur(2);
        System.out.println("Après suppression :");
        System.out.println(utilisateurDao.readUtilisateurs());
    }

    @Test
    void testUpdate() {

        Utilisateur jeanMich = new Utilisateur("jeanMich", "Jean-Michel", "Pichon", "jmpichon@mail.com", "JEANMICH", "06 66 66 66 66", "rue de la ville", "44444", "Ville", 0, false, true);
        System.out.println("Avant update :");
        utilisateurDao.addUtilisateur(jeanMich);
        System.out.println(utilisateurDao.readUtilisateurs());
        utilisateurDao.updateUtilisateur(new Utilisateur(8, "jeanMich2", "Jean-Michel2", "Pichon2", "jmpichon2@mail.com", "JEANMICH", "06 66 66 66 66", "rue de la ville", "44444", "Ville", 0, false, true));
        System.out.println(utilisateurDao.readUtilisateurs());

    }


    @Test
    void testServiceAll() {
        Utilisateur jeanMich = new Utilisateur("jeanMich", "Jean-Michel", "Pichon", "jmpichon@mail.com", "JEANMICH", "06 66 66 66 66", "rue de la ville", "44444", "Ville", 0, false, true);
        utilisateurService.addUtilisateur(jeanMich);
        System.out.println(utilisateurService.getAllUtilisateurs());
        System.out.println("Update :");
        Utilisateur jeanMich2 = new Utilisateur(1, "jeanMich2", "Jean-Michel2", "Pichon2", "jmpichon2@mail.com", "JEANMICH", "06 66 66 66 66", "rue de la ville", "44444", "Ville", 0, false, true);
        utilisateurService.updateUtilisateur(jeanMich2);
        System.out.println(utilisateurService.getAllUtilisateurs());
        System.out.println("Delete :");
        utilisateurService.deleteUtilisateur(1);
        System.out.println(utilisateurService.getAllUtilisateurs());
        System.out.println("1 Utilisateur (get by ID) :");
        System.out.println(utilisateurService.getUtilisateurById(2));
    }

    @Test
    void testRoles() {
        Utilisateur jeanMich = new Utilisateur("jeanMich", "Jean-Michel", "Pichon", "jmpichon@mail.com", "JEANMICH", "06 66 66 66 66", "12 rue de la ville", "44444", "Ville", 0, false, true);
        utilisateurService.addUtilisateur(jeanMich);
        System.out.println(utilisateurService.getAllUtilisateurs());
    }
}
