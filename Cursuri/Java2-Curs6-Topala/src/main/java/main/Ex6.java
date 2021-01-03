package main;

import db.ex2.Programator;
import db.ex4.Departament;

import javax.persistence.Persistence;
import java.util.Set;

public class Ex6 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("curs6PU");
        var em = emf.createEntityManager();

        var p1 = new Programator();

        p1.setLimbaj("java");
        p1.setNume("costel");

        var p2 = new Programator();

        p2.setLimbaj("c#");
        p2.setNume("gigel");

        var d= new Departament();
        d.setProgramatori(Set.of(p1, p2));
        em.getTransaction().begin();

        em.persist(d);

        em.getTransaction().commit();

        em.close();
        emf.close();



    }

}
