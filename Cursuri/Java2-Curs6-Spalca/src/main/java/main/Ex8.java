package main;

import db.ex7.LinieFactura;

import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Ex8 {
    public static void main(String[] args) {

        var emf = Persistence.createEntityManagerFactory("curs6PU");
        var em = emf.createEntityManager();


        try{

            String sql = "SELECT * FROM liniefactura f WHERE f.pret > ?";
            Query q = em.createNativeQuery("sql", LinieFactura.class);

            q.setParameter(1,20);

            List<LinieFactura> linii = q.getResultList();

            linii.forEach(System.out::println);


        }finally{
            em.close();
            emf.close();
        }




    }
}
