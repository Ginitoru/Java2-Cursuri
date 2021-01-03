package main;

import db.Marime;
import db.Tricou;

import javax.persistence.Persistence;

public class Ex6 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c3PU");
        var em = emf.createEntityManager();

        var t = new Tricou();
        t.setMarime(Marime.L);


        t.setId(2);

        //adaugam instatna t in contextul de persistenta
        //nu folosim persist deoarece Entety manager ar adauga o noua instanta
        //in baza de date

        em.getTransaction().begin();
        t = em.merge(t);
        em.getTransaction().commit();
        em.close();
        emf.close();

        System.out.println(t);




    }
}
