package main;

import db.CardAcces;
import db.Persoana;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Ex3 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c4PU");
        EntityManager em = emf.createEntityManager();


        try{

            Persoana p = new Persoana();
            p.setNume("gigel");

            CardAcces c = new CardAcces();

            p.setCardAcces(c);
            c.setPersoana(p);

            em.getTransaction().begin();
            em.persist(p);
            em.persist(c);

            em.getTransaction().commit();


        }finally {
            em.close();
            emf.close();
        }


    }
}
