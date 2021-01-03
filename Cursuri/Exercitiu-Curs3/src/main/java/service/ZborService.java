package service;

import entities.TipAvion;
import entities.Zbor;

public interface ZborService {

    void persist(Zbor zbor);

    Zbor find(int id);

    void remove(int id);

    Zbor refresh(Zbor Zbor);


    void detach(Zbor zbor);

    void clear();

    void update(int id, String plecare, TipAvion tipAvion);



}
