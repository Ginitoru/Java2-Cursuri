package main;

import db.ex3.Articol;

import javax.persistence.Persistence;

public class Ex3 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("curs6PU");
        var em = emf.createEntityManager();


        try{

            Articol a  = new Articol();
            a.setTitlu("titlu");
            a.setRevista("revista");

            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();


        }finally {
            em.close();
            emf.close();
        }
    }
}
