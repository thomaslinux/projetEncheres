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
        Categorie jouet = new Categorie("JOUET");
        categorieDao.addCategorie(jouet);
        Article art = new Article("Ours en peluche", "C'est un ours en peluche", debut, fin, 10, 15, false, jouet, null);
        articleDao.addArticle(art);
        System.out.println(articleDao.readArticles());
        Article art2 = new Article(art.getId_article(), "Ours en peluche 2", "C'est un autre ours en peluche", debut, fin, 15, 20, false, jouet, null);
        articleDao.updateArticle(art2);
        System.out.println(articleDao.readArticles());
    }

    @Test
    void ilEstPasNulMonGet() {
        LocalDate debut = LocalDate.of(2026,1,15);
        LocalDate fin = LocalDate.of(2026,1,27);
      //  Article art = new Article("Ours en peluche", "C'est un ours en peluche", debut, fin, 10, 15, false, categorieDao.getCategorie(2));
       // System.out.println(art.getCategorie());
    }
}
