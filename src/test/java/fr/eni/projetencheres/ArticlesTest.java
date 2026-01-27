package fr.eni.projetencheres;

import fr.eni.projetencheres.bo.Article;
import fr.eni.projetencheres.repository.ArticleDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class ArticlesTest {

    @Autowired
    ArticleDao articleDao;

    @Test
    void AddAndSelectAll() {
        Article art = new Article("Ours en peluche", "C'est un ours en peluche", LocalDate.now(), LocalDate.now(), 10, 15, false, null);
        articleDao.addArticle(art);
        System.out.println(articleDao.readArticles());
    }
}
