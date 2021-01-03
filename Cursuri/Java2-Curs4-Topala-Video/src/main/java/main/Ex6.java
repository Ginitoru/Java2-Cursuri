package main;

import db.Magazin;

import javax.persistence.Persistence;
import java.util.List;

public class Ex6 {
    public static void main(String[] args) {

        var emf = Persistence.createEntityManagerFactory("java2cPU");
        var em = emf.createEntityManager();

        Magazin magazin = new Magazin();

        magazin.setNume("fdasdasd");

        magazin.setNumere(List.of("123","000", "1565"));


        em.getTransaction().begin();
        em.persist(magazin);
        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
