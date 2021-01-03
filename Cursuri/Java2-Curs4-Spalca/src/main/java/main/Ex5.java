package main;

import db.Librarie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Ex5 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c4PU");
        EntityManager em = emf.createEntityManager();


        try{

            Librarie l = em.find(Librarie.class, 5);

            System.out.println(l);
            System.out.println(l.getAdresa());
            System.out.println(l.getCarti());

        }finally {
            em.close();
            emf.close();
        }
    }
}
