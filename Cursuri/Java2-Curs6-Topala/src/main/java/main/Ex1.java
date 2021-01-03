package main;

import db.ex1.Animal;
import db.ex1.Caine;
import db.ex1.Pisica;

import javax.persistence.Persistence;

public class Ex1 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("curs6PU");
        var em = emf.createEntityManager();




        try{

            var animal = new Animal();
            animal.setNume("tom");
            var pisica = new Pisica();

            pisica.setVieti(9);
            pisica.setNume("miti");

            var caine =  new Caine();

            caine.setNume("rex");


            em.getTransaction().begin();

            em.persist(animal);
            em.persist(pisica);
            em.persist(caine);

            em.getTransaction().commit();

        }finally {
            em.close();
            emf.close();
        }


    }
}
