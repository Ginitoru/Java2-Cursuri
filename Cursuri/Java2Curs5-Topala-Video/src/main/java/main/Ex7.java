package main;

import db.Persoana;

import javax.persistence.Cache;
import javax.persistence.Persistence;

public class Ex7 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2PU");
        var em1 = emf.createEntityManager();
        var em2 = emf.createEntityManager();


        Cache cache = emf.getCache();

        System.out.println(cache.contains(Persoana.class, 3));

        Persoana p = em1.find(Persoana.class, 3);

        System.out.println(cache.contains(Persoana.class, 3));

        Persoana p1 = em2.find(Persoana.class, 3);

        cache.evict(Persoana.class);









    }
}
