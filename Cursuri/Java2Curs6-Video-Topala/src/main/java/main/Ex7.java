package main;

import db.ex1.Bere;

import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Ex7 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java6PU");
        var em = emf.createEntityManager();


       TypedQuery<Bere> q = em.createNamedQuery("Bere.faindAll", Bere.class);

        List<Bere> beri = q.getResultList();

        beri.forEach(System.out::println);



        em.close();
        emf.close();
    }
}
