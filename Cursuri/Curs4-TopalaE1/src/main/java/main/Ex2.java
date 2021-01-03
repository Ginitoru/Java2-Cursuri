package main;

import db.Angajat;
import db.Departament;

import javax.persistence.Persistence;

public class Ex2 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c4PU");
        var em = emf.createEntityManager();


        var departament =  new Departament();

        var gigel = new Angajat();
        gigel.setNume("gigel");
        gigel.setDepartament(departament);

        var coste = new Angajat();

        coste.setNume("costel");
        coste.setDepartament(departament);

        em.getTransaction().begin();
        em.persist(gigel);
        em.persist(coste);

        em.getTransaction().commit();




        em.close();
        emf.close();


    }
}
