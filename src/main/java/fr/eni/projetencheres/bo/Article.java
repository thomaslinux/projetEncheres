package fr.eni.projetencheres.bo;

import java.time.LocalDate;


public class Article {
    private long id_article;
    private String nom_article;
    private String description;
    private LocalDate date_debut_enchere;
    private LocalDate date_fin_enchere;
    private int prix_de_base;
    private int prix_de_vente;
    private boolean vente_en_cours;
    private Categorie categorie;


    @Override
    public String toString() {
        return "Article{" +
                "id_article=" + id_article +
                ", nom_article='" + nom_article + '\'' +
                ", description='" + description + '\'' +
                ", date_debut_enchere=" + date_debut_enchere +
                ", date_fin_enchere=" + date_fin_enchere +
                ", prix_de_base=" + prix_de_base +
                ", prix_de_vente=" + prix_de_vente +
                ", vente_en_cours=" + vente_en_cours +
                ", categorie=" + categorie +
                '}';
    }

    public Article(long id_article, String nom_article, String description, LocalDate date_debut_encheres, LocalDate date_fin_encheres, int prix_de_base, int prix_de_vente, boolean vente_en_cours, Categorie categorie) {
        this.id_article = id_article;
        this.nom_article = nom_article;
        this.description = description;
        this.date_debut_enchere = date_debut_encheres;
        this.date_fin_enchere = date_fin_encheres;
        this.prix_de_base = prix_de_base;
        this.prix_de_vente = prix_de_vente;
        this.vente_en_cours = vente_en_cours;
        this.categorie = categorie;

    }

    public Article(String nom_article, String description, LocalDate date_debut_enchere, LocalDate date_fin_enchere, int prix_de_base, int prix_de_vente, boolean vente_en_cours, Categorie categorie) {
        this.nom_article = nom_article;
        this.description = description;
        this.date_debut_enchere = date_debut_enchere;
        this.date_fin_enchere = date_fin_enchere;
        this.prix_de_base = prix_de_base;
        this.prix_de_vente = prix_de_vente;
        this.vente_en_cours = vente_en_cours;
        this.categorie = categorie;
    }

    public Article() {
    }

    public long getId_article() {
        return id_article;
    }

    public void setId_article(long id_article) {
        this.id_article = id_article;
    }

    public String getNom_article() {
        return nom_article;
    }

    public void setNom_article(String nom_article) {
        this.nom_article = nom_article;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate_debut_enchere() {
        return date_debut_enchere;
    }

    public void setDate_debut_enchere(LocalDate date_debut_enchere) {
        this.date_debut_enchere = date_debut_enchere;
    }

    public LocalDate getDate_fin_enchere() {
        return date_fin_enchere;
    }

    public void setDate_fin_enchere(LocalDate date_fin_enchere) {
        this.date_fin_enchere = date_fin_enchere;
    }

    public int getPrix_de_base() {
        return prix_de_base;
    }

    public void setPrix_de_base(int prix_de_base) {
        this.prix_de_base = prix_de_base;
    }

    public int getPrix_de_vente() {
        return prix_de_vente;
    }

    public void setPrix_de_vente(int prix_de_vente) {
        this.prix_de_vente = prix_de_vente;
    }

    public boolean isVente_en_cours() {
        return vente_en_cours;
    }

    public void setVente_en_cours(boolean vente_en_cours) {
        this.vente_en_cours = vente_en_cours;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
