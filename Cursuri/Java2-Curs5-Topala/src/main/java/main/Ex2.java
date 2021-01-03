package main;

import db.Magazin;

import javax.persistence.Persistence;

public class Ex2 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c5PU");
        var em = emf.createEntityManager();


        Magazin magazin = em.find(Magazin.class,1 );


        em.getTransaction().begin();

        magazin.getEmails().put("gigel","gigel_nou@mail.ro");

        em.getTransaction().commit();

        em.close();
        emf.close();


    }
}
