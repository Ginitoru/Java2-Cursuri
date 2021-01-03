package main;

import db.ex2.Programator;

import javax.persistence.Persistence;

public class Ex2 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("curs6PU");
        var em = emf.createEntityManager();


        try{

            Programator p1 = new Programator();
            p1.setLimbaj("java");
            p1.setNume("gigel");

            em.getTransaction().begin();
            em.persist(p1);
            em.getTransaction().commit();

        }finally {
            em.close();
            emf.close();
        }
    }
}
