package main;

import db.Magazin;

import javax.persistence.Persistence;
import java.util.Map;

public class Ex1 {
    public static void main(String[] args) {

        var emf = Persistence.createEntityManagerFactory("java2c5PU");
        var em = emf.createEntityManager();

        var magazin = new Magazin();

        magazin.setEmails(Map.of(
                            "gigel", "gigel@mail.ro",
                            "costel", "costel@mail.ro"

        ));


        em.getTransaction().begin();
        em.persist(magazin);
        em.getTransaction().commit();

        em.close();
        emf.close();



    }
}
