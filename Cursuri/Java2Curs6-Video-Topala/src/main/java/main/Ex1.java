package main;

import db.ex1.Bere;
import db.ex1.Ciocolata;

import javax.persistence.Persistence;

public class Ex1 {

    public static void main(String[] args) {

        var emf = Persistence.createEntityManagerFactory("java6PU");
        var em = emf.createEntityManager();


        var ciocolata = new Ciocolata();
        ciocolata.setNume("milka");
        ciocolata.setZahar(20);

        var bere = new Bere();

        bere.setNume("heineken");
        bere.setAlcool(4);


        em.getTransaction().begin();

     //   em.persist(ciocolata);
        em.persist(bere);
        em.getTransaction().commit();

        em.close();
        emf.close();






    }
}
