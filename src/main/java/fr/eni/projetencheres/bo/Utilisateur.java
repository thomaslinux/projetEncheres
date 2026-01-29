package fr.eni.projetencheres.bo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.security.core.parameters.P;

public class Utilisateur {
    private long id_utilisateur;
    @NotBlank
    @Size(min = 3, max = 20)
    @Pattern(regexp = "[a-zA-Z0-9]+",message = "Que des chiffres et des lettres")
    private String pseudo;

    @NotBlank
    @Size(max = 50)
    @Pattern(regexp = "[a-zA-Z]+",message = "Que des lettres")
    private String nom;

    @NotBlank
    @Size(max = 50)
    @Pattern(regexp = "[a-zA-Z]+",message = "Que des lettres")
    private String prenom;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 255)
    private String password;

    @NotBlank
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,}$",message = "Entrez un numero valide")
    private String telephone;

    @NotBlank
    @Size(max = 255)
    @Pattern(regexp = "[a-z A-Z0-9]+",message = "Que des lettres chiffres et espaces")
    private String adresse;

    @NotBlank
    @Pattern(regexp = "^[0-9]{5}$",message = "Que 5 chiffres")
    private String code_postal; // French postal code format

    @NotBlank
    @Size(max = 255)
    @Pattern(regexp = "[a-z A-Z]+$",message = "Que des lettres ou espaces")
    private String ville;

    private int credit;
    private boolean administrateur;
    private boolean actif = true;

    public Utilisateur() {
    }

    public Utilisateur(long id_utilisateur, String pseudo, String nom, String prenom, String email, String password, String telephone, String adresse, String code_postal, String ville, int credit, boolean administrateur, boolean actif) {
        this.id_utilisateur = id_utilisateur;
        this.pseudo = pseudo;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
        this.adresse = adresse;
        this.code_postal = code_postal;
        this.ville = ville;
        this.credit = credit;
        this.administrateur = administrateur;
        this.actif = actif;
    }

    public Utilisateur(String pseudo, String nom, String prenom, String email, String password, String telephone, String adresse, String code_postal, String ville, int credit, boolean administrateur, boolean actif) {
        this.pseudo = pseudo;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
        this.adresse = adresse;
        this.code_postal = code_postal;
        this.ville = ville;
        this.credit = credit;
        this.administrateur = administrateur;
        this.actif = actif;
    }

    public long getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(long id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public boolean isAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(boolean administrateur) {
        this.administrateur = administrateur;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id_utilisateur=" + id_utilisateur +
                ", pseudo='" + pseudo + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", adresse='" + adresse + '\'' +
                ", code_postal='" + code_postal + '\'' +
                ", ville='" + ville + '\'' +
                ", credit='" + credit + '\'' +
                ", administrateur=" + administrateur +
                ", actif=" + actif +
                '}';
    }
}
