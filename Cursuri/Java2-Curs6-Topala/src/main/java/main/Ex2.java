package main;

import db.ex2.Inginer;
import db.ex2.Programator;

import javax.persistence.Persistence;

public class Ex2 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("curs6PU");
        var em = emf.createEntityManager();




        try{

            Programator p = new Programator();
            p.setLimbaj("java");
            p.setNume("gigel");

            Inginer i = new Inginer();
            i.setSpecializare("mecanica fina");
            i.setNume("fane");

            em.getTransaction().begin();

            em.persist(p);
            em.persist(i);

            em.getTransaction().commit();

        }finally {
            em.close();
            emf.close();
        }

    }
}
