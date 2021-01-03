package main;

import db.ex3.NumePrenumeId;
import db.ex3.Persoana;

import javax.persistence.Persistence;

public class Ex3 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java6PU");
        var em = emf.createEntityManager();


        NumePrenumeId id = new NumePrenumeId();

        Persoana p = new Persoana();

        id.setNume("gigel");
        id.setPrenume("ion");
        p.setId(id);
        p.setVarsta(25);


        em.getTransaction().begin();
        em.persist(p);

        em.getTransaction().commit();


        em.close();
        emf.close();
    }
}
