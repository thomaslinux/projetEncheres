package fr.eni.projetencheres.service;

import fr.eni.projetencheres.bo.Article;
import fr.eni.projetencheres.repository.ArticleDao;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    ArticleDao articleDao;

    public ArticleServiceImpl(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @Override
    public List<Article> getAllArticles() {
        return articleDao.readArticles();
    }

    @Override
    public void addArticle(Article article) {
        articleDao.addArticle(article);
    }

    @Override
    public Article getArticleById(long id) {
        return articleDao.getArticle(id);
    }

    @Override
    public void deleteArticle(long id) {
        articleDao.deleteArticle(id);
    }

    @Override
    public void updateArticle(Article article) {
        articleDao.updateArticle(article);
    }
}
