package main;

import db.Persoana;

import javax.persistence.Persistence;

public class Ex6 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c5PU");
        var em = emf.createEntityManager();


        var persoana = em.find(Persoana.class, 251);

        System.out.println(persoana.getAdresa());

        em.close();
        emf.close();

    }
}
