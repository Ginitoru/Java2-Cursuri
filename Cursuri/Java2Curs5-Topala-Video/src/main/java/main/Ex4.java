package main;

import db.Adresa;
import db.Persoana;

import javax.persistence.Persistence;
import java.util.Map;

public class Ex4 {
    public static void main(String[] args) {

        var emf = Persistence.createEntityManagerFactory("java2PU");
        var em = emf.createEntityManager();

        Adresa a1 = new Adresa();

        a1.setNumar(4);
        a1.setStrada("timisoaRA");

        Adresa a2 = new Adresa();

        a2.setNumar(10);
        a2.setStrada("1 mai");

        Persoana p  = new Persoana();

        p.setAdrese(Map.of(
                    a1.getStrada(), a1,
                    a2.getStrada(), a2

        ));

        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();

        em.close();
        emf.close();






    }
}
