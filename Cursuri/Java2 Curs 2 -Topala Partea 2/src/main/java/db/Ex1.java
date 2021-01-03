package db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Ex1 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c2PU");
        EntityManager em = emf.createEntityManager();

        Persoana p = new Persoana();

        p.setNume("gigel");

        try{

            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();


        }finally {

            emf.close();
            em.close();
        }



    }
}
