package main;

import db.Catalog;
import db.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class Ex6 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("curs5");
        EntityManager em = emf.createEntityManager();

        Student s1 = new Student();
        Student s2 = new Student();

        s1.setNume("popescu");
        s2.setNume("ionescu");

        Catalog c = new Catalog();

        Map<Student, Integer> medii = new HashMap<>();

        medii.put(s1, 8);
        medii.put(s2, 9);
        c.setMedii(medii);



        em.getTransaction().begin();

            em.persist(s1);
            em.persist(s2);
            em.persist(c);


        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
