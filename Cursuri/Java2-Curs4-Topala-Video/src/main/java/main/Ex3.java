package main;

import db.Angajat;

import javax.persistence.Persistence;

public class Ex3 {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2cPU");
        var em = emf.createEntityManager();

        Angajat a =  em.find(Angajat.class, 1);

        System.out.println(a);
        System.out.println(a.getLocParcare());



    }


}
