package main;

import entiti.ex1.Publication;

import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Ex3 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2PU");
        var em = emf.createEntityManager();

        String x = "SELECT a FROM Publication a WHERE a.id > 20";

        try{

            TypedQuery<Publication> q = em.createQuery(x, Publication.class);

            List<Publication> publications = q.getResultList();

            publications.forEach(System.out::println);










        }finally {
            em.close();
            emf.close();
        }


    }
}
