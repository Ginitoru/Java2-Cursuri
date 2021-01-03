package main;

import db.Persoana;

import javax.persistence.Persistence;

public class Ex5 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2PU");
        var em = emf.createEntityManager();

        Persoana p = em.find(Persoana.class,3 );

        System.out.println(p.getAdrese());



    }
}
