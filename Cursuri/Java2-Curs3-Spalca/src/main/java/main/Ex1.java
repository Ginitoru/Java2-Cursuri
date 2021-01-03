package main;

import dao.ProdusDao;
import db.Produs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Ex1 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c3");
        EntityManager em = emf.createEntityManager();



//        Produs p = new Produs();
//        p.setNume("ciocolata");
//        p.setPret(20);

        ProdusDao produsDao = new ProdusDao(em);

         Produs produs = new Produs();
         produs.setId(2);


//
//         em.getTransaction().begin();
//         produs = produsDao.mergeProdus(produs);
//         produsDao.stergeProdus(produs);
//         em.getTransaction().commit();

            em.getTransaction().begin();
            Produs p1 = em.find(Produs.class, 1);
            em.remove(p1);
            em.getTransaction().commit();



//
//        em.getTransaction().begin();
//        produsDao.adaugaProdus(p);
//        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
