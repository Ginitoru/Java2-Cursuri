package main;

import db.Carte;
import db.Librarie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class Ex5 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("curs5");
        EntityManager em = emf.createEntityManager();

        Carte c1 = new Carte();
        c1.setTitlu("titlu 1");

        Carte c2 =new Carte();
        c2.setTitlu("titlu 2");

        Librarie lib = new Librarie();

        Map<String, Carte>  carti =new HashMap<>();

        carti.put("12345", c1);
        carti.put("12365", c2);
        lib.setCarti(carti);


        em.getTransaction().begin();

        em.persist(lib);

        em.getTransaction().commit();

    }

}
