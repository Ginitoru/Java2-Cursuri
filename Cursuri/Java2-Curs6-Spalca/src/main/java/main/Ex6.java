package main;

import db.ex6.Student;

import javax.persistence.Persistence;

public class Ex6 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("curs6PU");
        var em = emf.createEntityManager();

        try{

            Student s = new Student();
            s.setVarsta(20);



            s.setNume("pop");
            s.setPrenume("ion");

            em.getTransaction().begin();
            em.persist(s);
            em.getTransaction().commit();

        }finally {
            em.close();
            emf.close();
        }

    }
}
