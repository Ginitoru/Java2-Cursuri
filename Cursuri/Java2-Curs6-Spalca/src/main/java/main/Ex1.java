package main;

import db.ex1.Bere;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Ex1 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("curs6PU");
        EntityManager em = emf.createEntityManager();


        try{
            Bere  b1 = new Bere();
            b1.setNume("tuborg");
            b1.setPret(4);
            b1.setProcentAlcool(5);

            em.getTransaction().begin();
            em.persist(b1);
            em.getTransaction().commit();




        }finally {
            em.close();
            emf.close();
        }




    }
}
