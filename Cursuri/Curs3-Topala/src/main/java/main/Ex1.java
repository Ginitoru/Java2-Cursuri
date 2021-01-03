package main;

import db.Produs;

import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.Calendar;

public class Ex1 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c3PU");

        var em = emf.createEntityManager();

        var p = new Produs();

        p.setNume("ciocolata");
        p.setDataExpirare(Calendar.getInstance().getTime());
        p.setDataProducere(LocalDateTime.now());

        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();

        em.close();
        emf.close();



    }
}
