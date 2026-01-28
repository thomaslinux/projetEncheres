package fr.eni.projetencheres.repository;

import fr.eni.projetencheres.bo.Retrait;

import java.util.List;

public interface RetraitDao {
    public List<Retrait> readRetraits();

    void addRetrait(Retrait retrait);

    Retrait getRetrait(long id_retrait);

    void deleteRetrait(long id_retrait);

    void updateRetrait(Retrait retrait);
}
