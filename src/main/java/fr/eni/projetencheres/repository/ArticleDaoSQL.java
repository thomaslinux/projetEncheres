package fr.eni.projetencheres.repository;

import fr.eni.projetencheres.bo.Article;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class ArticleDaoSQL implements ArticleDao {

    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ArticleDaoSQL(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Article> readArticles() {
        String sql = "SELECT * FROM ARTICLE";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Article.class));

    }

    @Override
    public void addArticle(Article article) {
        GeneratedKeyHolder kh = new GeneratedKeyHolder();
        String sql = "INSERT INTO ARTICLE(nom_article, description, date_debut_enchere, " +
                     "date_fin_enchere, prix_de_base, prix_de_vente, vente_en_cours, id_categorie) " +
                     "VALUES (:nom_article, :description, :date_debut_enchere, " +
                     ":date_fin_enchere, :prix_de_base, :prix_de_vente, :vente_en_cours, :id_categorie)";

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("nom_article", article.getNom_article());
        map.addValue("description", article.getDescription());
        map.addValue("date_debut_enchere", article.getDate_debut_enchere());
        map.addValue("date_fin_enchere", article.getDate_fin_enchere());
        map.addValue("prix_de_base", article.getPrix_de_base());
        map.addValue("prix_de_vente", article.getPrix_de_vente());
        map.addValue("vente_en_cours", article.isVente_en_cours());
        map.addValue("id_categorie", article.getCategorie().getId_categorie());

        namedParameterJdbcTemplate.update(sql, map, kh);

        //récupération de l'id
        article.setId_article(kh.getKey().longValue());
    }

    @Override
    public Article getArticle(long id_article) {
        String sql = "SELECT * FROM ARTICLE WHERE id_article = :id_article";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id_article", id_article);
        return namedParameterJdbcTemplate.queryForObject(sql, map, new BeanPropertyRowMapper<>(Article.class));
    }

    @Override
    public void deleteArticle(long id_article) {
        String sql = "DELETE FROM article WHERE id_article = :id_article";

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id_article", id_article);

        namedParameterJdbcTemplate.update(sql, map);

    }

    @Override
    public void updateArticle(Article article) {

        String sql ="UPDATE article SET nom_article = :nom_article, description = :description, date_debut_enchere = :date_debut_enchere, " +
                " date_fin_enchere = :date_fin_enchere, prix_de_base = :prix_de_base, prix_de_vente = :prix_de_vente, vente_en_cours = :vente_en_cours, " +
                " id_categorie = :id_categorie ";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("description", article.getDescription());
        map.addValue("date_debut_enchere", article.getDate_debut_enchere());
        map.addValue("date_fin_enchere", article.getDate_fin_enchere());
        map.addValue("prix_de_base", article.getPrix_de_base());
        map.addValue("prix_de_vente", article.getPrix_de_vente());
        map.addValue("nom_article", article.getNom_article());
        map.addValue("vente_en_cours", article.isVente_en_cours());
        map.addValue("id_categorie", article.getCategorie());

        namedParameterJdbcTemplate.update(sql, map);

    }

    public Date convertLocalDateToSQL(LocalDate javaDate) {
            return Optional.ofNullable(javaDate)
                    .map(Date::valueOf)
                    .orElse(null);
    }
}
