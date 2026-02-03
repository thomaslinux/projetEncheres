package fr.eni.projetencheres;


import fr.eni.projetencheres.bo.Article;
import fr.eni.projetencheres.bo.Categorie;
import fr.eni.projetencheres.bo.Retrait;
import fr.eni.projetencheres.repository.RetraitDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class RetraitTest {

    @Autowired
    RetraitDao retraitDao;

    @Test
    void seeAndAddRetrait() {
        Categorie truc = new Categorie("Bidule");
        Article bidule = new Article("trucmuche", "C'est un truc", LocalDate.of(1999, 12,24), LocalDate.now(), 100, 500, true, truc, null);
        Retrait test = new Retrait("12 rue de la ville", LocalDate.now(), "55555", "Villeville", bidule);
        retraitDao.addRetrait(test);
        System.out.println(retraitDao.readRetraits());
    }

    /*
    @Test
    void updateAndDelete() {
        Categorie truc = new Categorie("Bidule");
        Article bidule = new Article("trucmuche", "C'est un truc", LocalDate.of(1999, 12,24), LocalDate.now(), 100, 500, true, truc);

        Retrait test = new Retrait("12 rue de la ville", LocalDate.now(), "55555", "Villeville", bidule);
        retraitDao.addRetrait(test);
        Retrait test2 = new Retrait(1, "21 rue du patelin", LocalDate.of(2080, 12, 24), "666666", "PatelinVille", bidule);
        System.out.println("Avant update :");
        System.out.println(retraitDao.readRetraits());
        retraitDao.updateRetrait(test2);
        System.out.println("Après update :");
        System.out.println(retraitDao.getRetrait(1));
        retraitDao.deleteRetrait(1);
        System.out.println("Après delete :");
        System.out.println(retraitDao.readRetraits());
    }
    */

}

