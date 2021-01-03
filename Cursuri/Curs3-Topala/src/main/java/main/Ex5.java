package main;

import db.Tricou;

import javax.persistence.Persistence;

public class Ex5 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c3PU");
        var em = emf.createEntityManager();

        var t = em.find(Tricou.class, 1);


        em.getTransaction().begin();
        //primeste o entiate peristata si o sterge din baza de date
        em.remove(t);
        em.getTransaction().commit();

        em.close();
        emf.close();



    }
}
