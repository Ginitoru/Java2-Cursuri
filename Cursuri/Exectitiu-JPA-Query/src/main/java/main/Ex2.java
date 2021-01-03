package main;

import entiti.ex1.Autor;

import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Ex2 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2PU");
        var em = emf.createEntityManager();

        TypedQuery<Autor> q = em.createNamedQuery("findAll", Autor.class);

 //      List<Autor> autori =  q.getResultList();

//        q.getResultStream()
//                .map(s ->s.getPublications())
//                .forEach(System.out::println);

//       autori.forEach(System.out::println);

        String url = "SELECT a,b FROM Autor a JOIN a.publications b";
        String url2 = "SELECT a FROM Autor a WHERE a.firstName = :firstName";





//        List<Object> q2 = em.createQuery(url).getResultList();
//        q2.forEach(System.out::println);


        TypedQuery<Autor> autori = em.createQuery(url2, Autor.class);
        autori.setParameter("firstName", "gigel");

        autori.getResultList().forEach(System.out::println);





    }
}
