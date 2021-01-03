package main;

import db.Magazin;

import javax.persistence.Persistence;
import java.util.List;

public class Ex5 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c4PU");
        var em = emf.createEntityManager();


        var magazin = new Magazin();

        magazin.setTelefoane(List.of("123658", "3568"));


        em.getTransaction().begin();

        em.persist(magazin);

        em.getTransaction().commit();

        em.close();
        emf.close();





    }
}
