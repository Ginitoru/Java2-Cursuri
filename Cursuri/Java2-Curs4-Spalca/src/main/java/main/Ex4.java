package main;

import db.Carte;
import db.Librarie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class Ex4 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c4PU");
        EntityManager em = emf.createEntityManager();

        try{

            Librarie l = new Librarie();
            Carte c1 = new Carte();
            Carte c2 = new Carte();
            l.setAdresa("adresa 1");
            c1.setNume("tritlu1");
            c2.setNume("titlu2");

            l.setCarti(new ArrayList<>());
            l.getCarti().add(c1);
            l.getCarti().add(c2);
            c1.setLibratie(l);
            c2.setLibratie(l);

            em.getTransaction().begin();
            em.persist(l);
            em.persist(c1);
            em.persist(c2);

            em.getTransaction().commit();



        }finally {
            em.close();
            emf.close();
        }

    }
}
