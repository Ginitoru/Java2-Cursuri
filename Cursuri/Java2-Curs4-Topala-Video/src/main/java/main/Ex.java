package main;

import db.Buletin;
import db.Persoana;

import javax.persistence.Persistence;

public class Ex {
    public static void main(String[] args) {

        var emf = Persistence.createEntityManagerFactory("java2cPU");
        var em = emf.createEntityManager();

        Buletin b1 = new Buletin();

        b1.setCod("fsdfsdf");

        Persoana p1 = new Persoana();
        Persoana p2 = new Persoana();

        p1.setBuletin(b1);


        em.getTransaction().begin();
        em.persist(b1);
        em.persist(p1);
     //   em.persist(p2);

        em.getTransaction().commit();

        em.close();
        emf.close();





    }
}
