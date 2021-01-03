package MAIN;

import db.Curs;
import db.Strudent;

import javax.persistence.Persistence;
import java.util.List;

public class Ex5 {
    public static void main(String[] args) {

        var emf = Persistence.createEntityManagerFactory("java2c4PU");
        var em = emf.createEntityManager();


        Curs c1 = new Curs();
        Curs c2 = new Curs();

        c1.setNume("mate");
        c2.setNume("fizica2");

        Strudent s1 = new Strudent();
        s1.setSerie(10);
        Strudent s2 = new Strudent();
        s2.setSerie(20);

        s1.setCursuri(List.of(c1, c2));
        s2.setCursuri(List.of(c1,c2));

        em.getTransaction().begin();

        em.persist(s1);
        em.persist(s2);

        em.getTransaction().commit();

        em.close();
        emf.close();


    }
}
