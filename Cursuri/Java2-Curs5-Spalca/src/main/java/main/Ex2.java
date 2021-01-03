package main;

import db.Culoare;
import db.Semafor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class Ex2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("curs5");
        EntityManager em = emf.createEntityManager();

        Semafor s = new Semafor();
        Map<Culoare, String> map = new HashMap<>();

        map.put(Culoare.ROSU, "abc");
        map.put(Culoare.GALBEN, "xyz");

        s.setCulori(map);


        em.getTransaction().begin();
        em.persist(s);

        em.getTransaction().commit();

        em.close();
        emf.close();





    }
}
