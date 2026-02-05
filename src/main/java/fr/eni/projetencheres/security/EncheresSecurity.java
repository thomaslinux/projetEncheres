package fr.eni.projetencheres.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.sql.DataSource;

@Configuration
public class EncheresSecurity {


    @Bean
    public PasswordEncoder PasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    Configuration de l'utilisation de la base de données pour se connecter
//    À ne pas changer !
    @Bean
    UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbc = new JdbcUserDetailsManager(dataSource);
        //Détermine quelle information utiliser pour la connexion.
        //Requête utilisée pour l'utilisateur :
        jdbc.setUsersByUsernameQuery("SELECT pseudo, password, actif FROM UTILISATEUR WHERE pseudo = ?");

        //Requête utilisée pour le rôle :
        jdbc.setAuthoritiesByUsernameQuery("SELECT pseudo, role FROM ROLE WHERE pseudo = ?");

        return jdbc;
    }

    //Mise en place de la gestion des droits en fonction des pages affichées :
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //C'est ici que l'on va définir les chemins autorisés en fonction des utilisateurs
        http.authorizeHttpRequests(auth -> {

            //À SUPPRIMER : anyRequest().permitAll() <- pour travailler sur le site, mais pas sécurisé !
            auth.


                    requestMatchers(HttpMethod.GET, "/encheres/*").hasRole("UTILISATEUR")
                    .requestMatchers(HttpMethod.POST, "/encheres/*").hasRole("UTILISATEUR")

            //donne à tous la permission sur la page d'encheres et tous les liens de type /quelquechose
                    .requestMatchers("/*").permitAll()
                    .requestMatchers("/encheres").permitAll()
                    .requestMatchers("/encheres/search").permitAll()
                    //donne accès au css
                    .requestMatchers("/css/*").permitAll()
                    //donne accès aux images
                    .requestMatchers("/images/*").permitAll()

                    //Admin a tous les droits :

                    //tous ce qui n'est pas spécifié n'est pas accessible
                    .anyRequest().denyAll();
        });

        /*** pas touche *****/
        //Gestion du login
        http.formLogin( form -> {
                    //Page login accessible à tous :
                    form.loginPage("/login")
                            .permitAll()
                            .failureUrl("/login?error=true");
                    //redirige après le login sur la page d'accueil
                    form.defaultSuccessUrl("/encheres");
                }
        );

        http.logout( logout -> {
            //supprime la session du côté du serveur d'application
            logout.invalidateHttpSession(true)
                    .clearAuthentication(true)
                    //suppression du cookie sur le serveur web
                    .deleteCookies("JSESSIONID")
                    //déterminer la page à utiliser pour le logout
                    .logoutUrl("/logout")
                    //redirige après le logout sur la page d'accueil
                    .logoutSuccessUrl("/encheres")
                    .permitAll();
        });

        return http.build();
    }

}