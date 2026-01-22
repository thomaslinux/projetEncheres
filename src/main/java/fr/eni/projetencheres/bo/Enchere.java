package fr.eni.projetencheres.bo;

import java.time.LocalDate;

public class Enchere {
    private long id;
    private LocalDate date_enchere;
    private int montant_enchere;


    @Override
    public String toString() {
        return "Enchere{" +
                "id=" + id +
                ", date_enchere=" + date_enchere +
                ", montant_enchere=" + montant_enchere +
                '}';
    }

    public Enchere(long id, LocalDate date_enchere, int montant_enchere) {
        this.id = id;
        this.date_enchere = date_enchere;
        this.montant_enchere = montant_enchere;
    }

    public Enchere() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Enchere(LocalDate date_enchere, int montant_enchere) {
        this.date_enchere = date_enchere;
        this.montant_enchere = montant_enchere;



    }
}
