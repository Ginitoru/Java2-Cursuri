package db.main;

import db.Angajat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Ex1 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c2PU");
        EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("java2c2PP");

        EntityManager em = emf.createEntityManager();
        EntityManager em1 = emf1.createEntityManager();

        Angajat a = new Angajat();
        a.setNume("costel");
        a.setVarsta(24);
        Angajat b = new Angajat();

        b.setNume("xxx");
        b.setVarsta(10);

        try{

            em.getTransaction().begin();
            em.persist(b);
            em.getTransaction().commit();

        }finally {
            em.close();
            emf.close();

        }

                 em1.getTransaction().begin();
           em1.persist(a);
           em1.getTransaction().commit();

            em1.close();
            emf1.close();






    }
}
