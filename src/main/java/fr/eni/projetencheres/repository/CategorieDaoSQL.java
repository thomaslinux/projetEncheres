package fr.eni.projetencheres.repository;

import fr.eni.projetencheres.bo.Categorie;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("SQL")
public class CategorieDaoSQL implements CategorieDao{

    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CategorieDaoSQL(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Categorie> readCategories() {
        String sql = """
                select * from Categorie
                """;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Categorie.class));
    }

    @Override
    public void addCategorie(Categorie categorie) {
        // recupere ID SQL de categorie, une fois categorie inserted dans la table sql
        GeneratedKeyHolder kh = new GeneratedKeyHolder();
        String sql = "insert into [Categorie] (libelle) values (:libelle)";

        BeanPropertySqlParameterSource map = new BeanPropertySqlParameterSource(categorie);

        namedParameterJdbcTemplate.update(sql, map, kh);

        //récupération de l'id
        categorie.setId_categorie(kh.getKey().longValue());
    }

    @Override
    public Categorie getCategorie(long id) {
        String sql = "select * from [Categorie] where id_categorie =:id";

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id_categorie", id);

        return namedParameterJdbcTemplate.queryForObject(sql,map, new BeanPropertyRowMapper<>(Categorie.class));
    }

    @Override
    public void deleteCategorie(long id) {
        String sql = "delete from [Categorie] where id_categorie =:id";

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id_categorie", id);

        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void updateCategorie(Categorie categorie) {
        String sql = """
                update [Categorie] set  libelle = :libelle where id_categorie =:id
                """;
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id_categorie", categorie.getId_categorie());
        map.addValue("libelle", categorie.getLibelle());

        namedParameterJdbcTemplate.update(sql, map);
    }
}
