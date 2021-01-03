package MAIN;

import db.Angajat;
import db.LocParcare;

import javax.persistence.Persistence;

public class Ex2 {
    public static void main(String[] args) {

        var emf = Persistence.createEntityManagerFactory("java2c4PU");
        var em = emf.createEntityManager();


        Angajat a = new Angajat();

        a.setNume("costel");

        LocParcare lp = new LocParcare();


        lp.setNr(20);

        a.setLocParcare(lp);

        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();

        em.close();
        emf.close();


    }
}
