package fr.eni.projetencheres.repository;

import fr.eni.projetencheres.bo.Enchere;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

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

    // TODO
    @Override
    public void addEnchere(Enchere enchere) {
//        // recupere ID SQL de enchere, une fois enchere inserted dans la table sql
//        GeneratedKeyHolder kh = new GeneratedKeyHolder();
////        String sql = "insert into [Enchere] (libelle) values (:libelle)";
//
//        BeanPropertySqlParameterSource map = new BeanPropertySqlParameterSource(enchere);
//
//        namedParameterJdbcTemplate.update(sql, map, kh);
//
//        //récupération de l'id
//        enchere.setId(kh.getKey().longValue());
  }

    @Override
    public Enchere getEnchere(long id) {
        String sql = "select * from [Enchere] where id_enchere =:id";

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);

        return namedParameterJdbcTemplate.queryForObject(sql,map, new BeanPropertyRowMapper<>(Enchere.class));
    }

    // TODO
    @Override
    public void deleteEnchere(long id) {
//        String sql = "delete from [Enchere] where id_enchere =:id";
//
//        MapSqlParameterSource map = new MapSqlParameterSource();
//        map.addValue("id", id);
//
//        namedParameterJdbcTemplate.update(sql, map);
    }

    // TODO
    @Override
    public void updateEnchere(Enchere enchere) {
//        String sql = """
////                update [Enchere] set  libelle = :libelle where id_enchere =:id
//                """;
////        MapSqlParameterSource map = new MapSqlParameterSource();
////        map.addValue("id", enchere.getId_enchere());
////        map.addValue("libelle", enchere.getLibelle());
//
//        namedParameterJdbcTemplate.update(sql, map);
    }
}
