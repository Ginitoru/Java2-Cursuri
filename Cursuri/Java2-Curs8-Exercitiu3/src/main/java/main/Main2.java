package main;

import entity.ImageX;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main2 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java6PU");



        EntityManager em = emf.createEntityManager();

        ImageX image = em.find(ImageX.class, 2);




        new Frame();









    }
}
