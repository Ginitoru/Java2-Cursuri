package MAIN;

import db.Magazin;

import javax.persistence.Persistence;
import java.util.List;

public class Ex6 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c4PU");
        var em = emf.createEntityManager();

        Magazin m1 = new Magazin();

        m1.setNume("mega");
        m1.setNumere(List.of("123", " 6545", "1465444"));


        em.getTransaction().begin();

        em.persist(m1);

        em.getTransaction().commit();

        em.close();
        emf.close();


    }
}
