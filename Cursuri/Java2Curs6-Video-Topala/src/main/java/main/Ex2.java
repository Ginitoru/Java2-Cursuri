package main;

import db.ex2.Avocat;
import db.ex2.Programator;

import javax.persistence.Persistence;

public class Ex2 {
    public static void main(String[] args) {

        var emf = Persistence.createEntityManagerFactory("java6PU");
        var em = emf.createEntityManager();

        Programator p = new Programator();

        p.setLimbaj("java");
        p.setNume("gigel");

        Avocat a  = new Avocat();

        a.setNume("ion");
        a.setVechime(20);


        em.getTransaction().begin();

        em.persist(p);
        em.persist(a);

        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
