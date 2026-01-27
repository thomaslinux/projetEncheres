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
    void SelectAll() {
        System.out.println(articleDao.readArticles());
    }

    @Test
    void addArticle() {

    }
}
