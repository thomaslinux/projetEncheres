package fr.eni.projetencheres;

import fr.eni.projetencheres.service.UtilisateurService;
import fr.eni.projetencheres.bo.Utilisateur;
import fr.eni.projetencheres.repository.UtilisateurDao;
import fr.eni.projetencheres.service.exception.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UtilisateurTests {

    @Autowired
    UtilisateurService utilisateurService;

    @Autowired
    UtilisateurDao utilisateurDao;

    @Test
    void addUtilisateur() {
        Utilisateur NEWjeanMich = new Utilisateur("jeanMichExceptionnel", "Jean-Michel-Exception", "Excepichon", "jmexception@mail.com", "JEANMICH", "06 66 66 66 66", "rue de la ville", "44444", "Ville", 0, false, true);
        try {
            utilisateurService.addUtilisateur(NEWjeanMich);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
        System.out.println(utilisateurDao.readUtilisateurs());
    }
//    @Test
//    void addUtilisateurADMIN() {
//        Utilisateur admin = new Utilisateur("Admin", "Min", "Add", "admin@admin.com", "ADmin", "01 04 14 09 15", "'1 rue des Admins", "14495", "AdminVille", 100, true, true);
//        try {
//            utilisateurService.addUtilisateur(admin);
//        } catch (ServiceException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(utilisateurDao.readUtilisateurs());
//    }

    @Test
    void testUpdate() {

        Utilisateur jeanMich = new Utilisateur("jeanMich", "Pichon", "Jean-Michel", "jeanmichelpichon@mail.com", "JEANMICH", "06 66 66 66 66", "rue de la ville", "44444", "Ville", 0, false, true);
        System.out.println("Avant update :");
        utilisateurDao.addUtilisateur(jeanMich);
        System.out.println(utilisateurDao.readUtilisateurs());
        utilisateurDao.updateUtilisateur(new Utilisateur(jeanMich.getId_utilisateur(), "jeanMich2", "Pichon2", "Jean-Michel2", "jmpichon2@mail.com", "JEANMICH", "06 66 66 66 66", "rue de la ville", "44444", "Ville", 0, false, true));
        System.out.println(utilisateurDao.readUtilisateurs());

    }


    @Test
    void testServiceAll() {
        Utilisateur jeanneMich = new Utilisateur("jeanneMich", "Pichonne", "Jeanne-Michelle", "jmpichonne@mail.com", "JEANMICH", "06 66 66 66 66", "rue de la ville", "44444", "Ville", 0, false, true);
        try {
            utilisateurService.addUtilisateur(jeanneMich);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
        System.out.println(utilisateurService.getAllUtilisateurs());
        System.out.println("Update :");
        Utilisateur jeanneMich2 = new Utilisateur(jeanneMich.getId_utilisateur(), "jeanneMichelledu44", "Pichonne", "Jeanne-Michelle44", "jmpichonne44@mail.com", "JEANMICH", "06 66 66 66 66", "rue de la ville", "44444", "Ville", 0, false, true);
        utilisateurService.updateUtilisateur(jeanneMich2);
        System.out.println(utilisateurService.getAllUtilisateurs());
        System.out.println("1 Utilisateur (get by ID) :");
        System.out.println(utilisateurService.getUtilisateurById(jeanneMich2.getId_utilisateur()));
        System.out.println("Delete :");
        utilisateurService.deleteUtilisateur(jeanneMich2.getId_utilisateur());
        System.out.println(utilisateurService.getAllUtilisateurs());
    }

    @Test
    void testRoles() {
        Utilisateur jeanMich = new Utilisateur("Megatron", "Jean-Megatron", "Pichatron", "jmpichatron@mail.com", "JEANMICH", "06 66 66 66 66", "12 rue de la ville", "44444", "Ville", 0, false, true);
        try {
            utilisateurService.addUtilisateur(jeanMich);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
        System.out.println(utilisateurService.getAllUtilisateurs());
    }
}