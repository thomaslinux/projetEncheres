package fr.eni.projetencheres.repository.rowmapper;

import fr.eni.projetencheres.bo.Article;
import fr.eni.projetencheres.bo.Categorie;
import fr.eni.projetencheres.bo.Enchere;
import fr.eni.projetencheres.bo.Utilisateur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EnchereRowMapper implements RowMapper<Enchere> {
    @Override
    public Enchere mapRow(ResultSet rs, int rowNum) throws SQLException {
        Enchere enchereResult = new Enchere();

        enchereResult.setId_enchere(rs.getLong("id_enchere"));

        long idArticle = rs.getLong("id_article");
        if (idArticle >0) {
            Article article = new Article();
            article.setId_article(idArticle);

            enchereResult.setArticle(article);
        }
        long idUtilisateur = rs.getLong("id_utilisateur");
        if (idUtilisateur>0) {
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setId_utilisateur(idUtilisateur);

            enchereResult.setUtilisateur(utilisateur);
        }
    return enchereResult;
    }
}

