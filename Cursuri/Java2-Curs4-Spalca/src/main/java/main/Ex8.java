package main;

import db.Contact;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class Ex8 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c4PU");
        EntityManager em = emf.createEntityManager();


        try{

            Contact c = new Contact();
            c.setNume("contact 1");
            c.setNumere(new ArrayList<>());
            c.getNumere().add("12345");

            c.getNumere().add("665623");

            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();



        }finally{
            em.close();
            emf.close();
        }
    }
}
