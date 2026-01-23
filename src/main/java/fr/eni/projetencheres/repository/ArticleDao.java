package fr.eni.projetencheres.repository;

public interface ArticleDao {
    public List<Article> readArticles();

    void addArticle(Article article);

    Article getArticle(long id);

    void deleteArticle(long id);

    void updateArticle(Article article);
}
