package main;

import db.Produs;

import javax.persistence.Persistence;

public class Ex2 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c3PU");
        var em = emf.createEntityManager();

        var p = em.find(Produs.class, 3);

        System.out.println(p);

        em.close();
        emf.close();

    }
}
