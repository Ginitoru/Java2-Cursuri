package main;

import db.ex4.Java;

import javax.persistence.Persistence;

public class Ex4 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("curs6PU");
        var em = emf.createEntityManager();

        try{

            Java j  = new Java();

            j.setDurata(5);
            j.setInstructor("spalca");

            em.getTransaction().begin();

            em.persist(j);
            em.getTransaction().commit();

        }finally {

            em.close();
            emf.close();

        }

    }
}
