package fr.eni.projetencheres.bo;

import java.time.LocalDate;

public class Retrait {

    private String rue;
    private LocalDate date_enchere;
    private  String ville;
    private Retrait retrait;

    @Override
    public String toString() {
        return "Retrait{" +
                "rue='" + rue + '\'' +
                ", date_enchere=" + date_enchere +
                ", ville='" + ville + '\'' +
                ", retrait=" + retrait +
                '}';
    }

    public Retrait(String rue, LocalDate date_enchere, String ville, Retrait retrait) {
        this.rue = rue;
        this.date_enchere = date_enchere;
        this.ville = ville;
        this.retrait = retrait;
    }

    public Retrait() {
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public LocalDate getDate_enchere() {
        return date_enchere;
    }

    public void setDate_enchere(LocalDate date_enchere) {
        this.date_enchere = date_enchere;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Retrait getRetrait() {
        return retrait;
    }

    public void setRetrait(Retrait retrait) {
        this.retrait = retrait;
    }
}
