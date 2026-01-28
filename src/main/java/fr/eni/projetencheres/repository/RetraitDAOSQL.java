package fr.eni.projetencheres.repository;

import fr.eni.projetencheres.bo.Retrait;
import fr.eni.projetencheres.bo.Utilisateur;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RetraitDAOSQL implements RetraitDao {

    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public RetraitDAOSQL(NamedParameterJdbcTemplate namedParameterJdbcTemplate, JdbcTemplate jdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Retrait> readRetraits() {
        String sql = "SELECT * FROM RETRAIT";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Retrait.class));
    }

    @Override
    public void addRetrait(Retrait retrait) {
        GeneratedKeyHolder kh = new GeneratedKeyHolder();
        String sql = "INSERT INTO RETRAIT(adresse, code_postal, ville, id_article) " +
                "VALUES (:adresse, :code_postal, :ville, :id_article)";

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("adresse", retrait.getAdresse());
        map.addValue("code_postal", retrait.getCode_postal());
        map.addValue("ville", retrait.getVille());
        map.addValue("id_article", retrait.getArticle().getId_article());

        namedParameterJdbcTemplate.update(sql, map, kh);
    }

    @Override
    public Retrait getRetrait(long id_retrait) {
        String sql = "SELECT * FROM RETRAIT WHERE id_retrait = :id_retrait";

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id_retrait", id_retrait);
        return namedParameterJdbcTemplate.queryForObject(sql, map, new BeanPropertyRowMapper<>(Retrait.class));
    }

    @Override
    public void deleteRetrait(long id_retrait) {
        String sql = "DELETE FROM RETRAIT WHERE id_retrait = :id_retrait";

        MapSqlParameterSource map = new MapSqlParameterSource();

        map.addValue("id_retrait", id_retrait);

        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void updateRetrait(Retrait retrait) {
        String sql = "UPDATE RETRAIT SET adresse = :adresse, code_postal = :code_postal, ville = :ville, id_article = :id_article";

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("adresse", retrait.getAdresse());
        map.addValue("code_postal", retrait.getCode_postal());
        map.addValue("ville", retrait.getVille());
        map.addValue("id_article", retrait.getArticle().getId_article());

        namedParameterJdbcTemplate.update(sql, map);
    }
}
