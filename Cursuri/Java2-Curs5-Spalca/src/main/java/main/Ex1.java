package main;

import db.Persoana;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class Ex1 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("curs5");
        EntityManager em = emf.createEntityManager();

        Persoana p = new Persoana();

        Map<String, String> prieteni = new HashMap<>();

        prieteni.put("12335","Popescu");
        prieteni.put("12346", "Ionescu");
        p.setPrieteni(prieteni);

        em.getTransaction().begin();

        em.persist(p);
        em.getTransaction().commit();

        em.close();
        emf.close();




    }
}
