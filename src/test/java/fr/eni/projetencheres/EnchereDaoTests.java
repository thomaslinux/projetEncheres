package fr.eni.projetencheres;

import fr.eni.projetencheres.bo.Article;
import fr.eni.projetencheres.bo.Categorie;
import fr.eni.projetencheres.bo.Enchere;
import fr.eni.projetencheres.bo.Utilisateur;
import fr.eni.projetencheres.repository.CategorieDao;
import fr.eni.projetencheres.repository.EnchereDao;
import fr.eni.projetencheres.repository.UtilisateurDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class EnchereDaoTests {

    @Autowired
    EnchereDao enchereDao;

    @Test
    void testReadEnchere() {
        enchereDao.readEncheres().forEach(System.out::println);
    }

//    @Test
//    void testAddEnchere() {
////        Utilisateur utilisateur = new Utilisateur("thomaslinux","linux","thomas",
////                "thomaslinux@noreply.github.com","eafeafg465465!",
////                "0606060606","rue de la rue",
////                "35000","Rennes",699,false,true);
////        utilisateurDao.addUtilisateur(utilisateur);
////        Categorie categorie = new Categorie("Ordinateur");
////        Article article = new Article("nom_article","description",
////                LocalDate.of(2011,11,30),
////                LocalDate.of(2012,12,29),
////                99,110,true,categorie);
////        Enchere enchere = new Enchere(
////                LocalDate.of(2012,12,31)
////                ,299,utilisateur,article
////        );
////        enchereDao.addEnchere(enchere);
////        System.out.println(enchere);
//    }

//    @Test
//    void testDeleteEnchere() {
////        Enchere enchere = new Enchere("Tableau");
////        enchereDao.addEnchere(enchere);
////        enchereDao.deleteEnchere(enchere.getId_enchere());
////        System.out.println("Enchere list after delete");
////        enchereDao.readEncheres().forEach(System.out::println);
//    }
//
//    @Test
//    void testUpdateEnchere() {
////        enchereDao.updateEnchere(new Enchere(1,"Informatique"));
//    }
}
