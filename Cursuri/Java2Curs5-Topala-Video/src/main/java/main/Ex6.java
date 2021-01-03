package main;

import db.Adresa;
import db.Organizatie;

import javax.persistence.Persistence;
import java.util.Map;

public class Ex6 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2PU");
        var em = emf.createEntityManager();

        var organizatie = new Organizatie();

        Adresa a1 = new Adresa();
        a1.setStrada("basasarb");
        a1.setNumar(500);

        organizatie.setStraziAdrese(Map.of(
                a1, a1.getStrada()
        ));

        em.getTransaction().begin();
        em.persist(a1);
        em.persist(organizatie);
        em.getTransaction().commit();

        em.close();
        emf.close();


    }

}
