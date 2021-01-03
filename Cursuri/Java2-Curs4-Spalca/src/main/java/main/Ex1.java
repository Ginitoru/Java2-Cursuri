package main;

import db.Anagajat;
import db.LocParcare;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Ex1 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c4PU");
        EntityManager em = emf.createEntityManager();

        try{

            LocParcare p1 = new LocParcare();
            p1.setNumar(5);
            Anagajat a1 = new Anagajat();

            a1.setNume("gigel");
            a1.setLocParcare(p1);

            em.getTransaction().begin();

            em.persist(p1);
            em.persist(a1);

            em.getTransaction().commit();

        }finally {
            em.close();
            emf.close();
        }


    }
}
