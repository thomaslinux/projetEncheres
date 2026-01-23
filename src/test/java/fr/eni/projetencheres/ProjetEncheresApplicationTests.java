package fr.eni.projetencheres;

import fr.eni.projetencheres.repository.CategorieDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjetEncheresApplicationTests {

    @Autowired
    CategorieDao categorieDao;

    @Test
    void testRepositoryReadAllCategorie() {
        categorieDao.readCategories().forEach(System.out::println);
    }

}
