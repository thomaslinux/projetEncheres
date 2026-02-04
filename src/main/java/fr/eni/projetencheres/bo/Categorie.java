package fr.eni.projetencheres.bo;

public class Categorie {

    private long id_categorie;
    private String libelle;
    private String image_categorie;

    public Categorie(long id_categorie, String libelle, String image_categorie) {
        this.id_categorie = id_categorie;
        this.libelle = libelle;
        this.image_categorie = image_categorie;
    }

    public Categorie(String libelle, String image_categorie) {
        this.libelle = libelle;
        this.image_categorie = image_categorie;
    }

    public Categorie() {
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

    public String getImage_categorie() {
        return image_categorie;
    }

    public void setImage_categorie(String image_categorie) {
        this.image_categorie = image_categorie;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "id_categorie=" + id_categorie +
                ", libelle='" + libelle + '\'' +
                ", image_categorie='" + image_categorie + '\'' +
                '}';
    }
}

