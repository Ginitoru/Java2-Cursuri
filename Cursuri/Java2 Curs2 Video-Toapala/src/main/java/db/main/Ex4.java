package db.main;

import db.Angajat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Ex4 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c2PU");
        EntityManager em = emf.createEntityManager();


        Angajat a = em.find(Angajat.class, 11);


        System.out.println(a);

        em.close();
        emf.close();


    }

}
