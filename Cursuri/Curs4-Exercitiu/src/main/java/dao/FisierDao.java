package dao;

import entities.Fisier;

public interface FisierDao {

    void persist(Fisier fisier);

    void delete(Fisier fisier);

    Fisier find(int id);
}
