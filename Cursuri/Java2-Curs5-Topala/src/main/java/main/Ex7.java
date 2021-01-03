package main;

import db.Adresa;
import db.Depozit;

import javax.persistence.Persistence;
import java.util.Map;

public class Ex7 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c5PU");
        var em = emf.createEntityManager();

        var adresa = new Adresa();
        adresa.setStrada("1 mai");

        var depozit = new Depozit();
        depozit.setFirme(Map.of(
                adresa, "gigel"

        ));

        em.getTransaction().begin();
        em.persist(adresa);
        em.persist(depozit);
        em.getTransaction().commit();

        em.close();
        emf.close();



    }
}
