package main;

import db.ex4.Student;

import javax.persistence.Persistence;

public class Ex4 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java6PU");
        var em = emf.createEntityManager();


        Student s = new Student();

        s.setNume("gigel");
        s.setPrenume("vasile");




        em.getTransaction().begin();
        em.persist(s);

        em.getTransaction().commit();



        em.close();
        emf.close();
    }
}
