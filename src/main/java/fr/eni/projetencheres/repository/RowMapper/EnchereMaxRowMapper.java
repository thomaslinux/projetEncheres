package fr.eni.projetencheres.repository.RowMapper;

import fr.eni.projetencheres.bo.Enchere;
import fr.eni.projetencheres.bo.Utilisateur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EnchereMaxRowMapper implements RowMapper<Enchere> {
    @Override
    public Enchere mapRow(ResultSet rs, int rowNum) throws SQLException {
        Enchere enchereResult = new Enchere();

        enchereResult.setId_enchere(rs.getLong("id_enchere"));
        if (rs.getDate("date_enchere") != null) {
            enchereResult.setDate_enchere(rs.getDate("date_enchere").toLocalDate());
        }
        enchereResult.setMontant_enchere(rs.getInt("montant_enchere"));

        long idUtilisateur = rs.getLong( "id_utilisateur");

        if (idUtilisateur > 0) {
            Utilisateur util = new Utilisateur();
            util.setId_utilisateur(idUtilisateur);
            util.setPseudo(rs.getString("pseudo"));
            enchereResult.setUtilisateur(util);
        }

        return enchereResult;
    }
}
