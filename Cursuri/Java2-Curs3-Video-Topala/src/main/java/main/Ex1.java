package main;

import db.Categorie;
import db.Produs;

import javax.persistence.Persistence;
import java.sql.Date;
import java.time.LocalDate;

public class Ex1 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c3PU");
        var em = emf.createEntityManager();

        var p = new Produs();
        p.setNume("cico");
        p.setExpirare(Date.valueOf(LocalDate.of(2020,3,30)));
        p.setCategorie(Categorie.ALIMENTAR);

        try{

            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();

        }finally {
            em.close();
            emf.close();
        }










    }
}
