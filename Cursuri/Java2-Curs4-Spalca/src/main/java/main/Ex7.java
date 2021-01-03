package main;

import db.Curs;
import db.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class Ex7 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c4PU");
        EntityManager em = emf.createEntityManager();


        try{

            Curs c1 = new Curs();
            Curs c2 = new Curs();

            Student t1 = new Student();
            Student t2 = new Student();

            t1.setNume("student 1");
            c1.setNume("Curs 1");

            t1.setCursuri(new ArrayList<>());
            c1.setStudenti(new ArrayList<>());

            t1.getCursuri().add(c1);
            c1.getStudenti().add(t1);

            em.getTransaction().begin();

            em.persist(t1);
            em.persist(c1);

            em.getTransaction().commit();






        }finally{
            em.close();
            emf.close();
        }
    }


}
