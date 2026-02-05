package fr.eni.projetencheres.repository.RowMapper;

import fr.eni.projetencheres.bo.Article;
import fr.eni.projetencheres.bo.Categorie;
import fr.eni.projetencheres.bo.Utilisateur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleRowMapper  implements RowMapper<Article> {
    @Override
    public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
        Article articleResult = new Article();

        articleResult.setId_article(rs.getLong("id_article"));
        articleResult.setNom_article(rs.getString("nom_article"));
        articleResult.setDescription(rs.getString("description"));
        if (rs.getDate("date_debut_enchere") != null) {
            articleResult.setDate_debut_enchere(rs.getDate("date_debut_enchere").toLocalDate());
        }

        if (rs.getDate("date_fin_enchere") != null) {
            articleResult.setDate_fin_enchere(rs.getDate("date_fin_enchere").toLocalDate());
        }

        articleResult.setPrix_de_base(rs.getInt("prix_de_base"));

        long idCat = rs.getLong("id_categorie");
        if (idCat> 0) {
            //on crée le type si il y a une id_type
            Categorie categorie = new Categorie();
            categorie.setId_categorie(idCat);
            categorie.setLibelle(rs.getString("libelle"));

            articleResult.setCategorie(categorie);
        }

        articleResult.setImage_lien(rs.getString("image_lien"));

        return articleResult;
    }
}