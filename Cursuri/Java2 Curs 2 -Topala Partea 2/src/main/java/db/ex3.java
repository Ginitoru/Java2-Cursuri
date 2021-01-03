package db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ex3 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c2PU");

        EntityManager em =  emf.createEntityManager();


        Persoana p = em.find(Persoana.class,1);
        em.getTransaction().begin();



        System.out.println(p);

        p.setNume("costel");

        em.getTransaction().commit();

        em.close();
        emf.close();



    }
}
