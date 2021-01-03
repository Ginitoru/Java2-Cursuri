package main;

import db.Adresa;
import db.Locatie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class Ex4 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("curs5");
        EntityManager em = emf.createEntityManager();

        Locatie loc = new Locatie();
        Map<String, Adresa> adrese = new HashMap<>();

        Adresa a1 = new Adresa();
        a1.setOras("bucuresti");
        a1.setStrada("iuliu maniu");
        adrese.put("12345", a1);

        loc.setAdrese(adrese);

        em.getTransaction().begin();
        em.persist(loc);


        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
