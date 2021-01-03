package main;

import db.ex7.Factura;

import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Ex11 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("curs6PU");
        var em = emf.createEntityManager();


        try{



            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Factura> cq = cb.createQuery(Factura.class);

            Root<Factura> f = cq.from(Factura.class);
            cq.select(f);
            cq.where(cb.equal(f.get("id"),28));

            TypedQuery<Factura> q = em.createQuery(cq);
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
