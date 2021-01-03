package main;

import db.Angajat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Ex4 {

    public static void main(String[] args) {
        EntityManagerFactory amf = Persistence.createEntityManagerFactory("java2c2PU");

        EntityManager em = amf.createEntityManager();

        Angajat a = em.find(Angajat.class, 2);
        System.out.println(a);

    }
}
