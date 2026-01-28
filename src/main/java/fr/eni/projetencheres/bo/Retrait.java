package fr.eni.projetencheres.bo;

import java.time.LocalDate;

public class Retrait {

    private long id_retrait;
    private String adresse;
    private LocalDate date_enchere;
    private String code_postal;
    private String ville;
    private Article article;

    public Retrait(long id_retrait, String adresse, LocalDate date_enchere, String code_postal, String ville, Article article) {
        this.id_retrait = id_retrait;
        this.adresse = adresse;
        this.date_enchere = date_enchere;
        this.code_postal = code_postal;
        this.ville = ville;
        this.article = article;
    }

    public Retrait(String adresse, LocalDate date_enchere, String code_postal, String ville, Article article) {
        this.adresse = adresse;
        this.date_enchere = date_enchere;
        this.code_postal = code_postal;
        this.ville = ville;
        this.article = article;
    }

    public Retrait() {
    }

    public long getId_retrait() {
        return id_retrait;
    }

    public void setId_retrait(long id_retrait) {
        this.id_retrait = id_retrait;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public LocalDate getDate_enchere() {
        return date_enchere;
    }

    public void setDate_enchere(LocalDate date_enchere) {
        this.date_enchere = date_enchere;
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

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "Retrait{" +
                "id_retrait=" + id_retrait +
                ", adresse='" + adresse + '\'' +
                ", date_enchere=" + date_enchere +
                ", code_postal='" + code_postal + '\'' +
                ", ville='" + ville + '\'' +
                ", article=" + article +
                '}';
    }
}