package main;

import entiti.ex1.Autor;
import entiti.ex1.Book;
import entiti.ex1.Publication;
import entiti.ex1.Publisher;

import javax.persistence.Persistence;
import java.util.Set;

public class Ex1 {
    public static void main(String[] args) {

        var emf = Persistence.createEntityManagerFactory("java2PU");
        var em = emf.createEntityManager();


        try{

            Autor a = new Autor();
            a.setFirstName("gigel");
            a.setLastName("ion");

            Autor a2 = new Autor();
            a2.setFirstName("fane");
            a2.setLastName("costel");

            Autor a3 = new Autor();
            a3.setFirstName("xxx");
            a3.setLastName("yyy");

            Publication p1 = new Publication();
            p1.setTitle("furtuna");

            Publication p2 = new Publication();
            p2.setTitle("soare");

            Publication p3 = new Publication();
            p3.setTitle("bau bau");

            a.setPublications(Set.of(p1, p2));
            a2.setPublications(Set.of(p2));
            p1.setAuthors(Set.of(a));
            p2.setAuthors(Set.of(a, a2));


            a3.setPublications(Set.of(p3));
            p3.setAuthors(Set.of(a3));


            Publisher pub = new Publisher();
            pub.setName("PUBLISHER1");

            Publisher pub2 = new Publisher();
            pub2.setName("PUBLISHER2");

            Book b = new Book();
            b.setPublisher(pub);
            b.setTitle("vrajeala 2");
            b.setAuthors(Set.of(a, a2));

            Book b2 = new Book();
            b2.setPublisher(pub2);
            b2.setTitle("vrajeala");
            b2.setAuthors(Set.of(a3));





            em.getTransaction().begin();
                em.persist(a);
                em.persist(a2);
                em.persist(a3);
            em.persist(b);
            em.persist(b2);

            em.getTransaction().commit();



        }finally {
            em.close();
            emf.close();
        }





    }
}
