package dao;

import db.Transmisie;

import javax.persistence.EntityManager;

public class TransmisieDao {

    private EntityManager em;

    public TransmisieDao(EntityManager em) {
        this.em = em;
    }

    public void adauga(Transmisie transmisie){
        em.persist(transmisie);
    }
}
