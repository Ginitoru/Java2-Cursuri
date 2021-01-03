package main;

import db.Anagajat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Ex2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c4PU");
        EntityManager em = emf.createEntityManager();

        try{
            Anagajat a1 = em.find(Anagajat.class,2);
            System.out.println(a1);

        }finally {
            em.close();
            emf.close();
        }


    }
}
