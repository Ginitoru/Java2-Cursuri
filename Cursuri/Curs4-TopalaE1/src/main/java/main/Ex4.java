package main;

import db.Profesor;
import db.Student;

import javax.persistence.Persistence;
import java.util.List;

public class Ex4 {
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("java2c4PU");
        var em = emf.createEntityManager();

        var prof1 = new Profesor();
        var proif2 = new Profesor();

        var student1 =new Student();
        var student2 = new Student();


        student1.getProfesori().addAll(List.of(prof1, proif2));
        student2.getProfesori().addAll(List.of(prof1, proif2));

        em.getTransaction().begin();

        em.persist(student1);
        em.persist(student2);

        em.getTransaction().commit();
        em.close();
        emf.close();



    }
}
