package main;

import db.Tricou;

import javax.persistence.Persistence;

public class Ex3 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c3PU");

        var em = emf.createEntityManager();


        Tricou t = em.find(Tricou.class, 2);

        System.out.println(t);



    }
}
