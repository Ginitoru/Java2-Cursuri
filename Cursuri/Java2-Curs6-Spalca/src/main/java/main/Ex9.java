package main;

import db.ex7.Factura;

import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Ex9 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("curs6PU");
        var em = emf.createEntityManager();


        try{
            String sql = "SELECT f FROM Factura f LEFT JOIN FETCH f.linii where f.numar = :numar";

            TypedQuery<Factura> q = em.createQuery(sql,Factura.class);
            q.setParameter("numar", 10);

            List<Factura> facturi = q.getResultList();

            facturi.forEach(System.out::println);


        }finally {
            em.close();
            emf.close();
        }
    }
}
