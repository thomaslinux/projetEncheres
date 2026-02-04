package fr.eni.projetencheres.repository;

import fr.eni.projetencheres.bo.Article;
import fr.eni.projetencheres.bo.Enchere;
import fr.eni.projetencheres.bo.Utilisateur;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class EnchereDaoSQL implements EnchereDao{

    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public EnchereDaoSQL(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Enchere> readEncheres() {
        String sql = """
                select * from Enchere
                """;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Enchere.class));
    }

    // TODO test
    @Override
    public void addEnchere(Enchere enchere) {
        // recupere ID SQL de enchere, une fois enchere inserted dans la table sql
        GeneratedKeyHolder kh = new GeneratedKeyHolder();
        String sql = """
                insert into [Enchere] (date_enchere,montant_enchere,id_utilisateur,id_article)
                values (:date_enchere,:montant_enchere,:id_utilisateur,:id_article)
                """;
        MapSqlParameterSource map = new MapSqlParameterSource();


        map.addValue("date_enchere", LocalDate.now());
        map.addValue("montant_enchere", enchere.getMontant_enchere());
        map.addValue("id_utilisateur", enchere.getUtilisateur().getId_utilisateur());
        map.addValue("id_article", enchere.getArticle().getId_article());

        namedParameterJdbcTemplate.update(sql, map, kh);

        //récupération de l'id
        enchere.setId_enchere(kh.getKey().longValue());
  }

    // TODO test
    @Override
    public Enchere getEnchere(long id) {
        String sql = "select * from [Enchere] where id_enchere =:id";

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);

        return namedParameterJdbcTemplate.queryForObject(sql,map, new BeanPropertyRowMapper<>(Enchere.class));
    }

    @Override
    public Enchere getEnchereByUser(Utilisateur utilisateur) {
        String sql = "select * from [Enchere] where id_utilisateur =:id_utilisateur";

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", utilisateur.getId_utilisateur());

        return namedParameterJdbcTemplate.queryForObject(sql,map, new BeanPropertyRowMapper<>(Enchere.class));
    }

    // TODO test
    @Override
    public void deleteEnchere(long id) {
        String sql = "delete from [Enchere] where id_enchere =:id";

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);

        namedParameterJdbcTemplate.update(sql, map);
    }

    // TODO test
    @Override
    public void updateEnchere(Enchere enchere) {
        String sql = """
                update [Enchere]
                set montant_enchere = :montant_enchere, 
                    date_enchere = :date_enchere,
                    id_utilisateur = :id_utilisateur,
                    id_article = :id_article
                where id_enchere = :id_enchere
                """;

        BeanPropertySqlParameterSource map = new BeanPropertySqlParameterSource(enchere);

        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public Enchere getHighestEnchere(Article article) {
        String sql = "SELECT MAX(montant_enchere) FROM ENCHERE INNER JOIN ARTICLE "
                + "ON ENCHERE.id_article = ARTICLE.id_article WHERE ENCHERE.id_article = :id_article";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id_article", article.getId_article());

        return namedParameterJdbcTemplate.queryForObject(sql, map, new BeanPropertyRowMapper<>(Enchere.class));
    }
}
