package fr.eni.projetencheres.bo;

public class Categorie {

    private long id_categorie;
    private String libelle;


    @Override
    public String toString() {
        return "Categorie{" +
                "id_categorie=" + id_categorie +
                ", libelle='" + libelle + '\'' +
                '}';
    }

    public long getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(long id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Categorie(long id_categorie, String libelle) {
        this.id_categorie = id_categorie;
        this.libelle = libelle;
    }

    public Categorie(String libelle) {
        this.libelle = libelle;
    }

    public Categorie() {
    }

}

