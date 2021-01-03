package dao;

import entities.Zbor;

public interface ZborDao {

    void persist(Zbor zbor);

    Zbor find(int id);

    void remove(Zbor zbor);

    Zbor refresh(Zbor zbor);

    Zbor merge(Zbor zbor);

    void detach(Zbor zbor);

    void clear();

    void update(Zbor zbor);

}
