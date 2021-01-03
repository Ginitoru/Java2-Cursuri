package main;

import db.ex1.Bere;

import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Ex5 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java6PU");
        var em = emf.createEntityManager();


        String url = "SELECT * FROM bere WHERE nume = ?";

        Query q = em.createNativeQuery(url, Bere.class);

        q.setParameter(1, "stejar");


       List<Bere> beri =  q.getResultList();

        beri.forEach(System.out::println);

        Bere b = (Bere) q.getSingleResult(); //intoarece o singura inregistrare
                                            //sau arunca o exceptie daca sunt intoarese
                                            //2 sau mai multe inregistrari fie niciuna.

        System.out.println(b);



        em.close();
        emf.close();
    }
}
