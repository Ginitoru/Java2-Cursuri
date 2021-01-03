package main;

import db.ex7.Factura;
import db.ex7.LinieFactura;

import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

public class Ex7 {
    public static void main(String[] args) {

        var emf = Persistence.createEntityManagerFactory("curs6PU");
        var em = emf.createEntityManager();


        try{

            LinieFactura q1 = new LinieFactura();
            q1.setProdus("produs 1");
            q1.setCantaitate(10);
            q1.setPret(20);

            LinieFactura q2 = new LinieFactura();
            q2.setProdus("produs 2");
            q2.setCantaitate(15);
            q2.setPret(34);

            LinieFactura q3 = new LinieFactura();
            q3.setProdus("produs 3");
            q3.setCantaitate(44);
            q3.setPret(56);

            LinieFactura q4 = new LinieFactura();
            q4.setProdus("produs 4");
            q4.setCantaitate(102);
            q4.setPret(15);


            Factura f1 = new Factura();
            f1.setSerie("xy");
            f1.setNumar(10);

            Factura f2 = new Factura();
            f2.setSerie("xy");
            f2.setNumar(11);

            f1.setLinii(List.of(q1,q2,q3));
            q1.setFactura(f1);
            q2.setFactura(f1);
            q3.setFactura(f1);

            f2.setLinii(Arrays.asList(q4));
            q4.setFactura(f2);


            em.getTransaction().begin();

            em.persist(q1);
            em.persist(q2);
            em.persist(q3);
            em.persist(q4);
            em.persist(f1);em.persist(f2);




            em.getTransaction().commit();


        }finally {
            em.close();
            emf.close();
        }
    }
}
