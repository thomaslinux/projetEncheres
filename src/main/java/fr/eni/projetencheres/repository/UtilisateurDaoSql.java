package fr.eni.projetencheres.repository;

import fr.eni.projetencheres.bo.Utilisateur;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UtilisateurDaoSql implements UtilisateurDao {
    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UtilisateurDaoSql(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Utilisateur> readUtilisateurs() {
        String sql = "SELECT * FROM UTILISATEUR";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Utilisateur.class));
    }

    @Override
    public void addUtilisateur(Utilisateur utilisateur) {
        GeneratedKeyHolder kh = new GeneratedKeyHolder();
        String sql = "INSERT INTO UTILISATEUR(pseudo, nom, prenom, email, password, telephone, adresse, code_postal, ville, credit, administrateur, actif) " +
                     "VALUES (:pseudo, :nom, :prenom, :email, :password, :telephone, :adresse, :code_postal, :ville, :credit, :administrateur, :actif)";

        BeanPropertySqlParameterSource map = new BeanPropertySqlParameterSource(utilisateur);

        namedParameterJdbcTemplate.update(sql, map, kh);
        utilisateur.setId_utilisateur(kh.getKey().longValue());
    }

    @Override
    public void addRoleToUtilisateur(Utilisateur utilisateur) {
        GeneratedKeyHolder kh = new GeneratedKeyHolder();
        String sql = "INSERT INTO ROLE(role, pseudo) VALUES (:role, :pseudo)";

        MapSqlParameterSource map = new MapSqlParameterSource();

        if (utilisateur.isAdministrateur()) {
            map.addValue("role", "ROLE_ADMIN");
        } else {
            map.addValue("role", "ROLE_UTILISATEUR");
        }
        map.addValue("pseudo", utilisateur.getPseudo());

        namedParameterJdbcTemplate.update(sql, map, kh);


    }

    @Override
    public Utilisateur getUtilisateur(long id_utilisateur) {
        String sql = "SELECT * FROM UTILISATEUR WHERE id_utilisateur = :id_utilisateur";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id_utilisateur", id_utilisateur);
        return namedParameterJdbcTemplate.queryForObject(sql, map, new BeanPropertyRowMapper<>(Utilisateur.class));
    }

    @Override
    public void deleteUtilisateur(long id_utilisateur) {
        String sql = "DELETE FROM UTILISATEUR WHERE id_utilisateur = :id_utilisateur";

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id_utilisateur", id_utilisateur);

        namedParameterJdbcTemplate.update(sql, map);

    }

    @Override
    public void updateUtilisateur(Utilisateur utilisateur) {
        String sql = "UPDATE UTILISATEUR SET pseudo = :pseudo, nom = :nom, prenom = :prenom, " +
                "email = :email, password = :password, telephone = :telephone, adresse = :adresse, " +
                "code_postal = :code_postal, ville = :ville WHERE id_utilisateur = :id_utilisateur";

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("pseudo", utilisateur.getPseudo());
        map.addValue("nom", utilisateur.getNom());
        map.addValue("prenom", utilisateur.getPrenom());
        map.addValue("email", utilisateur.getEmail());
        map.addValue("password", utilisateur.getPassword());
        map.addValue("telephone", utilisateur.getTelephone());
        map.addValue("adresse", utilisateur.getAdresse());
        map.addValue("code_postal", utilisateur.getCode_postal());
        map.addValue("ville", utilisateur.getVille());
        map.addValue("id_utilisateur", utilisateur.getId_utilisateur());

        namedParameterJdbcTemplate.update(sql, map);
    }
}
