package main;

import db.Depozit;

import javax.persistence.Cache;
import javax.persistence.Persistence;

public class Ex8 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c5PU");
        var em1 = emf.createEntityManager();
        var em2 = emf.createEntityManager();



        Cache cache = emf.getCache();

        System.out.println(cache.contains(Depozit.class, 302));

        em1.find(Depozit.class, 302);

        System.out.println(cache.contains(Depozit.class, 302));

        em2.find(Depozit.class, 302);

        cache.evict(Depozit.class);//sterge cache-urile stocate pt toate entitatile
                                    //de tip Depizt, sau care mostenesc clasa Depozit
        cache.evict(Depozit.class, 302); // sterge doar inregistrarea din chache a entitatii depozit
                                            // cu id 302.
        cache.evictAll();

    }
}
