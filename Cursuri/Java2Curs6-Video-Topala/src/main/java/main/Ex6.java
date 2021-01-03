package main;

import db.ex1.Produs;

import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Ex6 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java6PU");
        var em = emf.createEntityManager();


        String url = "SELECT b FROM Bere b WHERE b.alcool =?0 AND b.nume = :nume";




        TypedQuery<Produs> q = em.createQuery(url, Produs.class);

        q.setParameter(0,7);
        q.setParameter("nume","stejar");

        List<Produs> beri = q.getResultList();

        beri.forEach(System.out::println);





        em.close();
        emf.close();

    }
}
