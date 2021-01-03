package main;

import db.Culoare;
import db.Tricou;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class Ex3 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("curs5");
        EntityManager em = emf.createEntityManager();

        Tricou t = new Tricou();

        Map<String, Culoare> map = new HashMap<>();

        map.put("xl",Culoare.GALBEN);
        map.put("l", Culoare.ROSU);
        t.setMap(map);



        em.getTransaction().begin();
            em.persist(t);

        em.getTransaction().commit();
    }
}
