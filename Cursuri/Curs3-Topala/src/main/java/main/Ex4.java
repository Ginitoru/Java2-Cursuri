package main;

import db.Adresa;
import db.Organizatie;
import db.Persoana;

import javax.persistence.Persistence;

public class Ex4 {
    public static void main(String[] args) {

        var emf = Persistence. createEntityManagerFactory("java2c3PU");
        var em = emf.createEntityManager();

        Adresa a = new Adresa();
        Organizatie o = new Organizatie();

        a.setNr(4);
        a.setStrada("timisoara");

        Persoana p = new Persoana();

        p.setNume("gigel");
        p.setAdresa(a);

        o.setAdresa(a);

        em.getTransaction().begin();
        em.persist(p);
        em.persist(o);
        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
