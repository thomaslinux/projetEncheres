package fr.eni.projetencheres.bo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public class Enchere {
    private long id_enchere;
    private LocalDate date_enchere;
    @NotBlank
    @Pattern(regexp = "[0-9]*", message = "Que des nombres")
    private int montant_enchere;
    private Utilisateur utilisateur;
    private Article article;

    @Override
    public String toString() {
        return "Enchere{" +
                "id_enchere=" + id_enchere +
                ", date_enchere=" + date_enchere +
                ", montant_enchere=" + montant_enchere +
                ", utilisateur=" + utilisateur +
                ", article=" + article +
                '}';
    }

    public Enchere(long id_enchere, LocalDate date_enchere, int montant_enchere, Utilisateur utilisateur, Article article) {
        this.id_enchere = id_enchere;
        this.date_enchere = date_enchere;
        this.montant_enchere = montant_enchere;
        this.utilisateur = utilisateur;
        this.article = article;
    }

    public Enchere(LocalDate date_enchere, int montant_enchere, Utilisateur utilisateur, Article article) {
        this.date_enchere = date_enchere;
        this.montant_enchere = montant_enchere;
        this.utilisateur = utilisateur;
        this.article = article;
    }

    public Enchere() {
    }

    public long getId_enchere() {
        return id_enchere;
    }

    public void setId_enchere(long id_enchere) {
        this.id_enchere = id_enchere;
    }

    public LocalDate getDate_enchere() {
        return date_enchere;
    }

    public void setDate_enchere(LocalDate date_enchere) {
        this.date_enchere = date_enchere;
    }

    public int getMontant_enchere() {
        return montant_enchere;
    }

    public void setMontant_enchere(int montant_enchere) {
        this.montant_enchere = montant_enchere;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
