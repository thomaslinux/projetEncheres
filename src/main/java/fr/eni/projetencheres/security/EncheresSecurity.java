package fr.eni.projetencheres.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class EncheresSecurity {

//    Configuration de l'utilisation de la base de données pour se connecter
//    À ne pas changer !
    @Bean
    UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbc = new JdbcUserDetailsManager(dataSource);
        //Détermine quelle information utiliser pour la connexion.

        //Requête utilisée pour l'utilisateur :
        jdbc.setUsersByUsernameQuery("SELECT pseudo, password, actif FROM utilisateur WHERE pseudo = ?");
        //Requête utilisée pour le rôle :
        jdbc.setAuthoritiesByUsernameQuery("SELECT pseudo, role FROM roles WHERE pseudo = ?");

        return jdbc;
    }

    //Mise en place de la gestion des droits en fonction des pages affichées :
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //C'est ici que l'on va définir les chemins autorisés en fonction des utilisateurs
        http.authorizeHttpRequests(auth -> {
            //autorise l'accès à la liste des enchères à tous les employés
            //Accès du chemin /encheres en Get pour les employés
            //A SUPPRIMER : anyRequest().permitAll() <- pour travailler sur le site, mais pas sécurisé !
            auth.anyRequest().permitAll();
//                requestMatchers(HttpMethod.GET, "/encheres/add").hasRole("ADMIN")
//
//
//            //donne à tous la permission sur la page d'accueil et tous les liens de type /quelquechose
//                    .requestMatchers("/*").permitAll()
//                    .requestMatchers("/encheres").permitAll()
//                    //donner acces au css
//                    .requestMatchers("/css/*").permitAll()
//                    //donner acces au image
//                    .requestMatchers("/image/*").permitAll()
//                    //tous ce qui n'est pas spécifié n'est pas accessible
//                    .anyRequest().denyAll();
        });
        return http.build();
    }


}

