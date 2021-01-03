package main;

import dao.TransmisieDao;
import db.TipTransmisie;
import db.Transmisie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Ex2 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c3");
        EntityManager em = emf.createEntityManager();


        em.getTransaction().begin();
        Transmisie t = new Transmisie();
        t.setMesaj("ABC");
        t.setTransmisie(TipTransmisie.ETH);
        TransmisieDao transmisieDao = new TransmisieDao(em);
        transmisieDao.adauga(t);

        em.getTransaction().commit();


        em.close();
        emf.close();


    }
}
