package fr.eni.projetencheres.repository;

import fr.eni.projetencheres.bo.Article;

import java.util.List;

public interface ArticleDao {
    public List<Article> readArticles();

    void addArticle(Article article);

    Article getArticle(long id);

    void deleteArticle(long id);

    void updateArticle(Article article);

    public List<Article> searchArticles(String article_name);

    public List<Article> searchArticleConfigurable(String searchedTerm, String byCategorie, String byDescription);
}
