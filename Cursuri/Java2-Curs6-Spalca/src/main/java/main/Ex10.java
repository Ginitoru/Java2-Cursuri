package main;

import db.ex7.Factura;

import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Ex10 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("curs6PU");
        var em = emf.createEntityManager();





        try{

            TypedQuery<Factura> q = em.createNamedQuery("Factura.getById",Factura.class);

            q.setParameter("id", 28);

            List<Factura> facturi = q.getResultList();

            facturi.forEach(System.out::println);


            em.getTransaction().begin();


            em.getTransaction().commit();



        }finally {
            em.close();
            emf.close();
        }
    }
}
