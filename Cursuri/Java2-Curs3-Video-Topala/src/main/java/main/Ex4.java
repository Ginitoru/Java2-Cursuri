package main;

import db.Adresa;
import db.Organizatie;
import db.Persoana;

import javax.persistence.Persistence;

public class Ex4 {
    public static void main(String[] args) {

        var emf = Persistence.createEntityManagerFactory("java2c3PU");
        var em = emf.createEntityManager();

        var p = new Persoana();
        var org = new Organizatie();



        var a = new Adresa();

        a.setStrada("timisoara");
        a.setNumar("3");

        p.setAdresa(a);
        p.setNume("gigel");

        org.setSite("www.org.com");
        org.setAdrsa(a);


        em.getTransaction().begin();
        em.persist(p);
        em.persist(org);
        em.getTransaction().commit();


        em.close();
        emf.close();


    }
}
