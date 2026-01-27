package fr.eni.projetencheres;

import fr.eni.projetencheres.bo.Article;
import fr.eni.projetencheres.repository.ArticleDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
@SpringBootTest
public class ArticlesTest {

    @Autowired
    ArticleDao articleDao;

    @Test
    void selectAll() {
       System.out.println(articleDao.readArticles());
    }

    @Test
    void addUpdateDelete() {
        LocalDate debut = LocalDate.of(2026,1,15);
        LocalDate fin = LocalDate.of(2026,1,27);
        Article art = new Article("Ours en peluche", "C'est un ours en peluche", debut, fin, 10, 15, false, null);
        articleDao.addArticle(art);
        System.out.println(articleDao.readArticles());
        Article art2 = new Article("Ours en peluche MIEUX", "C'est un ours en peluche MIEUX", debut, fin, 10, 1500, false, null);
    }
}
