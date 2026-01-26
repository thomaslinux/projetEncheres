package fr.eni.projetencheres;

import fr.eni.projetencheres.bo.Categorie;
import fr.eni.projetencheres.repository.CategorieDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategorieDaoTests {
    @Autowired
    CategorieDao categorieDao;

    @Test
    void testReadCategorie() {
        categorieDao.readCategories().forEach(System.out::println);
    }

    @Test
    void testAddCategorie() {
        Categorie categorie = new Categorie(1,"Ordinateur");
        categorieDao.addCategorie(categorie);
        System.out.println(categorie);
    }

    @Test
    void testDeleteCategorie() {
//        Categorie categorie = new Categorie(1,"Ordinateur");
//        categorieDao.addCategorie(categorie);
//        System.out.println("Categorie list before delete");
//        categorieDao.readCategories().forEach(System.out::println);
        categorieDao.deleteCategorie(1);
        System.out.println("Categorie list after delete");
        categorieDao.readCategories().forEach(System.out::println);
    }
}
