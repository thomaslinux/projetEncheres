package fr.eni.projetencheres;

import fr.eni.projetencheres.bo.Article;
import fr.eni.projetencheres.bo.Categorie;
import fr.eni.projetencheres.repository.ArticleDao;
import fr.eni.projetencheres.repository.CategorieDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
@SpringBootTest
public class ArticlesTest {

    @Autowired
    ArticleDao articleDao;

    @Autowired
    CategorieDao categorieDao;

    @Test
    void selectAll() {
       System.out.println(articleDao.readArticles());
    }

    @Test
    void addUpdateDelete() {
        LocalDate debut = LocalDate.of(2026,1,15);
        LocalDate fin = LocalDate.of(2026,1,27);
        Categorie jouet = new Categorie("Jouet");
        categorieDao.addCategorie(jouet);
        Article art = new Article("Ours en peluche", "C'est un ours en peluche", debut, fin, 10, 15, false, jouet);
        articleDao.addArticle(art);
        System.out.println(articleDao.readArticles());
//        Article art2 = new Article(1, "Ours en peluche MIEUX", "C'est un ours en peluche MIEUX", debut, fin, 10, 1500, false, null);
//        articleDao.updateArticle(art2);
//        System.out.println("Après update :");
//        System.out.println(articleDao.readArticles());
//        articleDao.deleteArticle(1);
//        System.out.println("Après delete :");
//        System.out.println(articleDao.readArticles());
    }
}
