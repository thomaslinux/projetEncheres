package fr.eni.projetencheres.repository.rowmapper;

import fr.eni.projetencheres.bo.Article;
import fr.eni.projetencheres.bo.Categorie;
import fr.eni.projetencheres.bo.Retrait;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RetraitRowMapper implements RowMapper<Retrait> {

    @Override
    public Retrait mapRow(ResultSet rs, int rowNum) throws SQLException {
        Retrait retraitResult = new Retrait();
        retraitResult.setId_retrait(rs.getLong("id_retrait"));

        long idArticle = rs.getLong("id_article");
        if (idArticle>0) {
            Article article = new Article();
            article.setId_article(rs.getLong("id_article"));
            article.setNom_article(rs.getString("nom_article"));

            retraitResult.setArticle(article);
        }
        return retraitResult;
    }
}
