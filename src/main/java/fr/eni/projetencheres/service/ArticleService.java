package fr.eni.projetencheres.service;

import fr.eni.projetencheres.bo.Article;

import java.util.List;

public interface ArticleService {

    List<Article> getAllArticles();

    void addArticle(Article article);

    Article getArticleById(long id);

    void deleteArticle(long id);

    void updateArticle(Article article);
}
