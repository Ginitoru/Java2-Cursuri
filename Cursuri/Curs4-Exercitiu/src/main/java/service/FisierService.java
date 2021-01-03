package service;

import entities.Fisier;

public interface FisierService {

    void persist(Fisier fisier);

    void remove(int id);

    Fisier find(int id);
}
